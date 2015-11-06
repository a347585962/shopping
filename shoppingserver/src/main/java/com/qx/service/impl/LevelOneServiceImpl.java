package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qx.dao.ILevelOneDao;
import com.qx.model.Level1;
import com.qx.service.ILevelOneService;
import com.qx.utils.JsonParserUtil;

@Service
public class LevelOneServiceImpl implements ILevelOneService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(LevelOneServiceImpl.class);

	@Autowired
	private ILevelOneDao levelOneDao;

	@Override
	public List<Level1> findAllLevelOne() {
		// TODO Auto-generated method stub
		return levelOneDao.findAllLevelOne();
	}

	@Override
	public String findAllLevelOne2Json() {
		// TODO Auto-generated method stub
		return JsonParserUtil.getInstance().parserLevelList(
				levelOneDao.findAllLevelOne());
	}

	@Override
	public void add(Level1 level1) {
		// TODO Auto-generated method stub
		levelOneDao.add(level1);
	}

	@Override
	public Level1 findById(Integer level1id) {
		// TODO Auto-generated method stub
		return (level1id == null || level1id == 0) ? null : levelOneDao.findById(level1id);
	}

	@Override
	public Level1 delete(Level1 level1) {
		// TODO Auto-generated method stub
		if (level1 != null)
			return levelOneDao.delete(level1);
		else {
			logger.error("一级分类为null");
			return null;
		}

	}

	@Override
	public Level1 update(Level1 level1) {
		// TODO Auto-generated method stub
		if (level1 != null)
			return levelOneDao.update(level1);
		else {
			logger.error("一级分类为null");
			return null;
		}
	}

}
