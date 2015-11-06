package com.controller;

import org.apache.log4j.Logger;

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

import com.mc.model.Path;
import com.qx.model.Admininfo;
import com.qx.model.Goodsinfo;
import com.qx.model.Level1;
import com.qx.model.Orderinfo;
import com.qx.model.Orderstatus;
import com.qx.service.ILogService;
import com.qx.service.IOrderService;
import com.qx.service.impl.OrderStatusServiceImpl;
import com.qx.utils.CommonUtil;
import com.qx.utils.PathUtil;
import com.qx.utils.StringUtil;

@Controller
@RequestMapping("/order")
public class OrderManagerController {                                          
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderManagerController.class);

	@Autowired
	private IOrderService orderService;
	@Autowired
	private ILogService logService;
	@Resource(name="orderstatusService")
	private OrderStatusServiceImpl orderstatusServiceImpl;
	Integer pagenow;
	private Path path = null;
	String sMenu = "order";
	private Integer SEARCHPAGENOW;
	private String ORDERID;
	private String USERNAME;
	private String PAYSTATUS;
	private String SENDSTATUS;
	Integer SEARCHROWCOUNT;
	@RequestMapping("/manager/{pagenow}")
	public String manager(ModelMap modelMap,@PathVariable("pagenow") Integer pageNow)
	{
		int pagesize = 5;
		pagenow = pageNow == null ? 1: pageNow;
		List<Orderinfo> orderinfos = orderService.findOrder(pagenow, pagesize);
		Integer pagecount = orderService.findOrderSize();
		//logger.info("oreder = " + orderinfos);
		modelMap.addAttribute("orders", orderinfos); 
		
		modelMap.addAttribute("pagecount", (pagecount % pagesize) == 0?(pagecount / pagesize) : ((pagecount / pagesize) + 1));
		modelMap.addAttribute("pagenow", pagenow);
		path = PathUtil.setPathParams(new String[]{"PackageName:OrderManager","ViewName:OrderManager","ViewTitle:群祥订单管理", "smenu:" + sMenu ,"mmenu:mag" });					
    	return PathUtil.returnStr(path, modelMap);
	}
	@RequestMapping("/search")
	public String Search(ModelMap modelMap, String type, String searchValue)
	{
		//logger.info(type + "," + searchValue) ;
		Integer typeId = type == null?null:Integer.parseInt(type);
		String searchName = "";
		if (typeId != null)
		{
			switch (typeId) {
			case 1:
				searchName = "orderinfo.orderId";
				break;
			case 2:
				searchName = "userinfo.userPhone";
				break;
			case 3:
				
				break;

			default:
				break;
			}
			List<Orderinfo> orderinfos = orderService.findBySearch(searchValue, searchName);
			//logger.info(String.valueOf(orderinfos));
			modelMap.addAttribute("orders", orderinfos);
		}
		path = PathUtil.setPathParams(new String[]{"PackageName:OrderManager","ViewName:search","ViewTitle:群祥订单查询", "smenu:" + sMenu ,"mmenu:search" });					
    	return PathUtil.returnStr(path, modelMap);
	}
	/**
	 *  更新订单信息
	 * @param orderid 订单id
	 * @param address 订单修改地址
	 * @param money 订单修改金额
	 * @param httpSession 请求session
	 * @param request 请求request
	 * @return 管理界面
	 */
	@RequestMapping("/update")
	public String update(@RequestParam("ordid")Integer orderid, @RequestParam(value = "adress", required = false)String address, 
			 @RequestParam(value = "money", required = false)String money, HttpSession httpSession, HttpServletRequest request)
	{
		logger.info("orderid = " + orderid + ",address = " + address + ",money = " + money);
		Orderinfo orderinfo = orderService.findById(orderid);
		if (address != null && !address.isEmpty())
			orderinfo.setOrderAddress(address);
		if (money != null && !money.isEmpty())
			orderinfo.setTotalPrice(Long.parseLong(money));
		orderService.update(orderinfo);
		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("admin");
		Admininfo admin = object == null? null:(Admininfo)object;
		CommonUtil.getInstance().saveLog("更新订单信息，订单id=" + orderinfo.getOrderId() + ",订单对象order=" + orderinfo.toString(), ip, admin == null?null:admin.getAdminId(), logService);
    	return "forward:/order/manager/1";
	}
	@RequestMapping("/orderconfirm_{pagenow}/{orderId}")
	public String orderconfirm(@PathVariable("pagenow") Integer pageNow, @PathVariable("orderId") Integer orderId)
	{
		logger.info("orderid = " + orderId + ",pagenow = " + pageNow );
		Orderstatus orderstatus = orderstatusServiceImpl.findByOrderid(orderId);
		if (orderstatus != null)
		{
			try {
				orderstatus.setSendstatus(3);
				orderstatusServiceImpl.update(orderstatus);
				
			} catch (Exception e) {
				// TODO: handle exception
				return "forward:/order/manager/" + pageNow;
			}
		}
		return "forward:/order/manager/" + pageNow;
		
	}
	@RequestMapping("/ordersuccess_{pagenow}/{orderId}")
	public String ordersuccess(@PathVariable("pagenow") Integer pageNow, @PathVariable("orderId") Integer orderId)
	{
		logger.info("orderid = " + orderId + ",pagenow = " + pageNow );
		Orderstatus orderstatus = orderstatusServiceImpl.findByOrderid(orderId);
		if (orderstatus != null)
		{
			try {
				orderstatus.setSendstatus(1);
				orderstatusServiceImpl.update(orderstatus);
				
			} catch (Exception e) {
				// TODO: handle exception
				return "forward:/order/manager/" + pageNow;
			}
		}
		return "forward:/order/manager/" + pageNow;
		
	}
	@RequestMapping("/search/{pagenow}")
	public String search(@PathVariable("pagenow")Integer pageNow, String orderid, String username
			, String ordersendstatus, String orderpaystatus, HttpServletRequest request
			,HttpSession httpSession, ModelMap modelMap)
	{
		logger.info("orderid = " + orderid + ",username = " + username + ",ordersendstatus = " + ordersendstatus + ",orderpaystatus" + orderpaystatus);
		if ((orderid == null || orderid.isEmpty()) && (username == null || username.isEmpty()) &&
				(ordersendstatus == null || ordersendstatus.isEmpty()) &&
				(orderpaystatus == null || orderpaystatus.isEmpty())
				)
		{
			
		}
		else {
			ORDERID = orderid;
			USERNAME = username;
			SENDSTATUS = ordersendstatus;
			PAYSTATUS = orderpaystatus;
			
		}
		SEARCHROWCOUNT = orderService.sizeofAllSearch(ORDERID, USERNAME, SENDSTATUS, PAYSTATUS);
		//logger.info(SEARCHROWCOUNT);
		SEARCHPAGENOW = (pageNow == null || pageNow == 0)?1:pageNow;
		int pagesize = 5;
	    List<Orderinfo> orderinfos = orderService.searchByMap(ORDERID, USERNAME, SENDSTATUS, PAYSTATUS, SEARCHPAGENOW, pagesize);
		modelMap.addAttribute("pagecount", (SEARCHROWCOUNT % pagesize) == 0?(SEARCHROWCOUNT / pagesize) : ((SEARCHROWCOUNT / pagesize) + 1));
		modelMap.addAttribute("pagenow", SEARCHPAGENOW);
		modelMap.addAttribute("orders", orderinfos);
		path = PathUtil.setPathParams(new String[] {
				"PackageName:OrderManager", "ViewName:search",
				"ViewTitle:订单管理--订单查询", "smenu:" + sMenu ,"mmenu:search" });
		return PathUtil.returnStr(path, modelMap);
	}
}
