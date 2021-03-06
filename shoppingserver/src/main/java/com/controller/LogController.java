package com.controller;

import org.apache.log4j.Logger;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mc.model.Path;
import com.qx.model.Loginfo;
import com.qx.model.Orderinfo;
import com.qx.utils.CommonUtil;
import com.qx.utils.PathUtil;

@Controller
@RequestMapping("/log")
public class LogController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LogController.class);

	private String sMenu = "log";
	@Autowired
	private com.qx.service.ILogService logService;
	private Path path = null;
	Integer pagenow;
	@RequestMapping("/look/{pagenow}")
	public String look(ModelMap modelMap, 
			@PathVariable("pagenow") Integer pageNow, 
			HttpSession session)
	{
		int pagesize = 17;
		pagenow = pageNow == null ? 1: pageNow;
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		List<Loginfo> loginfos = logService.findByPage(pageNow, pagesize, shopId); 
		Integer pagecount = logService.findLogSize(shopId);
		logger.info("loginfos = " + loginfos);
		modelMap.addAttribute("loginfos", loginfos); 
		modelMap.addAttribute("pagecount", (pagecount % pagesize) == 0?(pagecount / pagesize) : ((pagecount / pagesize) + 1));
		modelMap.addAttribute("pagenow", pagenow);
		path = PathUtil.setPathParams(new String[]{"PackageName:log","ViewName:log","ViewTitle:群祥日志查看","smenu:" + sMenu});
		return PathUtil.returnStr(path, modelMap);
	}
	@RequestMapping("/detail/{logid}")
	public String detail(@PathVariable("logid") Integer logid, ModelMap modelMap
			, HttpSession session)
	{
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		Loginfo loginfo = logService.selectByPrimaryId(logid, shopId);
		modelMap.addAttribute("loginfo", loginfo);
		path = PathUtil.setPathParams(new String[]{"PackageName:log","ViewName:detail","ViewTitle:群祥日志查看","smenu:" + sMenu});
		return PathUtil.returnStr(path, modelMap);
	}
}
