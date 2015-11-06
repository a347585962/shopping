package com.controller;

import org.apache.log4j.Logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mc.model.Path;
import com.qx.model.Goodsinfo;
import com.qx.model.Userinfo;
import com.qx.service.IOrderService;
import com.qx.utils.JsonParserUtil;
import com.qx.utils.PathUtil;

@Controller
@RequestMapping("/analysis")
public class SalesAnalysisController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SalesAnalysisController.class);

	private Path path = null;
	private String sMenu = "analysis";
	@Autowired
	private IOrderService orderService;
	@RequestMapping("/toptenperson")
	public String toptenperson(ModelMap modelMap)
	{
	    List<Userinfo> userinfos = orderService.topTenPerson(null, null);
	    String jsonData = JsonParserUtil.getInstance().ParseListToJSON(userinfos);
	    logger.info(jsonData);
	    modelMap.addAttribute("jsonData", jsonData);
		path = PathUtil.setPathParams(new String[]{"PackageName:salesanalysis","ViewName:toptenperson","ViewTitle:购买最多的前十名","smenu:" + sMenu});
		return PathUtil.returnStr(path, modelMap);
	}
	@RequestMapping("/toptengoods")
	public String toptengoods(ModelMap modelMap)
	{
	    List<Goodsinfo> goodsinfos = orderService.topTenGoods(null, null);
	    String jsonData = JsonParserUtil.getInstance().ParseListToJSON(goodsinfos);
	    logger.info(jsonData);
	    modelMap.addAttribute("jsonData", jsonData);
		path = PathUtil.setPathParams(new String[]{"PackageName:salesanalysis","ViewName:toptengoods","ViewTitle:购买最多的前十名","smenu:" + sMenu});
		return PathUtil.returnStr(path, modelMap);
	}
}
