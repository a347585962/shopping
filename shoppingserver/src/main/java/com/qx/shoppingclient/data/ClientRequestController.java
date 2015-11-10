package com.qx.shoppingclient.data;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mc.model.Path;
import com.qx.model.Activity;
import com.qx.model.Activitytype;
import com.qx.model.Admininfo;
import com.qx.model.Goodsinfo;
import com.qx.model.Level1;
import com.qx.model.Level2;
import com.qx.model.Level3;
import com.qx.model.Loginfo;
import com.qx.model.Orderinfo;
import com.qx.model.Userinfo;
import com.qx.service.GoodsManagerService;
import com.qx.service.ICommonService;
import com.qx.service.ILevelOneService;
import com.qx.service.ILevelThreeService;
import com.qx.service.ILevelTwoService;
import com.qx.service.ILogService;
import com.qx.service.IOrderService;
import com.qx.service.ICommonUserService;
import com.qx.service.impl.ActivityServiceImpl;
import com.qx.utils.CommonUtil;
import com.qx.utils.JsonParserUtil;
import com.qx.utils.PathUtil;
import com.qx.utils.StringUtil;

@Controller
@RequestMapping("/client")
@SessionAttributes("user")
public class ClientRequestController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ClientRequestController.class);
	private Path path = null;
	@Autowired
	private ILevelOneService levelOneService;
	@Autowired
	private ILevelTwoService levelTwoService;
	@Autowired
	private ILevelThreeService levelThreeService;
	@Autowired
	private GoodsManagerService goodsManagerService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private ILogService logService;
	@Resource(name = "activityService")
	private ActivityServiceImpl activityService;
	@Resource(name = "activityTypeService")
	private ICommonService<Activitytype> activityTypeService;
	@Resource(name = "clientUserService")
	private ICommonUserService<Userinfo> loginService;

	/**
	 * 
	 * 
	 * 初始化获取一级分类数据
	 * 
	 * @param request
	 *            请求的request
	 * @param httpSession
	 *            请求的session
	 * @return 一级分类集合的json字符串
	 */
	@RequestMapping("/levelones")
	@ResponseBody
	public String getLevelOneData(HttpServletRequest request,
			HttpSession httpSession) {
		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("user");
		Userinfo user = object == null ? null : (Userinfo) object;
		CommonUtil.getInstance().saveLog("客户端浏览商品，一级分类", ip,
				user == null ? null : user.getUserId(), logService, user == null ? null : user.getShopId());
		//List<Level1> levelOnes = levelOneService.findAllLevelOne();
		//String jsonData = JsonParserUtil.getInstance().ParseListToJSON(
			//	levelOnes);
		String jsonData = null;
		return jsonData;
	}

	/**
	 * 参数语法：key:leveloneid value:100 客户端协议：http post 模拟get请求地址:
	 * http://localhost:8080/shoppingserver/client/leveltwos?leveloneid=100
	 * 
	 * 客户端通过一级分类id浏览二级分类列表
	 * 
	 * @param id
	 *            一级分类id
	 * @param request
	 *            请求的request
	 * @param httpSession
	 *            请求的session
	 * @return 二级分类集合的json字符串
	 */
	@RequestMapping("/leveltwos")
	@ResponseBody
	public String getLevelTwoDataByLevelOneId(
			@RequestParam("leveloneid") String id, HttpServletRequest request,
			HttpSession httpSession) {

		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("user");
		Userinfo user = object == null ? null : (Userinfo) object;
		CommonUtil.getInstance().saveLog("客户端浏览二级分类，一级分类id=" + id, ip,
				user == null ? null : user.getUserId(), logService, user == null ? null : user.getShopId());
		logger.info("leveloneid = " + id);
		List<Level2> level1s = levelTwoService.findByLevelOneId((id == null
				|| id.equals("0") || id.equals("undefined")) ? null : Integer
				.parseInt(id));
		String result = JsonParserUtil.getInstance().ParseListToJSON(level1s);
		return result;
	}

	/**
	 * 参数语法：key:leveltwoid value:200 客户端协议：http post 模拟get请求地址:
	 * http://localhost:8080/shoppingserver/client/levelthree?leveltwoid=200
	 * 
	 * 客户端通过二级分类id浏览三级分类列表
	 * 
	 * @param id
	 *            二级分类id
	 * @param request
	 *            请求的request
	 * @param httpSession
	 *            请求的session
	 * @return 三级分类集合的json字符串
	 */
	@RequestMapping("/levelthree")
	@ResponseBody
	public String getLevelThree(@RequestParam("leveltwoid") String id,
			HttpServletRequest request, HttpSession httpSession) {

		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("user");
		Userinfo user = object == null ? null : (Userinfo) object;
		CommonUtil.getInstance().saveLog("客户端浏览三级分类，二级分类id=" + id, ip,
				user == null ? null : user.getUserId(), logService, user == null ? null : user.getShopId());
		logger.info("leveltwoid = " + id);
		List<Level3> level3s = levelThreeService.findByLevelTwoId((id == null
				|| id.equals("0") || id.equals("undefined")) ? null : Integer
				.parseInt(id));
		String result = JsonParserUtil.getInstance().ParseListToJSON(level3s);
		return result;
	}

	/**
	 * 参数语法：key:levelthreeid value:300 客户端协议：http post 模拟get请求地址:
	 * http://localhost:8080/shoppingserver/client/goodslist?levelthreeid=300
	 * 
	 * 客户端浏览商品
	 * 
	 * @param id
	 *            三级分类id
	 * @param request
	 *            请求客户端request
	 * @param httpSession
	 *            请求客户端session
	 * @return 商品集合
	 */
	@RequestMapping("/goodslist")
	@ResponseBody
	public String getGoodsByLevelThreeId(
			@RequestParam("levelthreeid") String id,
			HttpServletRequest request, HttpSession httpSession) {

		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("user");
		Userinfo user = object == null ? null : (Userinfo) object;
		CommonUtil.getInstance().saveLog("客户端浏览商品集合，三级分类id=" + id, ip,
				user == null ? null : user.getUserId(), logService, user == null ? null : user.getShopId());
		logger.info("levelthreeid = " + id);
		List<Goodsinfo> goodsinfos = goodsManagerService
				.findByLevelThreeId((id == null || id.equals("0") || id
						.equals("undefined")) ? null : Integer.parseInt(id));
		String result = JsonParserUtil.getInstance()
				.ParseListToJSON(goodsinfos);
		return result;
	}

	/**
	 * 参数语法：key:goodsid value:2 客户端协议：http post 模拟get请求地址:
	 * http://localhost:8080/shoppingserver/client/goodsinfo?goodsid=2
	 * 根据商品id请求商品信息
	 * 
	 * @param id
	 *            商品id
	 * @param request
	 *            请求的request
	 * @param httpSession
	 *            请求的ssion
	 * @return 商品信息json数据
	 */
	@RequestMapping("/goodsinfo")
	@ResponseBody
	public String getGoodsInfo(@RequestParam("goodsid") String id,
			HttpServletRequest request, HttpSession httpSession) {

		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("user");
		Userinfo user = object == null ? null : (Userinfo) object;
		CommonUtil.getInstance().saveLog("客户端浏览商品，商品id=" + id, ip,
				user == null ? null : user.getUserId(), logService, user == null ? null : user.getShopId());
		logger.info("levelthreeid = " + id);
		Goodsinfo goodsinfo = goodsManagerService.findById((id == null
				|| id.equals("0") || id.equals("undefined")) ? null : Integer
				.parseInt(id));
		String result = JsonParserUtil.getInstance().Obj2JsonStr(goodsinfo);
		return result;
	}

	/**
	 * 参数语法：key:userinfo value:username=18202822771&password=123456 客户端协议：http
	 * post 模拟get请求地址:
	 * http://localhost:8080/shoppingserver/client/login?username
	 * =18202822771&password=123456
	 * 
	 * @param userinfostr
	 *            用户登录信息json数据
	 * @param request
	 *            请求request
	 * @param httpSession
	 *            请求session
	 * @param modelMap
	 * @return 返回的json数据集合
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String pwd, HttpServletRequest request,
			HttpSession httpSession, ModelMap modelMap) {

		String ip = StringUtil.getInstance().getIp(request);
		Userinfo userinfo = loginService.findUserByName(username);
		logger.info("username = " + username + ",pwd = " + pwd);
		if (loginService.loginCheck(userinfo, pwd)) {
			modelMap.addAttribute("user", userinfo);
			CommonUtil.getInstance().saveLog(
					"客户端登陆成功，用户id=" + userinfo.getUserId(), ip,
					userinfo == null ? null : userinfo.getUserId(), logService, 
							userinfo == null ? null : userinfo.getShopId());
			return "{\"loginsuccess\":\"true\"}";
		}
		CommonUtil.getInstance().saveLog(
				"客户端登陆失败，用户username=" + username + "_pwd=" + pwd, ip,
				userinfo == null ? null : userinfo.getUserId(), logService
						, userinfo == null ? null : userinfo.getShopId());
		return "{\"loginsuccess\":\"false\"}";
	}

	@RequestMapping("/order")
	@ResponseBody
	public String order(@RequestParam("orderjson") String orderJson,
			HttpServletRequest request, HttpSession httpSession) {
		logger.info("come in!");
		logger.info("orderjson = " + orderJson);
		try {
			Orderinfo orderinfo = (Orderinfo) JsonParserUtil.getInstance()
					.jsonToBean(orderJson, Orderinfo.class);
			Userinfo userinfo = loginService.selectByPrimaryKey(1000000003);
			logger.info("userinfo = " + String.valueOf(userinfo));
			orderinfo.setUserinfo(userinfo);
			logger.info(String.valueOf(orderinfo));
			orderService.save(orderinfo);
			orderService.saveSubOrders(orderinfo == null ? null : orderinfo
					.getSuborders());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"ordersuccess\":\"true\"}";
	}

	/**
	 * 参数语法：key:activityid value:1 客户端协议：http post 模拟get请求地址:
	 * http://localhost:8080/shoppingserver/client/activity?activityid=1
	 * 
	 * 
	 * @param activityid
	 *            活动id的json
	 * @param request
	 *            请求request
	 * @param httpSession
	 *            请求session
	 * @return json数据
	 */
	@RequestMapping("/activity")
	@ResponseBody
	public String activity(@RequestParam("activityid") String activityid,
			HttpServletRequest request, HttpSession httpSession) {

		Activity activity = activityService.findById(activityid == null ? null
				: Integer.parseInt(activityid));
		String result = JsonParserUtil.getInstance().Obj2JsonStr(activity);
		return result;
	}

	/**
	 * 参数语法：key:goodsname value:1 客户端协议：http post 模拟get请求地址:
	 * http://localhost:8080/shoppingserver/client/findgoods?goodsname=杯子
	 * 
	 * @param goodsname
	 *            商品名称json
	 * @param request
	 *            请求request
	 * @param httpSession
	 *            请求sesssion
	 * @return 商品集合的json数据
	 */
	@RequestMapping("/findgoods")
	@ResponseBody
	public String findgoods(@RequestParam("goodsname") String goodsname,
			HttpServletRequest request, HttpSession httpSession) {

		List<Goodsinfo> goodsinfos = goodsManagerService
				.selectByNameLike(goodsname);
		logger.info(String.valueOf(goodsinfos));
		String result = JsonParserUtil.getInstance()
				.ParseListToJSON(goodsinfos);
		return result;
	}

	/*
	 * @RequestMapping("/index")
	 * 
	 * @ResponseBody public String index() { List<Activitytype> activitytypes =
	 * activityTypeService.findAll();
	 * logger.info(String.valueOf(activitytypes)); Map<String, Object> map = new
	 * HashMap<String, Object>(); for (Iterator iterator =
	 * activitytypes.iterator(); iterator.hasNext();) { Activitytype
	 * activitytype = (Activitytype) iterator.next(); List<Activity> activities
	 * = activityService.findByType(activitytype .getActivitytypeId());
	 * map.put(activitytype.getActivitytypeNickname(), activities); }
	 * List<Level1> levelOnes = levelOneService.findAllLevelOne();
	 * map.put("levelones", levelOnes); Set<String> set = map.keySet(); for
	 * (Iterator<String> it = set.iterator(); it.hasNext();) { String key =
	 * it.next(); System.out.println(key + ":" + map.get(key)); } return
	 * JsonParserUtil.getInstance().Obj2JsonStr(map); }
	 */

	// 后台管理初始页面
	@RequestMapping("/index")
	public String index(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:index", "ViewTitle:群祥客户端", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/center")
	public String center(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:center", "ViewTitle:个人中心", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/address")
	public String address(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:center-address", "ViewTitle:地址列表", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/addressadd")
	public String addressadd(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil
				.setPathParams(new String[] { "PackageName:front",
						"ViewName:center-address-add", "ViewTitle:新增地址",
						"smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/myfaverite")
	public String myfaverite(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil
				.setPathParams(new String[] { "PackageName:front",
						"ViewName:center-myfaverate", "ViewTitle:我的收藏",
						"smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/mytickets")
	public String mytickets(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil
				.setPathParams(new String[] { "PackageName:front",
						"ViewName:center-mytickets", "ViewTitle:群祥客户端",
						"smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/orderinfo")
	public String orderinfo(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil
				.setPathParams(new String[] { "PackageName:front",
						"ViewName:center-orderinfo", "ViewTitle:订单详情",
						"smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/findpwshow")
	public String findpwshow(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:findpwdone", "ViewTitle:修改密码", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/findpwd")
	public String findpwd(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:findpwdtwo", "ViewTitle:修改密码", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/info")
	public String goodsinfo(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:infor", "ViewTitle:商品信息", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/list")
	public String list(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:list", "ViewTitle:商品列表", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/loginui")
	public String loginui(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:login", "ViewTitle:登陆", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/pingjia")
	public String pingjia(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:pingjia", "ViewTitle:商品评价", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/moreinfo")
	public String moreinfo(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:more_infor", "ViewTitle:商品信息详细", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/register")
	public String register(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:register", "ViewTitle:注册", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/search")
	public String search(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:search", "ViewTitle:商品查询", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/shop")
	public String shop(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:shop", "ViewTitle:购物车", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/shopsubmit")
	public String shopsubmit(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:gosubmit", "ViewTitle:提交订单", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/changeaddress")
	public String changeaddress(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:changeaddress", "ViewTitle:修改收货地址", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/editaddress")
	public String editaddress(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:editaddress", "ViewTitle:新增收货地址", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}

	// 后台管理初始页面
	@RequestMapping("/shopsuccess")
	public String shopsuccess(ModelMap modelMap) {
		// List<Level1> levelOnes = levelOneService.findAllLevelOne();
		// logger.info(levelOnes);
		// modelMap.addAttribute("levelsones", levelOnes);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] { "PackageName:front",
				"ViewName:shopsuccess", "ViewTitle:订单成功", "smenu:index" });
		return PathUtil.returnStr(path, modelMap);
	}
}
