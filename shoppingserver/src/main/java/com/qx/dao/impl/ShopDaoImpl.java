package com.qx.dao.impl;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ICommonDao;
import com.qx.model.Shop;
@Repository("shopDao")
public class ShopDaoImpl implements ICommonDao<Shop> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ShopDaoImpl.class);


	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	
	@Override
	public void add(Shop object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(object);
	}

	@Override
	public void update(Shop object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(object);
	}

	@Override
	public void delete(Shop object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(object);
	}

	@Override
	public List<Shop> findAll() {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Shop");
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Shop> findByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop findById(Integer id) {
		// TODO Auto-generated method stub
		List list = mysqlhibernateTemplete.find("from Shop where shopId=" + id);
		//logger.info("list = " + list);
		return (list != null && list.size() > 0)?(Shop)list.get(0):null;
	}

}
