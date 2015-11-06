package com.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mc.model.Path;
import com.qx.dao.LoginDao;
import com.qx.model.Admininfo;
import com.qx.service.ICommonUserService;
import com.qx.utils.PathUtil;
@Controller
@RequestMapping("/user")
public class UserController {

	private Path path; 
	@Resource(name="adminUserService")
	private ICommonUserService<Admininfo> userService;
	String sMenu = "user";
	/**
	 * 
	 * @param modelMap
	 * @return 添加用户的界面
	 */
	@RequestMapping("/adduserui")
	public String adduserui(ModelMap modelMap) {

		path = PathUtil.setPathParams(new String[] { "PackageName:user",
				"ViewName:adduser", "ViewTitle:添加管理员", "smenu:" + sMenu ,"mmenu:add"  });
		return PathUtil.returnStr(path, modelMap);
	}
	/**
	 * 
	 * @param modelMap
	 * @param user
	 *            用户对象
	 * @return 管理用户界面链接
	 */
	@RequestMapping("/adduser")
	public String adduser(ModelMap modelMap, Admininfo user) {
		user.setRegisterTime(new Date());
		userService.add(user);
		
		return "forward:/user/usermag";
	}

	/**
	 * 
	 * @param modelMap
	 * @param id
	 *            需要更新用户id
	 * @return 管理用户的界面
	 */
	@RequestMapping("/updateuserui/{id}")
	public String updateuserui(ModelMap modelMap, @PathVariable("id") int id) {
		Admininfo user = userService.selectByPrimaryKey(id);
		modelMap.addAttribute("user", user);
		path = PathUtil.setPathParams(new String[] { "PackageName:user",
				"ViewName:updateuser", "ViewTitle:修改管理员信息", "smenu:" + sMenu ,"mmenu:update" });
		return PathUtil.returnStr(path, modelMap);
	}

	/**
	 * 更新用户信息
	 * 
	 * @param modelMap
	 * @param user
	 *            用户对象实例
	 * @return
	 */
	@RequestMapping("/updateuser")
	public String updateuser(ModelMap modelMap, Admininfo user) {
		user.setRegisterTime(new Date());
		userService.update(user);
		
		return "forward:/user/usermag";
	}

	/**
	 * 用户管理
	 * 
	 * @param modelMap
	 * @return 用户管理界面链接
	 */
	@RequestMapping("/usermag")
	public String usermag(ModelMap modelMap) {
		List<Admininfo> users = userService.findAll();
		modelMap.addAttribute("users", users);
		path = PathUtil.setPathParams(new String[] { "PackageName:user",
				"ViewName:mgusers", "ViewTitle:管理管理员", "smenu:" + sMenu ,"mmenu:mag" });
		return PathUtil.returnStr(path, modelMap);
	}

	/**
	 * ajax删除用户
	 * 
	 * @param id
	 *            用户id
	 * @param modelMap
	 * @param request
	 * @return 删除状态字符串
	 */
	@RequestMapping("/deluser")
	@ResponseBody
	public String deluser(@RequestParam("id") int id, ModelMap modelMap,
			HttpServletRequest request) {
		Admininfo user = userService.selectByPrimaryKey(id);
		userService.delete(user);
		String callbackFunName = request.getParameter("callbackparam");
		return callbackFunName + "(" + "{'success':true}" + ")";
		
	}

}
