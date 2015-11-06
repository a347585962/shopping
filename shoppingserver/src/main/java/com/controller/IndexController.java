package com.controller;

import org.apache.log4j.Logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mc.model.Path;
import com.qx.model.Level1;
import com.qx.service.ILevelOneService;
import com.qx.utils.PathUtil;

@Controller
public class IndexController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(IndexController.class);

	private Path path = null;
	@Autowired
	private ILevelOneService levelOneService;

	// 后台管理初始页面
	@RequestMapping("/index")
	public String index(ModelMap modelMap) {
		//List<Level1> levelOnes = levelOneService.findAllLevelOne();
		//logger.info(levelOnes);
		//modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:index", "ViewTitle:群祥客户端", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 订单查询
	@RequestMapping("/OrderSelect")
	public String OrderSelect(ModelMap modelMap) {
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] {
				"PackageName:OrderManager", "ViewName:OrderSelect",
				"ViewTitle:西华大学计算机与软件工程学院-首页", "smenu:AddGoods" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 订单管理
	@RequestMapping("/OrderManager")
	public String OrderManager(ModelMap modelMap) {
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] {
				"PackageName:OrderManager", "ViewName:OrderManager",
				"ViewTitle:西华大学计算机与软件工程学院-首页", "smenu:AddGoods" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 评价管理类
	@RequestMapping("/PingjiaManager")
	public String PingjiaManager(ModelMap modelMap) {
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] {
				"PackageName:OrderManager", "ViewName:PingjiaManager",
				"ViewTitle:西华大学计算机与软件工程学院-首页", "smenu:AddGoods" });
		return PathUtil.returnStr(path, modelMap);
	}
}
