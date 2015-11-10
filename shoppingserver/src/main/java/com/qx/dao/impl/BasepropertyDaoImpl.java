package com.qx.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ICommonDao;
import com.qx.model.Baseproperty;
@Repository("basepropertyDao")
public class BasepropertyDaoImpl implements ICommonDao<Baseproperty> {
	@Resource(name="mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	@Override
	public void add(Baseproperty object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(object);
	}

	@Override
	public void update(Baseproperty object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(object);
	}

	@Override
	public void delete(Baseproperty object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(object);
	}

	@Override
	public List<Baseproperty> findAll() {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Baseproperty");
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Baseproperty> findByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Baseproperty findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Baseproperty> findAllActiveBaseproperty()
	{
		return mysqlhibernateTemplete.find("from Baseproperty where baseStatus=1");
	}
}
