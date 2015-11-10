package com.controller;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mc.model.Path;
import com.qx.dao.LoginDao;
import com.qx.dao.impl.LoginDaoImpl;
import com.qx.model.Admininfo;
import com.qx.model.Shop;
import com.qx.service.ICommonUserService;
import com.qx.service.impl.LoginServiceImpl;
import com.qx.service.impl.ShopServiceImpl;
import com.qx.utils.CommonUtil;
import com.qx.utils.PathUtil;
@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserController.class);

	private Path path; 
	@Resource(name="adminUserService")
	private LoginServiceImpl userService;
	@Resource(name="shopService")
	private ShopServiceImpl shopService;
	
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
	public String adduser(ModelMap modelMap, Admininfo user
			, HttpSession session) {
		user.setRegisterTime(new Date());
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		user.setAdminStatus(1);
		user.setShopId(shopId);
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
	public String updateuserui(ModelMap modelMap,
			@PathVariable("id") int id, HttpSession session) {
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		Admininfo user = userService.selectByPrimaryKey(id, shopId);
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
	public String updateuser(ModelMap modelMap, Admininfo user, HttpSession session) {
		user.setRegisterTime(new Date());
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		user.setAdminStatus(1);
		user.setShopId(shopId);
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
	public String usermag(ModelMap modelMap, HttpSession session) {
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		List<Admininfo> users = userService.findAllByShopId(shopId);
		for (int i = 0; i < users.size(); i++) {
			Admininfo user = users.get(i);
			shopId = user.getShopId();
			Shop shop = null;
			if (shopId != null && shopId != 0)
			{
				shop = shopService.findById(shopId);
			}
			user.setShop(shop);
			users.set(i, user);
		}
		modelMap.addAttribute("users", users);
		path = PathUtil.setPathParams(new String[] { "PackageName:user",
				"ViewName:mgusers", "ViewTitle:管理管理员", "smenu:" + sMenu ,"mmenu:mag" });
		return PathUtil.returnStr(path, modelMap);
	}
	/**
	 * 用户管理
	 * 
	 * @param modelMap
	 * @return 用户管理界面链接
	 */
	@RequestMapping("/allusermag")
	public String allusermag(ModelMap modelMap, HttpSession session) {
		//Integer shopId = CommonUtil.getInstance().getShopId(session);
		List<Admininfo> users = userService.findAll();
		for (int i = 0; i < users.size(); i++) {
			Admininfo user = users.get(i);
			Integer shopId = user.getShopId();
			Shop shop = null;
			if (shopId != null && shopId != 0)
			{
				shop = shopService.findById(shopId);
			}
			
			user.setShop(shop);
			users.set(i, user);
		}
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
	@RequestMapping("/deluser/{id}")
	public String deluser(@PathVariable("id") int id, ModelMap modelMap,
			HttpServletRequest request) {
		Admininfo user = userService.selectByPrimaryKey(id);
		userService.delete(user);
		return "forward:/user/usermag";
		
	}

	/**
	 * 商家管理
	 * 
	 * @param modelMap
	 * @return 商家管理界面链接
	 */
	@RequestMapping("/shopmag")
	public String shopmag(ModelMap modelMap, HttpSession session) {
		
		List<Shop> shops = shopService.findAll();
		modelMap.addAttribute("shops", shops);
		path = PathUtil.setPathParams(new String[] { "PackageName:user",
				"ViewName:mgshops", "ViewTitle:管理商家信息", "smenu:" + sMenu ,"mmenu:mag" });
		return PathUtil.returnStr(path, modelMap);
	}
	/**
	 * 
	 * @param modelMap
	 * @param user
	 *            用户对象
	 * @return 管理用户界面链接
	 */
	@RequestMapping("/addshop")
	public String addShop(ModelMap modelMap, Shop shop
			, HttpSession session) {
		shop.setDate(new Date());
		logger.info("shop = " + shop);
		//shop.setShopStatus(0);
		shopService.add(shop);
		return "forward:/user/shopmag";
	}
	/**
	 * 
	 * @param modelMap
	 * @param user
	 *            用户对象
	 * @return 管理用户界面链接
	 */
	@RequestMapping("/updateshop")
	public String updateshop(ModelMap modelMap, Shop shop
			, HttpSession session) {
		shop.setDate(new Date());
		logger.info(shop);
		//shop.setShopStatus(0);
		shopService.update(shop);
		return "forward:/user/shopmag";
	}
	/**
	 * 更新用户信息
	 * 
	 * @param modelMap
	 * @param user
	 *            用户对象实例
	 * @return
	 */
	@RequestMapping("/updatealluser")
	public String updatealluser(ModelMap modelMap, Admininfo user, HttpSession session) {
		user.setRegisterTime(new Date());
		logger.info("user = " + user);
		user.setAdminStatus(1);
		userService.update(user);
		
		return "forward:/user/allusermag";
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
	@RequestMapping("/delalluser/{id}")
	public String delalluser(@PathVariable("id") int id, ModelMap modelMap,
			HttpServletRequest request) {
		Admininfo user = userService.selectByPrimaryKey(id);
		userService.delete(user);
		return "forward:/user/allusermag";
		
	}
}
