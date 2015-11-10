package com.qx.dao.impl;

import org.apache.log4j.Logger;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ICommonDao;
import com.qx.model.Activity;
import com.qx.model.Activitytype;
@Repository("activityTypeDao")
public class ActivityTypeDaoImpl implements ICommonDao<Activitytype> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ActivityTypeDaoImpl.class);

	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	@Override
	public void add(Activitytype object) {
		// TODO Auto-generated method stub
        	mysqlhibernateTemplete.save(object);
	}

	@Override
	public void update(Activitytype object) {
		// TODO Auto-generated method stub
		
        	mysqlhibernateTemplete.update(object);
	}

	@Override
	public void delete(Activitytype object) {
		// TODO Auto-generated method stub
		if (object != null)
        	mysqlhibernateTemplete.delete(object);
        else 
        	logger.error("删除activitytype为null!");
	}

	@Override
	public List<Activitytype> findAll() {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Activitytype");
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Activitytype> findByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activitytype findById(Integer id) {
		// TODO Auto-generated method stub
		List list = mysqlhibernateTemplete.find("from Activitytype where activitytypeId=" + id);
		return (list == null || list.size() == 0)?null:(Activitytype)list.get(0);
	}
	public List<Activitytype> findAllByShopId(Integer shopId)
	{
		return mysqlhibernateTemplete.find("from Activitytype where shopId=" + shopId +" and activitytypeStatus=1");
	}
}
