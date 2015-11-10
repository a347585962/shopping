package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qx.dao.IOrderDao;
import com.qx.model.Goodsinfo;
import com.qx.model.Orderinfo;
import com.qx.model.SubOrderinfo;
import com.qx.model.Userinfo;
import com.qx.service.IOrderService;
@Service
public class OrderServiceImpl implements IOrderService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);

	@Autowired
	private IOrderDao orderDao;
	@Override
	public List<Orderinfo> findAll() {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}

	@Override
	public Orderinfo findById(Integer orderid) {
		// TODO Auto-generated method stub
		
		return orderid == null?null:orderDao.findById(orderid);
	}

	@Override
	public int findOrderSize() {
		// TODO Auto-generated method stub
		return orderDao.findOrderSize();
	}

	@Override
	public List<Orderinfo> findOrder(int pagenow, int size) {
		
		// TODO Auto-generated method stub
		int start = (pagenow - 1) * size;
		return orderDao.findOrder(start, size);
	}

	@Override
	public List<Orderinfo> findBySearch(Object searchKey, String searchName) {
		// TODO Auto-generated method stub
		return orderDao.findBySearch(searchKey, searchName);
	}

	@Override
	public List<SubOrderinfo> findSubOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findSubOrderSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SubOrderinfo> findSubOrderByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubOrderinfo findSubOrderById(Integer suborderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Orderinfo orderinfo) {
		// TODO Auto-generated method stub
		if (orderinfo != null)
			orderDao.update(orderinfo);
		else
			logger.error("更新的订单对象为null!");
	}

	@Override
	public List<Orderinfo> searchByMap(String orderid, String username,
			String ordersendstatus, String orderpaystatus, int pagenow,
			int pagesize) {
		// TODO Auto-generated method stub
		Map<String, Object> parameters = setSearchParameters(orderid, username,
				ordersendstatus, orderpaystatus);
		return orderDao.searchByMap(parameters,
				(pagenow - 1) * pagesize, pagesize);
	}

	@Override
	public int sizeofAllSearch(String orderid, String username,
			String ordersendstatus, String orderpaystatus) {
		// TODO Auto-generated method stub
		Map<String, Object> parameters = setSearchParameters(orderid, username,
				ordersendstatus, orderpaystatus);
		return orderDao.sizeofAllSearch(parameters);
	}
	public Map<String, Object> setSearchParameters(String orderid, String username,
			String ordersendstatus, String orderpaystatus)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (orderid != null && !orderid.isEmpty())
		{
			parameters.put("orderinfo.OrderID", Integer.parseInt(orderid));
		}
		if (username != null && !username.isEmpty())
		{
			parameters.put("userinfo.UserPhone", username);
		}
		if (ordersendstatus != null && !ordersendstatus.isEmpty())
		{
			parameters.put("orderstatus.sendstatus", ordersendstatus);
		}
		if (orderpaystatus != null && !orderpaystatus.isEmpty())
		{
			parameters.put("orderstatus.paystatus", orderpaystatus);
		}
		
		return parameters;
	}

	@Override
	public List<Userinfo> topTenPerson(Date start, Date end, Integer shopId) {
		// TODO Auto-generated method stub
		List list = orderDao.topTenPerson(start, end, shopId);
		for (int i = 0; i < list.size(); i++) {
			Object[] objs = (Object[]) list.get(i);
			
			Userinfo info = ((Userinfo)objs[1]);
			info.setSumgoods(Integer.parseInt(objs[0].toString()));
			list.set(i, info);
			
		}
		logger.info(list);
		return list;
	}

	@Override
	public List<Goodsinfo> topTenGoods(Date start, Date end, Integer shopId) {
		// TODO Auto-generated method stub
		return orderDao.topTenGoods(start, end, shopId);
	}

	@Override
	public void save(Orderinfo orderinfo) {
		// TODO Auto-generated method stub
		if (orderinfo != null   )
		{
			if (orderinfo.getSuborders() != null && orderinfo.getSuborders().size() > 0)
			{
				orderDao.save(orderinfo);
			}
			else {
				logger.error("子订单不能为null！");
			}
		}
		else {
			logger.error("订单不能为null!");
		}
	}

	@Override
	public void saveSubOrder(SubOrderinfo subOrderinfo) {
		// TODO Auto-generated method stub
		if (subOrderinfo != null)
		{
			orderDao.saveSubOrder(subOrderinfo);
		}
		else {
			logger.error("订单信息为null!");
		}
		
	}

	@Override
	public void saveSubOrders(List<SubOrderinfo> subOrderinfos) {
		// TODO Auto-generated method stub
		if (subOrderinfos != null && subOrderinfos.size() > 0)
		{
			for (Iterator<SubOrderinfo> iterator = subOrderinfos.iterator(); iterator
					.hasNext();) {
				SubOrderinfo subOrderinfo = (SubOrderinfo) iterator.next();
				orderDao.saveSubOrder(subOrderinfo);
			}
		}
		else {
			logger.error("子订单对象集合为null");
		}
	}

	@Override
	public List<Orderinfo> findOrder(int pagenow, int size, Integer shopId) {
		// TODO Auto-generated method stub
		int start = (pagenow - 1) * size;
		return orderDao.findOrder(start, size, shopId);
	}

	@Override
	public int findShopOrderSizeByShopId(Integer shopId) {
		// TODO Auto-generated method stub
		return orderDao.findShopOrderSizeByShopId(shopId);
	}

	@Override
	public List<Orderinfo> findBySearch(Object searchKey, String searchName,
			Integer shopId) {
		// TODO Auto-generated method stub
		return orderDao.findBySearch(searchKey, searchName, shopId);
	}

	@Override
	public int sizeofAllSearch(String orderid, String username,
			String ordersendstatus, String orderpaystatus, Integer shopId) {
		// TODO Auto-generated method stub
		Map<String, Object> parameters = setSearchParameters(orderid, username,
				ordersendstatus, orderpaystatus);
		return orderDao.sizeofAllSearch(parameters);
	}

	@Override
	public List<Orderinfo> searchByMap(String orderid, String username,
			String ordersendstatus, String orderpaystatus, int pagenow,
			int pagesize, Integer shopId) {
		// TODO Auto-generated method stub
		Map<String, Object> parameters = setSearchParameters(orderid, username,
				ordersendstatus, orderpaystatus);
		return orderDao.searchByMap(parameters,
				(pagenow - 1) * pagesize, pagesize, shopId);
	}

}
