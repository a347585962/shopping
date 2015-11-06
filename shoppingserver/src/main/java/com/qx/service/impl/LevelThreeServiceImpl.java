package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.x509.DeltaCRLIndicatorExtension;

import com.qx.dao.ILevelThreeDao;
import com.qx.dao.ILevelTwoDao;
import com.qx.model.Level1;
import com.qx.model.Level2;
import com.qx.model.Level3;
import com.qx.service.ILevelOneService;
import com.qx.service.ILevelThreeService;
import com.qx.service.ILevelTwoService;
@Service
public class LevelThreeServiceImpl implements ILevelThreeService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LevelThreeServiceImpl.class);

	@Autowired
	private ILevelThreeDao levelThreeDao;
	@Override
	public void add(Level3 level3) {
		// TODO Auto-generated method stub
		levelThreeDao.add(level3);
	}
	@Override
	public Level3 findById(Integer level3id) {
		// TODO Auto-generated method stub
		return (level3id == null || level3id == 0) ? null:levelThreeDao.findById(level3id);
	}
	@Override
	public void delete(Level3 level3) {
		// TODO Auto-generated method stub
		if (level3 != null)
			levelThreeDao.delete(level3);
		else
			logger.error("三级分类对象为null");
	}
	@Override
	public void update(Level3 level3) {
		// TODO Auto-generated method stub
		if (level3 != null)
			levelThreeDao.update(level3);
		else
			logger.error("三级分类对象为null");
	}
	@Override
	public List<Level3> findByLevelTwoId(Integer LevelTwoId) {
		// TODO Auto-generated method stub
		return (LevelTwoId == null || LevelTwoId == 0 )?null:levelThreeDao.findByLevelTwoId(LevelTwoId);
	}

	
}
