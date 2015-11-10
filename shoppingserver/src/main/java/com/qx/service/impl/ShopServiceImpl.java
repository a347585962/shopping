package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qx.dao.impl.LoginDaoImpl;
import com.qx.dao.impl.ShopDaoImpl;
import com.qx.model.Admininfo;
import com.qx.model.Shop;
import com.qx.service.ICommonService;
@Service("shopService")
public class ShopServiceImpl implements ICommonService<Shop>{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ShopServiceImpl.class);

	@Resource(name="shopDao")
	private ShopDaoImpl shopDaoImpl;
	@Resource(name="adminUserService")
	private LoginServiceImpl loginServiceImpl;
	@Resource(name="propertyService")
	private PropertyServiceImpl propertyServiceImpl;
	@Override
	public void add(Shop object) {
		// TODO Auto-generated method stub
		if (object != null)
		{
			shopDaoImpl.add(object);
			Integer shopId = object.getShopId();
			if (shopId != null && shopId != 0)
			{
				loginServiceImpl.addDefaultAdminByShopId(shopId, object.getShopPhone());
				propertyServiceImpl.addDefaultPropertyByShopId(shopId);
			}
			
		}
		else
			logger.error("添加商家信息出错，商家为null!");
	}

	@Override
	public void update(Shop object) {
		// TODO Auto-generated method stub
		if (object != null)
			shopDaoImpl.update(object);
		else
			logger.error("更新商家信息失败，对象为null.");
	}

	@Override
	public void delete(Shop object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Shop> findAll() {
		// TODO Auto-generated method stub
		return shopDaoImpl.findAll();
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Shop> findByPage(int pagenow, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop findById(Integer id) {
		// TODO Auto-generated method stub
		//logger.info("id = " + id);
		if (id != null)
		{
			return shopDaoImpl.findById(id);
		}
		return null;
	}

}
