package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qx.dao.ICommonDao;
import com.qx.model.Activitytype;
import com.qx.service.ICommonService;
@Service("activityTypeService")
public class ActivityTypeServiceImpl implements ICommonService<Activitytype> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ActivityTypeServiceImpl.class);

	@Resource(name="activityTypeDao")
	private ICommonDao<Activitytype> commonDao;
	@Override
	public void add(Activitytype object) {
		// TODO Auto-generated method stub
		 if (object != null)
			 commonDao.add(object);
	        else 
	        	logger.error("新增activitytype为null!");
	}

	@Override
	public void update(Activitytype object) {
		// TODO Auto-generated method stub
		if (object != null)
			commonDao.update(object);
        else 
        	logger.error("更新activitytype为null!");
	}

	@Override
	public void delete(Activitytype object) {
		// TODO Auto-generated method stub
		if (object != null)
			commonDao.delete(object);
        else 
        	logger.error("删除activitytype为null!");
	}

	@Override
	public List<Activitytype> findAll() {
		// TODO Auto-generated method stub
		return commonDao.findAll();
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return commonDao.sizeoflist();
	}

	@Override
	public List<Activitytype> findByPage(int pagenow, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activitytype findById(Integer id) {
		// TODO Auto-generated method stub
		if (id != null)
			return commonDao.findById(id);
		logger.error("查询activitytype的id为null");
		return null;
	}

}
