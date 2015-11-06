package com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mc.model.Path;

import com.qx.model.Admininfo;
import com.qx.model.Loginfo;
import com.qx.utils.ConstantUtil;
import com.qx.utils.PathUtil;
import com.qx.utils.StringUtil;

@Controller
@SessionAttributes("admin")
public class LoginController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginController.class);

	String uri = "";
	private Path path = null;
	@Resource(name="adminUserService")
	private com.qx.service.ICommonUserService<Admininfo> LoginService;
	@Autowired
	private com.qx.service.ILogService logService;
	//后台管理员登录
	@RequestMapping("/login")
	public String login(String username,String password, ModelMap modelMap, HttpServletRequest request, HttpSession session)
	{
		logger.info("username = " + username + ",password = " + password);
		Admininfo admin = LoginService.findUser(username,password);	
		logger.info(admin+"222");
		String ip = StringUtil.getInstance().getIp(request);
		// 根据字符串初始化Path类
		if( admin == null?false: admin.getPassword().equals(password))
		{
			
			modelMap.addAttribute("admin", admin);
			Loginfo loginfo = new Loginfo();
			loginfo.setOperaterId(admin.getAdminId());
			loginfo.setOperaterType(ConstantUtil.ADMINTYPE);
			loginfo.setOperateValue(ConstantUtil.LOGIN);
			loginfo.setOperaterIp(ip);
			logService.add(loginfo);
			path = PathUtil.setPathParams(new String[]{"PackageName:index","ViewName:index","ViewTitle:群祥后台","smenu:index"});					
			if(uri != null && !uri.equals(""))
			{
				String path = request.getContextPath();
				uri = uri.replace(path, "");
				logger.info((Admininfo)session.getAttribute("admin"));
				return "redirect:" + uri;
			}
			return "redirect:/order/manager/1";
		}
		Loginfo loginfo = new Loginfo();
		loginfo.setOperaterIp(ip);
		loginfo.setOperaterType(ConstantUtil.ADMINTYPE);
		loginfo.setOperateValue(ConstantUtil.LOGINFAIL + ",username=" + username + "_password=" + password);
		logService.add(loginfo);
		modelMap.addAttribute("fail", "登陆失败，用户或密码错误，请联系管理员！");
		return "forward:/loginui";
	}
	/**
	 * 
	 * @param modelMap
	 * @param request
	 * @return  后台登陆界面
	 */
	@RequestMapping("/loginui")
    public String loginui(ModelMap modelMap,HttpServletRequest request)
    {
		path = PathUtil.setPathParams(new String[]{"PackageName:login","ViewName:login","ViewTitle:群祥后台","smenu:index"});
		uri = (String) request.getAttribute("uri");
		logger.info(uri);
		return "login";
    }
}
