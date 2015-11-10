package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qx.dao.ICommonDao;
import com.qx.dao.impl.ActivityDaoImpl;
import com.qx.model.Activity;
import com.qx.model.Activitytype;
import com.qx.service.ICommonService;
@Service("activityService")
public class ActivityServiceImpl implements ICommonService<Activity> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ActivityServiceImpl.class);

	@Resource(name="activityDao")
	private ActivityDaoImpl commonDao; 
	@Resource(name="activityTypeDao")
	private ICommonDao<Activitytype> activitytypeDao;
	@Override
	public void add(Activity object) {
		// TODO Auto-generated method stub
		if (object != null)
			commonDao.add(object);
		else
		  logger.error("添加的activity为null!");
		
	}

	@Override
	public void update(Activity object) {
		// TODO Auto-generated method stub
		if (object != null)
			commonDao.update(object);
		else 
			logger.error("更新的activity为null");
	}

	@Override
	public void delete(Activity object) {
		// TODO Auto-generated method stub
		if (object != null)
			commonDao.delete(object);
		else
			logger.error("删除的activity为null");
	}

	@Override
	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		List<Activity> list =  commonDao.findAll();
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++) {
				Activity activity = list.get(i);
				Integer type = activity.getActivityType();
				Activitytype activitytype = activitytypeDao.findById(type);
				activity.setActivityTypeO(activitytype);
				list.set(i, activity);
			}
		}
		return list;
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return commonDao.sizeoflist();
	}

	@Override
	public List<Activity> findByPage(int pagenow, int pagesize) {
		// TODO Auto-generated method stub
		List<Activity> list =  commonDao.findByPage((pagenow - 1)  * pagesize, pagesize);
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++) {
				Activity activity = list.get(i);
				Integer type = activity.getActivityType();
				Activitytype activitytype = activitytypeDao.findById(type);
				activity.setActivityTypeO(activitytype);
				list.set(i, activity);
			}
		}
		return list;
		
	}

	@Override
	public Activity findById(Integer id) {
		// TODO Auto-generated method stub
		if ( id != null )
			return commonDao.findById(id);
		logger.error("查询的activityid为null!");
		return null;
	}

	public Activity findById(Integer id, Integer shopId) {
		// TODO Auto-generated method stub
		if ( id != null && shopId != null)
			return commonDao.findById(id, shopId);
		logger.error("查询的activityid为null!");
		return null;
	}
	
	public List<Activity> findByType(Integer type)
	{
		List list = null;
		if (type != null)
			list = commonDao.findByType(type);
		else
			logger.error("type为null!");
		return list;
	}
	
	public List<Activity> findByPage(int pagenow, int pagesize, Integer shopId) {
		// TODO Auto-generated method stub
		List<Activity> list =  commonDao.findByPage((pagenow - 1)  * pagesize, pagesize, shopId);
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++) {
				Activity activity = list.get(i);
				Integer type = activity.getActivityType();
				Activitytype activitytype = activitytypeDao.findById(type);
				activity.setActivityTypeO(activitytype);
				list.set(i, activity);
			}
		}
		return list;
		
	}
}
