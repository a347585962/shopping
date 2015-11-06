package com.qx.dao.impl;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ILevelOneDao;
import com.qx.dao.ILevelTwoDao;
import com.qx.model.Level1;
import com.qx.model.Level2;
@Repository
public class LvelTwoDaoImpl implements ILevelTwoDao {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LvelTwoDaoImpl.class);

	@Resource(name="mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;

	@Override
	public Level2 add(Level2 level2) {
		// TODO Auto-generated method stub
		Serializable  id =  mysqlhibernateTemplete.save(level2);
		logger.info("Serializable = " + id);
		return level2;
	}

	@Override
	public Level2 findById(Integer level2id) {
		// TODO Auto-generated method stub
		List<Level2> list = mysqlhibernateTemplete.find("from Level2 where level2Id=" + level2id);
		return list == null?null:list.get(0);
	}

	@Override
	public void delete(Level2 level2) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(level2);
	}

	@Override
	public Level2 update(Level2 level2) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(level2);
		return level2;
	}

	@Override
	public List<Level2> findByLevelOneId(Integer levelOneId) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Level2 where level1.level1Id=" + levelOneId);
	}
	
	

	
}
