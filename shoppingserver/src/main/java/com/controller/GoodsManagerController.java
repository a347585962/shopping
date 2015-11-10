package com.controller;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.springframework.web.multipart.MultipartFile;

import com.mc.model.Path;
import com.qx.dao.GoodsManagerDao;
import com.qx.model.Activity;
import com.qx.model.Admininfo;
import com.qx.model.Goodsinfo;
import com.qx.model.Level1;
import com.qx.model.Level2;
import com.qx.model.Level3;
import com.qx.model.Loginfo;
import com.qx.model.Property;
import com.qx.model.Propertyvalue;
import com.qx.model.Shop;
import com.qx.model.Shopgoods;
import com.qx.service.GoodsManagerService;
import com.qx.service.ICommonService;
import com.qx.service.ILevelOneService;
import com.qx.service.ILevelThreeService;
import com.qx.service.ILevelTwoService;
import com.qx.service.ILogService;
import com.qx.service.impl.PropertyServiceImpl;
import com.qx.service.impl.PropertyValueServiceImpl;
import com.qx.service.impl.ShopGoodsServiceImpl;
import com.qx.service.impl.ShopServiceImpl;
import com.qx.utils.CommonUtil;
import com.qx.utils.ConstantUtil;
import com.qx.utils.FileUtil;
import com.qx.utils.JsonParserUtil;
import com.qx.utils.PathUtil;
import com.qx.utils.PropertiesUtil;
import com.qx.utils.StringUtil;
import com.qx.utils.XlsUtil;
//商品管理
@Controller
@RequestMapping("/goodsmanager")
public class GoodsManagerController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GoodsManagerController.class);
	

	private Path path = null;
	@Autowired
	private GoodsManagerService goodsManagerService;
	@Autowired
	private ILevelOneService levelOneService;
	@Autowired
	private ILevelTwoService levelTwoService;
	@Autowired
	private ILevelThreeService levelThreeService;
	@Autowired
	private ILogService logService;
	private Integer pagenow;
	private String sMenu = "goods";
	@Resource(name="activityService")
	private ICommonService<Activity> activityService;
	@Resource(name="propertyService")
	private PropertyServiceImpl propertyServiceImpl;
	@Resource(name="shopService")
	private ShopServiceImpl shopServiceImpl;
	@Resource(name="shopGoodsService")
	private ShopGoodsServiceImpl shopGoodsService;
	@Resource(name="propertyValueService")
	private PropertyValueServiceImpl propertyValueService;
	private String GOODSID;
	private Integer SEARCHPAGENOW;
	private String ISUP;
	private String LEVELONE;
	private String LEVELTWO;
	private String LEVELTHREE;
	private Integer SEARCHROWCOUNT;
	private String GOODSNAME;
	private String BARCODE;
	@RequestMapping("/search/{pagenow}")
	public String search(@PathVariable("pagenow")Integer pageNow, String goodsid, String isup
			, String levelone, String leveltwo, String levelthree, HttpServletRequest request
			,HttpSession httpSession, ModelMap modelMap, String barcode, String goodsname)
	{
		//logger.info(goodsid + "," + isup + "," + levelone + "," + leveltwo + "," + levelthree);
		if ((goodsid == null || goodsid.isEmpty()) && (isup == null || isup.isEmpty()) &&
				(levelone == null || levelone.isEmpty()) && (leveltwo == null || leveltwo.isEmpty())
				&& (levelthree == null || levelthree.isEmpty())
				&& (barcode == null || barcode.isEmpty())
				&& (goodsname == null || goodsname.isEmpty()))
		{
			
		}
		else {
			GOODSID = goodsid;
			ISUP = isup;
			LEVELONE = levelone;
			LEVELTWO = leveltwo;
			LEVELTHREE = levelthree;
			GOODSNAME = goodsname;
			BARCODE = barcode;
			 
		}
		
		Integer shopId = CommonUtil.getInstance().getShopId(httpSession);
		SEARCHROWCOUNT = goodsManagerService.sizeofAllSearch(GOODSID, ISUP, LEVELONE, LEVELTWO, 
				LEVELTHREE, BARCODE, GOODSNAME, shopId );
		//logger.info(SEARCHROWCOUNT);
		SEARCHPAGENOW = (pageNow == null || pageNow == 0)?1:pageNow;
		int pagesize = 10;
		
		List<Level1> level1s = levelOneService.findAllLevelOne(shopId);
		modelMap.addAttribute("level1s", level1s);
		List<Shopgoods> goodsinfos = goodsManagerService.searchByMap(GOODSID, ISUP, LEVELONE, LEVELTWO,
				LEVELTHREE, BARCODE, GOODSNAME, SEARCHPAGENOW, pagesize , shopId);
		//logger.info(goodsinfos);
		modelMap.addAttribute("pagecount", (SEARCHROWCOUNT % pagesize) == 0?(SEARCHROWCOUNT / pagesize) : ((SEARCHROWCOUNT / pagesize) + 1));
		modelMap.addAttribute("pagenow", SEARCHPAGENOW);
		modelMap.addAttribute("goodsinfos", goodsinfos);
		path = PathUtil.setPathParams(new String[] {
				"PackageName:goodsmanager", "ViewName:search",
				"ViewTitle:商品管理--商品上线管理", "smenu:" + sMenu ,"mmenu:search" });
		return PathUtil.returnStr(path, modelMap);
	}
	
	// 商品上线管理--添加商品
	@RequestMapping("/addview")
	public String AddGoods(ModelMap modelMap, HttpSession session) {
		// 根据字符串初始化Path类
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		List<Level1> level1s = levelOneService.findAllLevelOne(shopId);
		//Shop shop = shopServiceImpl.findById(shopId);
		List<Property> properties = propertyServiceImpl.findAllByShopId(shopId);
		List<Activity> activities = activityService.findAll();
		//logger.info(String.valueOf(activities));
		modelMap.addAttribute("properties", properties);
		modelMap.addAttribute("activities", activities);
		modelMap.addAttribute("level1s", level1s);
		path = PathUtil.setPathParams(new String[] {
				"PackageName:goodsmanager", "ViewName:addgoods",
				"ViewTitle:商品管理--商品上线管理", "smenu:" + sMenu ,"mmenu:add" });
		return PathUtil.returnStr(path, modelMap);
	}
	
	//添加商品
	@SuppressWarnings("unused")
	@RequestMapping("/submitview")
	public String AddGoods1(Goodsinfo goodsinfo, ModelMap modelMap, 
			@RequestParam(value = "files", required = false) MultipartFile [] files
    		,HttpServletRequest request, HttpSession httpSession
			) {
		Enumeration<String> requestParams = request.getParameterNames();
		Integer shopId = CommonUtil.getInstance().getShopId(httpSession);
		
		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("admin");
		Admininfo admin = object == null? null:(Admininfo)object;
		String imagePaths = FileUtil.getInstance().uploadFiels(files);
		goodsinfo.setPhotoUrl(imagePaths);
		if(goodsinfo!=null){
			goodsinfo.setUpdateTime(new Date());
			logger.info(String.valueOf(goodsinfo));
			goodsManagerService.addgoods(goodsinfo);
			logger.info("goodsid = " + goodsinfo.getGoodsId());
			Shopgoods shopgoods = new Shopgoods();
			shopgoods.setGoodsinfo(goodsinfo);
			shopgoods.setShopgoodsStatus(1);
			shopgoods.setDate(new Date());
			shopgoods.setShopId(shopId);
			String activityid = request.getParameter("activityId");
			if (activityid != null)
			{
				shopgoods.setActivityId(Integer.parseInt(activityid.trim()));
			}
			shopGoodsService.add(shopgoods);
			logger.info("shopgoodsid = " + shopgoods.getShopgoodsId());
			List<Propertyvalue> propertyvalues = new LinkedList<Propertyvalue>();
			while (requestParams.hasMoreElements()) {
				String attr = requestParams.nextElement();
				if (attr.contains(ConstantUtil.PREFNEWPROPERTY))
				{
					logger.info("newattr = " + request.getParameter(attr));
					Property property = propertyServiceImpl.findByShopIdAndName(attr, shopId);
					Propertyvalue propertyvalue = new Propertyvalue();
					propertyvalue.setPropertyStatus(1);
					propertyvalue.setPropertyId(property.getPropertyId());
					propertyvalue.setPropertyvalueValue(request.getParameter(attr));
					propertyvalue.setShopgoodsId(shopgoods.getShopgoodsId());
					propertyvalues.add(propertyvalue);
				}
				logger.info(attr);
			}
			propertyValueService.addAll(propertyvalues);
			CommonUtil.getInstance().saveLog("新增商品，商品id=" + goodsinfo.getGoodsId(),
					ip, admin == null?null:admin.getAdminId(), logService, admin == null?null:admin.getShopId());
			modelMap.addAttribute("success", "您的新增商品操作成功！");
			return "forward:goodsinfoview/1";
		}
		CommonUtil.getInstance().saveLog("新增商品失败，商品id=" + String.valueOf(goodsinfo),
				ip, admin == null?null:admin.getAdminId(), logService, admin == null?null:admin.getShopId());
		modelMap.addAttribute("success", "您的新增商品操作失败！");
		return "forward:goodsinfoview/1";
	}
	
	// 商品上线管理--批量导入
	@RequestMapping("/importview")
	public String ImportGoods(ModelMap modelMap, @RequestParam(value = "excelfile", required = true)
	MultipartFile excelfile, HttpServletRequest request, HttpSession httpSession) {
		InputStream in = null;
		try {
			in = excelfile.getInputStream();
			XlsUtil.getInstance().read(in);
			//读Xls行所有数据并封装     
	        ArrayList<ArrayList<String>> listAll = XlsUtil.getInstance().readAll();
	        XlsUtil.getInstance().closeRead();  
	        List<Goodsinfo> goodsinfos = goodsManagerService.list2objectlist(listAll);
	        goodsManagerService.importAll(goodsinfos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modelMap.addAttribute("success", "您的批量导入失败！");
			return "forward:goodsinfoview/1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modelMap.addAttribute("success", "您的批量导入失败！");
			return "forward:goodsinfoview/1";
		}
		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("admin");
		Admininfo admin = object == null? null:(Admininfo)object;
		CommonUtil.getInstance().saveLog("批量导入数据成功！", ip,
				admin == null?null:admin.getAdminId(), logService,
						admin == null?null:admin.getShopId());
		modelMap.addAttribute("success", "您的批量导入成功！");
		return "forward:goodsinfoview/1";
	}
	
	// 商品上线管理--库存管理
	@RequestMapping("/storeview")
	public String StoreGoods(ModelMap modelMap) {
	// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] {
				"PackageName:goodsmanager", "ViewName:storegoods",
				"ViewTitle:商品管理--商品上线管理", "smenu:" + sMenu ,"mmenu:store"  });
		return PathUtil.returnStr(path, modelMap);
	}

	// 商品信息管理
	@RequestMapping("/goodsinfoview/{pagenow}")
	public String GoodsInfoManager(ModelMap modelMap,
			@PathVariable("pagenow")Integer pageNow, HttpSession session) {
		pagenow = pageNow == null?1:pageNow; 
		int pagesize = 10;
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		List<Level1> level1s = levelOneService.findAllLevelOne(shopId);
		modelMap.addAttribute("level1s", level1s);
		//List<Goodsinfo> goodsinfos = goodsManagerService.findByPage(pagenow, pagesize);
		List<Shopgoods> goodsinfos = shopGoodsService.findByPage(pagenow, pagesize, shopId);
		int pageCount =shopGoodsService.sizeoflist();
		modelMap.addAttribute("pagecount", (pageCount % pagesize) == 0?(pageCount / pagesize) : ((pageCount / pagesize) + 1));
		modelMap.addAttribute("pagenow", pagenow);
		modelMap.addAttribute("goodsinfos", goodsinfos);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] {
				"PackageName:goodsmanager", "ViewName:goodsinfomanager",
				"ViewTitle:商品管理--商品信息管理", "smenu:" + sMenu ,"mmenu:mag"  });
		return PathUtil.returnStr(path, modelMap);
	}

	/**
     * 
     * @return 异步加载一级分类 返回json数据
     */
	@RequestMapping("/leveltwo")
	@ResponseBody
	public String AsynScool(String id) {
		//logger.info("leveloneid = " + id);
		List<Level2> level1s = levelTwoService.findByLevelOneId((id == null || id.equals("0") || id.equals("undefined")) ?null:Integer.parseInt(id));
		String result = JsonParserUtil.getInstance().ParseListToJSON(level1s);
    	return result;
	}
	/**
	 * 
	 * @param id
	 * @return 异步加载三级分类 返回json数据
	 */
	@RequestMapping("/levelthree")
	@ResponseBody
	public String getLevelThree(String id) {
		
		//logger.info("leveltwoid = " + id);
		List<Level3> level3s = levelThreeService.findByLevelTwoId((id == null || id.equals("0") || id.equals("undefined"))?null:Integer.parseInt(id));
		String result = JsonParserUtil.getInstance().ParseListToJSON(level3s);
    	return result;
	}
	/**
	 * 
	 * @param id
	 * @return 异步加载专业 返回json数据
	 
	@RequestMapping("/traderMajor")
	@ResponseBody
	public String AsynMajor(String id) {
		
		List<major> majors = majorService.selectMajorByAcademyId(new Integer(id));
		result = TraderCenterUtil.getInstance().ParseListToJSON(majors);
    	return result;
	}*/
	@RequestMapping("/updateview/{goodsid}")
	public String update(ModelMap modelMap,
			@PathVariable("goodsid") Integer goodsid, HttpSession session) {
		List<Activity> activities = activityService.findAll();
		modelMap.addAttribute("activities", activities);
		//Goodsinfo goodsinfo = goodsManagerService.findById(goodsid);
		logger.info("goodsid = " + goodsid);
		Integer shopId = CommonUtil.getInstance().getShopId(session);
		Shopgoods goodsinfo = shopGoodsService.findEveryById(goodsid, shopId);
		logger.info("goodsinfo = " + goodsinfo);
		if (goodsinfo != null)
		{
			String oneclass = goodsinfo.getGoodsinfo().getGoodsClass1();
			String twoclass = goodsinfo.getGoodsinfo().getGoodsClass2();
			String threeeclass = goodsinfo.getGoodsinfo().getGoodsClass3();
			List<Level1> level1s = levelOneService.findAllLevelOne(shopId);
			List<Level2> level2s = levelTwoService.findByLevelOneId((oneclass == null || oneclass.isEmpty())?null:Integer.parseInt(oneclass));
			List<Level3> level3s = levelThreeService.findByLevelTwoId((twoclass == null || twoclass.isEmpty())?null : Integer.parseInt(twoclass));
			
			String imageUrlStr = goodsinfo.getGoodsinfo().getPhotoUrl();
			String [] imageUrls =  ((imageUrlStr == null || imageUrlStr.isEmpty())?null:imageUrlStr.split(PropertiesUtil.getInstace().getFileProperties("image.regex")));
			modelMap.addAttribute("imgs", imageUrls);
			modelMap.addAttribute("leveltwos", level2s);
			modelMap.addAttribute("levelones", level1s);
			modelMap.addAttribute("levelthrees", level3s);
			modelMap.addAttribute("oneclass", oneclass);
			modelMap.addAttribute("twoclass", twoclass);
			modelMap.addAttribute("threeeclass", threeeclass);
		}
		
		List<Property> properties = propertyServiceImpl.findAllByShopId(shopId );
		//logger.info(String.valueOf(activities));
		modelMap.addAttribute("properties", properties);
		modelMap.addAttribute("json", JsonParserUtil.getInstance().Obj2JsonStr(goodsinfo));
		Set<Propertyvalue> propertyvalues = goodsinfo.getPropertyvalues();
		Map<String, String> propertyValueMap = new HashMap<String, String>(); 
		for (Iterator iterator = propertyvalues.iterator(); iterator.hasNext();) {
			Propertyvalue propertyvalue = (Propertyvalue) iterator.next();
			Property property = propertyServiceImpl.findByIdAndShopId(propertyvalue.getPropertyId(), shopId);
			propertyValueMap.put(property.getPropertyName(), 
					propertyvalue.getPropertyvalueValue());
		}
		String mapjson = JsonParserUtil.getInstance().Obj2JsonStr(propertyValueMap);
		logger.info("mapjson = " + mapjson);
		modelMap.addAttribute("propertymap", mapjson);
		logger.info(goodsinfo);
		modelMap.addAttribute("goodsinfo", goodsinfo);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] {
				"PackageName:goodsmanager", "ViewName:updategoods",
				"ViewTitle:商品管理--商品信息管理", "smenu:" + sMenu ,"mmenu:update" });
		return PathUtil.returnStr(path, modelMap);
	}
	    //修改商品
		@SuppressWarnings("unused")
		@RequestMapping("/update")
		public String update(Goodsinfo goodsinfo, ModelMap modelMap,
				@RequestParam(value = "files", required = false) MultipartFile [] files
				, String goodsName, HttpServletRequest request, HttpSession httpSession, Integer shopgoodsId
				) {
			String ip = StringUtil.getInstance().getIp(request);
			Enumeration<String> requestParams = request.getParameterNames();
			Object object = httpSession.getAttribute("admin");
			Admininfo admin = object == null? null:(Admininfo)object;
			Goodsinfo oldgoodsinfo = goodsManagerService.findById(goodsinfo.getGoodsId());
			Integer shopId = admin.getShopId();
			Shopgoods shopgoods = shopGoodsService.findEveryById(shopgoodsId, shopId );
			String imagePaths = FileUtil.getInstance().uploadFiels(files);
			if (imagePaths == null ||imagePaths.isEmpty())
				goodsinfo.setPhotoUrl(oldgoodsinfo.getPhotoUrl());
			else 
			{
				goodsinfo.setPhotoUrl(imagePaths);
			}
			if(goodsinfo != null){
				goodsinfo.setUpdateTime(new Date());
				goodsManagerService.update(goodsinfo);
				String activityid = request.getParameter("activityId");
				if (activityid != null)
				{
					shopgoods.setActivityId(Integer.parseInt(activityid.trim()));
				}
				shopgoods.setDate(new Date());
				shopgoods.setShopgoodsStatus(goodsinfo.getStatus());
				shopGoodsService.update(shopgoods);
				logger.info("shopgoodsid = " + shopgoods);
				Set<Propertyvalue> propertyvalues = shopgoods.getPropertyvalues();
				List<Propertyvalue> propertyvalues2 = new ArrayList<Propertyvalue>();
				logger.info("properties = " + propertyvalues);
				if (propertyvalues != null && propertyvalues.size() > 0)
				{
					for (Iterator iterator = propertyvalues.iterator(); iterator
							.hasNext();) {
						Propertyvalue propertyvalue = (Propertyvalue) iterator
								.next();
						Property property = propertyServiceImpl.findByIdAndShopId(propertyvalue.getPropertyId(), shopId);
						String value = request.getParameter(property.getPropertyName());
						propertyvalue.setPropertyvalueValue(value);
						propertyvalues2.add(propertyvalue);
					}
					logger.info("========in==========properties = " + propertyvalues);
					propertyValueService.updateAll(propertyvalues2);
				}
				else {
					propertyvalues2 = new LinkedList<Propertyvalue>();
					while (requestParams.hasMoreElements()) {
						String attr = requestParams.nextElement();
						if (attr.contains(ConstantUtil.PREFNEWPROPERTY))
						{
							logger.info("newattr = " + request.getParameter(attr));
							Property property = propertyServiceImpl.findByShopIdAndName(attr, shopId);
							Propertyvalue propertyvalue = new Propertyvalue();
							propertyvalue.setPropertyStatus(1);
							propertyvalue.setPropertyId(property.getPropertyId());
							propertyvalue.setPropertyvalueValue(request.getParameter(attr));
							propertyvalue.setShopgoodsId(shopgoods.getShopgoodsId());
							propertyvalues2.add(propertyvalue);
						}
						logger.info(attr);
					}
					propertyValueService.addAll(propertyvalues2);
				}
				
				
				CommonUtil.getInstance().saveLog("修改商品信息，商品id=" + goodsinfo.getGoodsId(),
						ip, admin == null?null:admin.getAdminId(), logService, admin == null?null:admin.getShopId());
				modelMap.addAttribute("success", "您的更新操作成功！");
				return "forward:goodsinfoview/1";
			}
			CommonUtil.getInstance().saveLog("修改商品信息出错，商品id=" + goodsinfo.getGoodsId(), ip,
					admin == null?null:admin.getAdminId(), logService, admin == null?null:admin.getShopId());
			return "redirect:/goodsmanager/addview";
		}

		@RequestMapping("/down/{goodsid}")
		@ResponseBody
		public String down(@PathVariable("goodsid")Integer id, 
				HttpServletRequest request, HttpSession session)
		{
			//Goodsinfo goodsinfo = goodsManagerService.findById(id);
			
			Integer shopId = CommonUtil.getInstance().getShopId(session);
			Shopgoods goodsinfo = shopGoodsService.findEveryById(id, shopId );
			logger.info("shopgoods = " + goodsinfo);
			if (goodsinfo != null)
			{
				goodsinfo.setShopgoodsStatus(0);
				shopGoodsService.update(goodsinfo);
				Goodsinfo goods = goodsinfo.getGoodsinfo();
				goods.setStatus(0);
				goodsManagerService.update(goods);
				logger.info("goods = " + goods);
			}
			String callbackFunName = request.getParameter("callbackparam");
			return callbackFunName + "(" + "{'success':true}" + ")";
			
		}
		@RequestMapping("/up/{goodsid}")
		@ResponseBody
		public String up(@PathVariable("goodsid")Integer id,
				HttpServletRequest request, HttpSession session)
		{
			logger.info("id = " + id);
			Integer shopId = CommonUtil.getInstance().getShopId(session);
			Shopgoods goodsinfo = shopGoodsService.findEveryById(id, shopId );
			logger.info("shopgoods = " + goodsinfo);
			if (goodsinfo != null)
			{
				goodsinfo.setShopgoodsStatus(1);
				shopGoodsService.update(goodsinfo);
				Goodsinfo goods = goodsinfo.getGoodsinfo();
				goods.setStatus(1);
				goodsManagerService.update(goods);
				logger.info("goods = " + goods);
				
			}
			String callbackFunName = request.getParameter("callbackparam");
			return callbackFunName + "(" + "{'success':true}" + ")";
			
		}
		@RequestMapping("/delete/{goodsid}")
		@ResponseBody
		public String delete(@PathVariable("goodsid")Integer id, ModelMap modelMap, 
				HttpServletRequest request, HttpSession session)
		{
			
			Integer shopId = CommonUtil.getInstance().getShopId(session);
			Shopgoods goodsinfo = shopGoodsService.findEveryById(id, shopId );
			logger.info("shopgoods = " + goodsinfo);
			if (goodsinfo != null)
			{
				
				shopGoodsService.delete(goodsinfo);
				
				Goodsinfo goods = goodsinfo.getGoodsinfo();
				goodsManagerService.delete(goods);
				logger.info("goods = " + goods);
				
				Set<Propertyvalue> propertyvalues = goodsinfo.getPropertyvalues();
				propertyValueService.deleteAll(propertyvalues);
			}
			String callbackFunName = request.getParameter("callbackparam");
			return callbackFunName + "(" + "{'success':true}" + ")";
		}
		@RequestMapping("/view/{goodsid}")
		public String view(ModelMap modelMap,
				@PathVariable("goodsid") Integer goodsid, HttpSession session) {
			List<Activity> activities = activityService.findAll();
			modelMap.addAttribute("activities", activities);
			Integer shopId = CommonUtil.getInstance().getShopId(session);
			Shopgoods goodsinfo = shopGoodsService.findById(goodsid, shopId );
			//Goodsinfo goodsinfo = goodsManagerService.findById(goodsid);
			if (goodsinfo != null)
			{
				String oneclass = goodsinfo.getGoodsinfo().getGoodsClass1();
				String twoclass = goodsinfo.getGoodsinfo().getGoodsClass2();
				String threeeclass = goodsinfo.getGoodsinfo().getGoodsClass3();
				List<Level1> level1s = levelOneService.findAllLevelOne(shopId);
				List<Level2> level2s = levelTwoService.findByLevelOneId((oneclass == null || oneclass.isEmpty())?null:Integer.parseInt(oneclass));
				List<Level3> level3s = levelThreeService.findByLevelTwoId((twoclass == null || twoclass.isEmpty())?null : Integer.parseInt(twoclass));
				
				String imageUrlStr = goodsinfo.getGoodsinfo().getPhotoUrl();
				String [] imageUrls =  ((imageUrlStr == null || imageUrlStr.isEmpty())?null:imageUrlStr.split(PropertiesUtil.getInstace().getFileProperties("image.regex")));
				modelMap.addAttribute("imgs", imageUrls);
				modelMap.addAttribute("leveltwos", level2s);
				modelMap.addAttribute("levelones", level1s);
				modelMap.addAttribute("levelthrees", level3s);
				modelMap.addAttribute("oneclass", oneclass);
				modelMap.addAttribute("twoclass", twoclass);
				modelMap.addAttribute("threeeclass", threeeclass);
			}
			
			List<Property> properties = propertyServiceImpl.findAllByShopId(shopId );
			//logger.info(String.valueOf(activities));
			modelMap.addAttribute("properties", properties);
			modelMap.addAttribute("json", JsonParserUtil.getInstance().Obj2JsonStr(goodsinfo));
			Set<Propertyvalue> propertyvalues = goodsinfo.getPropertyvalues();
			Map<String, String> propertyValueMap = new HashMap<String, String>(); 
			for (Iterator iterator = propertyvalues.iterator(); iterator.hasNext();) {
				Propertyvalue propertyvalue = (Propertyvalue) iterator.next();
				Property property = propertyServiceImpl.findByIdAndShopId(propertyvalue.getPropertyId(), shopId);
				propertyValueMap.put(property.getPropertyName(), 
						propertyvalue.getPropertyvalueValue());
			}
			String mapjson = JsonParserUtil.getInstance().Obj2JsonStr(propertyValueMap);
			logger.info("mapjson = " + mapjson);
			modelMap.addAttribute("propertymap", mapjson);
			
			modelMap.addAttribute("goodsinfo", goodsinfo);
			// 根据字符串初始化Path类
			path = PathUtil.setPathParams(new String[] {
					"PackageName:goodsmanager", "ViewName:goodsview",
					"ViewTitle:商品管理--商品信息查看", "smenu:" + sMenu ,"mmenu:update" });
			return PathUtil.returnStr(path, modelMap);
		}
}
