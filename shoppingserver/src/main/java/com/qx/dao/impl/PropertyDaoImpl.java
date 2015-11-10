package com.qx.dao.impl;

import org.apache.log4j.Logger;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ICommonDao;
import com.qx.model.Property;
@Repository("propertyDao")
public class PropertyDaoImpl implements ICommonDao<Property> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PropertyDaoImpl.class);

	@Resource(name="mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	@Override
	public void add(Property object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(object);
	}

	@Override
	public void update(Property object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(object);
	}

	@Override
	public void delete(Property object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(object);
	}

	@Override
	public List<Property> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Property> findByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 根据商家id查询属性列表
	 * @param shopId 属性列表
	 * @return 商家商品属性列表
	 */
	public List<Property> findAllByShopId(Integer shopId)
	{
		return mysqlhibernateTemplete.find("from Property where shopId=" + shopId + " and propertyStatus=1");
	}
	/**
	 * 根据商家id查询未激活属性列表
	 * @param shopId 属性列表
	 * @return 商家商品属性列表
	 */
	public List<Property> findAllNonActiveByShopId(Integer shopId)
	{
		return mysqlhibernateTemplete.find("from Property where shopId=" + shopId + " and propertyStatus=0");
	}
	/**
	 * 根据属性id和商家id查询属性
	 * @param id 属性id
	 * @param shopId 商家id
	 * @return 属性对象实例
	 */
	public List<Property> findById(Integer id, Integer shopId) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Property where shopId=" + shopId + " and propertyId=" + id);
	}
	/**
	 *  根据商家id和属性名查询属性实例
	 * @param pName 属性名
	 * @param shopId 商家id
	 * @return 属性对象实例
	 */
	public List<Property> findByShopIdAndName(String pName, Integer shopId) {
		// TODO Auto-generated method stub
		String hql = "from Property where shopId=" + shopId + " and propertyName='" + pName + "'";
		logger.info("hql = " + hql);
		return mysqlhibernateTemplete.find(hql);
	}
}
