package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qx.dao.impl.BasepropertyDaoImpl;
import com.qx.model.Baseproperty;
import com.qx.service.ICommonService;
@Service("basepropertyService")
public class BasepropertyServiceImpl implements ICommonService<Baseproperty> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BasepropertyServiceImpl.class);

	@Resource(name="basepropertyDao")
	private BasepropertyDaoImpl basepropertyDaoImpl;
	@Override
	public void add(Baseproperty object) {
		// TODO Auto-generated method stub
		if (object != null)
		{
			basepropertyDaoImpl.add(object);
		}
		else {
			logger.error("待插入基本属性异常，基本属性为null！");
		}
	}

	@Override
	public void update(Baseproperty object) {
		// TODO Auto-generated method stub
		if (object != null)
			basepropertyDaoImpl.update(object);
		else
			logger.error("待更新基本属性异常，基本属性为null！");
	}

	@Override
	public void delete(Baseproperty object) {
		// TODO Auto-generated method stub
		if (object != null)
			basepropertyDaoImpl.delete(object);
		else
			logger.error("待删除基本属性异常，基本属性为null！");
	}

	@Override
	public List<Baseproperty> findAll() {
		// TODO Auto-generated method stub
		return basepropertyDaoImpl.findAll();
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Baseproperty> findByPage(int pagenow, int pagesize) {
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
		return basepropertyDaoImpl.findAllActiveBaseproperty();
	}

}
