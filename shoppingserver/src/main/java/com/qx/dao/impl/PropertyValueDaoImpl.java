package com.qx.dao.impl;

import org.apache.log4j.Logger;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ICommonDao;
import com.qx.model.Propertyvalue;
@Repository("propertyValueDao")
public class PropertyValueDaoImpl implements ICommonDao<Propertyvalue> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PropertyValueDaoImpl.class);

	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	@Override
	public void add(Propertyvalue object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(object);
	}

	@Override
	public void update(Propertyvalue object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(object);
	}

	@Override
	public void delete(Propertyvalue object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(object);
	}

	@Override
	public List<Propertyvalue> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Propertyvalue> findByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Propertyvalue findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Propertyvalue> findAllByShopGoodsId(Integer shopGoodsId) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Propertyvalue where shopgoodsId=" + shopGoodsId);
	}

}
