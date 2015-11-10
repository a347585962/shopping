package com.controller;

import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mc.model.Path;
import com.qx.model.Goodsinfo;
import com.qx.model.Property;
import com.qx.model.Shop;
import com.qx.service.impl.PropertyServiceImpl;
import com.qx.service.impl.ShopServiceImpl;
import com.qx.utils.CommonUtil;
import com.qx.utils.ConstantUtil;
import com.qx.utils.PathUtil;

@Controller
@RequestMapping("/property")
public class PropertyController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PropertyController.class);

	private Path path = null;
	@Resource(name="propertyService")
	private PropertyServiceImpl propertyService;
	@Resource(name="shopService")
	private ShopServiceImpl shopService;
	private String sMenu = "goods";
	@RequestMapping("/show")
	public String showAllProperties(ModelMap modelMap, HttpSession session)
	{
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		List<Property> properties = propertyService.findAllByShopId(shopId);
		modelMap.addAttribute("properties", properties);
		//logger.info("shopId = " + shopId);
		Shop shop = shopService.findById(shopId);
		//logger.info(shop);
		modelMap.addAttribute("shop", shop);
		List<Property> nonactiveproperties = propertyService.findAllNonActiveByShopId(shopId);
		modelMap.addAttribute("nonactiveproperties", nonactiveproperties);
		path = PathUtil.setPathParams(new String[] {
				"PackageName:property", "ViewName:propertymanager",
				"ViewTitle:商品管理--商品属性管理", "smenu:" + sMenu ,"mmenu:search" });
		return PathUtil.returnStr(path, modelMap);
	}
	
	@RequestMapping("/add")
	
	public String add(ModelMap modelMap, String propertyName
			, HttpSession session)
	{
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		Shop shop = shopService.findById(shopId);
		Property property = new Property();
		String proName = ConstantUtil.PREFNEWPROPERTY + "_" +  Calendar.getInstance().getTimeInMillis();
		property.setPropertyName(proName);
		property.setPropertyShowname(propertyName);
		property.setPropertyStatus(1);
		property.setPropertyType("input");
		
		
		property.setShopId(shopId );
		propertyService.add(property);
		return "forward:show";
	}
	
	@RequestMapping("/delete/{pid}")
	@ResponseBody
	public String delete(ModelMap modelMap, @PathVariable("pid")Integer pid,
			HttpSession session, HttpServletRequest request)
	{
	
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		Property property = propertyService.findByIdAndShopId(pid, shopId);
		property.setPropertyStatus(0);
		propertyService.update(property);
		String callbackFunName = request.getParameter("callbackparam");
		return callbackFunName + "(" + "{'success':true}" + ")";
	}
	@RequestMapping("/active/{pid}")
	@ResponseBody
	public String active(ModelMap modelMap, @PathVariable("pid")Integer pid,
			HttpSession session, HttpServletRequest request)
	{
	
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		Property property = propertyService.findByIdAndShopId(pid, shopId);
		property.setPropertyStatus(1);
		propertyService.update(property);
		String callbackFunName = request.getParameter("callbackparam");
		return callbackFunName + "(" + "{'success':true}" + ")";
	}
}
