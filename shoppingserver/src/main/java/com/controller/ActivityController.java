package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mc.model.Path;
import com.qx.model.Activity;
import com.qx.model.Activitytype;
import com.qx.model.Admininfo;
import com.qx.model.Goodsinfo;
import com.qx.service.ICommonService;
import com.qx.service.ILogService;
import com.qx.utils.CommonUtil;
import com.qx.utils.FileUtil;
import com.qx.utils.PathUtil;
import com.qx.utils.PropertiesUtil;
import com.qx.utils.StringUtil;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ActivityController.class);

	@Resource(name="activityService")
	private ICommonService<Activity> activityService;
	@Resource(name="activityTypeService")
	private ICommonService<Activitytype> activityTypeService;
    @Autowired
	private ILogService logService;
	private Path path = null;
	String sMenu = "activity";
	Integer pagenow;
	@RequestMapping("/addui")
	public String addui(ModelMap modelMap)
	{
		List<Activitytype> activitytypes = activityTypeService.findAll();
		modelMap.addAttribute("activitytypes", activitytypes);
		path = PathUtil.setPathParams(new String[] {
				"PackageName:activity", "ViewName:addactivity",
				"ViewTitle:活动管理--添加活动", "smenu:" + sMenu ,"mmenu:addactivity"});
		return PathUtil.returnStr(path, modelMap);
	}
	@RequestMapping("/add")
	public String add(Activity activity, ModelMap modelMap, @RequestParam(value = "files", required = false) MultipartFile [] files
		, String rangetime	, HttpServletRequest request, HttpSession httpSession)
	{
		
		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("admin");
		Admininfo admin = object == null? null:(Admininfo)object;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		logger.info("rangetime = " + rangetime);
		String dates [] = {}; 
		String start = "";
		String end = "";
		if (rangetime != null || rangetime.isEmpty())
		{
			dates = rangetime.split("/");
			start = dates[0].trim();
			end = dates[1].trim();
			logger.info("start = " + dates[0].trim() + ",end = " + dates[1].trim());
		    try {
				activity.setActivityStart(df.parse(start));
				activity.setActivityEnd(df.parse(end));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		String imagePaths = FileUtil.getInstance().uploadFiels(files);
		logger.info("imagepath = "  + imagePaths);
		if(activity != null){
			activity.setActivityImg(imagePaths);
			logger.info(String.valueOf(activity));
			activityService.add(activity);
			CommonUtil.getInstance().saveLog("添加活动信息，商品id=" + activity.getActivityId(), ip, admin == null?null:admin.getAdminId(), logService);
			modelMap.addAttribute("success", "您的更新操作成功！");
			if (activity.getActivityId() != null)
			{
				modelMap.addAttribute("success", "您的活动添加操作成功！");
				return "forward:/activity/manager/1";
			}
		}
		CommonUtil.getInstance().saveLog("添加活动信息出错", ip, admin == null?null:admin.getAdminId(), logService);
		modelMap.addAttribute("success", "您的更新操作成功！");
		return "forward:/activity/manager/1";
	}
	
	@RequestMapping("/manager/{pagenow}")
	public String manager(ModelMap modelMap, Integer pageNow)
	{
		int pagesize = 10;
		pagenow = pageNow == null ? 1: pageNow;
		List<Activity> activities = activityService.findByPage(pagenow, pagesize);
		modelMap.addAttribute("activities", activities);
		Integer pagecount = activityService.sizeoflist();
		modelMap.addAttribute("pagecount", (pagecount % pagesize) == 0?(pagecount / pagesize) : ((pagecount / pagesize) + 1));
		modelMap.addAttribute("pagenow", pagenow);
		path = PathUtil.setPathParams(new String[] {
				"PackageName:activity", "ViewName:activitymanager",
				"ViewTitle:活动管理--添加活动", "smenu:" + sMenu ,"mmenu:activitymanager"});
		return PathUtil.returnStr(path, modelMap);
	}
	@RequestMapping("/updateui/{activityid}")
	public String updateui(ModelMap modelMap, @PathVariable("activityid") Integer activiid)
	{
		Activity activity = activityService.findById(activiid);
		String imageUrlStr = activity.getActivityImg();
		List<Activitytype> activitytypes = activityTypeService.findAll();
		modelMap.addAttribute("activitytypes", activitytypes);
		String [] imageUrls =  ((imageUrlStr == null || imageUrlStr.isEmpty())?null:imageUrlStr.split(PropertiesUtil.getInstace().getFileProperties("image.regex")));
		modelMap.addAttribute("imgs", imageUrls);
		modelMap.addAttribute("activity", activity);
		logger.info(String.valueOf(activity));
		path = PathUtil.setPathParams(new String[] {
				"PackageName:activity", "ViewName:updateactivity",
				"ViewTitle:活动管理--修改活动", "smenu:" + sMenu ,"mmenu:update"});
		return PathUtil.returnStr(path, modelMap);
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/update")
	public String update(Activity activity, ModelMap modelMap, @RequestParam(value = "files", required = false) MultipartFile [] files
    		
			, String rangetime, HttpServletRequest request, HttpSession httpSession
			) {
		
		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("admin");
		Admininfo admin = object == null? null:(Admininfo)object;
		Activity oldactivity = activityService.findById(activity == null?null:activity.getActivityId());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String imagePaths = FileUtil.getInstance().uploadFiels(files);
		if (rangetime == null || rangetime.isEmpty())
		{
			activity.setActivityStart(oldactivity.getActivityStart());
			activity.setActivityEnd(oldactivity.getActivityEnd());
		}
		else 
		{
			String dates [] = {}; 
			String start = "";
			String end = "";
			if (rangetime != null)
			{
				dates = rangetime.split("/");
				start = dates[0].trim();
				end = dates[1].trim();
				logger.info("start = " + dates[0].trim() + ",end = " + dates[1].trim());
			    try {
					activity.setActivityStart(df.parse(start));
					activity.setActivityEnd(df.parse(end));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
		if (imagePaths == null || imagePaths.isEmpty())
			activity.setActivityImg(oldactivity.getActivityImg());
		else 
		{
			activity.setActivityImg(imagePaths);
		}
		if(activity != null){
			
			activityService.update(activity);
			CommonUtil.getInstance().saveLog("修改活动信息，活动id=" + activity.getActivityId(), ip, admin == null?null:admin.getAdminId(), logService);
			modelMap.addAttribute("success", "您的更新操作成功！");
			return "forward:/activity/manager/1";
		}
		CommonUtil.getInstance().saveLog("修改活动信息出错，活动id=" + activity.getActivityId(), ip, admin == null?null:admin.getAdminId(), logService);
		modelMap.addAttribute("success", "操作失败，请检查原因！");
		return "forward:/activity/manager/1";
	}
}
