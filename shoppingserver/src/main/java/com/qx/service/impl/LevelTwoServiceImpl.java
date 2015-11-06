package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qx.dao.ILevelTwoDao;
import com.qx.model.Level1;
import com.qx.model.Level2;
import com.qx.service.ILevelOneService;
import com.qx.service.ILevelTwoService;
@Service
public class LevelTwoServiceImpl implements ILevelTwoService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LevelTwoServiceImpl.class);

	@Autowired
	private ILevelTwoDao levelTwoDao;
	@Override
	public Level2 add(Level2 level2) {
		// TODO Auto-generated method stub
		return levelTwoDao.add(level2);
	}
	@Override
	public Level2 findById(Integer level2id) {
		// TODO Auto-generated method stub
		return (level2id == null || level2id == 0)? null:levelTwoDao.findById(level2id);
	}
	@Override
	public void delete(Level2 level2) {
		// TODO Auto-generated method stub
		if (level2 != null)
			levelTwoDao.delete(level2);
		else
			logger.error("二级分类为null");
	}
	@Override
	public Level2 update(Level2 level2) {
		// TODO Auto-generated method stub
		
		if (level2 != null)
			levelTwoDao.update(level2);
		else
			logger.error("二级分类为null");
		return level2;
	}
	@Override
	public List<Level2> findByLevelOneId(Integer levelOneId) {
		// TODO Auto-generated method stub
		return (levelOneId == null || levelOneId == 0)?null:levelTwoDao.findByLevelOneId(levelOneId);
	}

	
}
