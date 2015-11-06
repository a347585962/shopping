package com.qx.dao.impl;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ILevelOneDao;
import com.qx.model.Level1;

@Repository
public class LevelOneDaoImpl implements ILevelOneDao {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(LevelOneDaoImpl.class);

	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;

	@Override
	public List<Level1> findAllLevelOne() {
		// TODO Auto-generated method stub
		List<Level1> level1s = (List<Level1>) mysqlhibernateTemplete
				.find("from Level1");
		return level1s;
	}

	@Override
	public Serializable add(Level1 level1) {
		// TODO Auto-generated method stub
		Serializable serializable = mysqlhibernateTemplete.save(level1);
		return serializable;
	}

	@Override
	public Level1 findById(Integer level1id) {
		// TODO Auto-generated method stub
		List<Level1> list = mysqlhibernateTemplete
				.find("from Level1 where level1Id=" + level1id);
		return list == null?null:list.get(0);
	}

	@Override
	public Level1 delete(Level1 level1) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(level1);
		return level1;
	}

	@Override
	public Level1 update(Level1 level1) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(level1);
		return level1;
	}

}
