package com.qx.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ILevelOneDao;
import com.qx.dao.ILevelThreeDao;
import com.qx.dao.ILevelTwoDao;
import com.qx.model.Level1;
import com.qx.model.Level2;
import com.qx.model.Level3;
@Repository
public class LvelThreeDaoImpl implements ILevelThreeDao {

	@Resource(name="mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;

	@Override
	public Serializable add(Level3 level3) {
		// TODO Auto-generated method stub
		Serializable serializable = mysqlhibernateTemplete.save(level3);
		return serializable;
	}

	@Override
	public Level3 findById(Integer level3id) {
		// TODO Auto-generated method stub
		List<Level3> list = mysqlhibernateTemplete.find("from Level3 where level3Id=" + level3id);
		return list == null ? null:list.get(0);
	}

	@Override
	public void delete(Level3 level3) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(level3);
	}

	@Override
	public void update(Level3 level3) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(level3);
	}

	@Override
	public List<Level3> findByLevelTwoId(Integer LevelTwoId) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Level3 where level2.level2Id=" + LevelTwoId);
	}

	
}
