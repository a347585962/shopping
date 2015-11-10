package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qx.dao.impl.PropertyValueDaoImpl;
import com.qx.model.Propertyvalue;
import com.qx.service.ICommonService;
@Service("propertyValueService")
public class PropertyValueServiceImpl implements ICommonService<Propertyvalue> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PropertyValueServiceImpl.class);

	@Resource(name="propertyValueDao")
	private PropertyValueDaoImpl propertyValueDao;
	@Override
	public void add(Propertyvalue object) {
		// TODO Auto-generated method stub
		if (object != null)
			propertyValueDao.add(object);
		else
			logger.error("插入属性值对象失败，属性值对象为null!");
	}

	@Override
	public void update(Propertyvalue object) {
		// TODO Auto-generated method stub
		if (object != null)
			propertyValueDao.update(object);
		else
			logger.error("更新属性值对象失败，属性值对象为null!");
	}

	@Override
	public void delete(Propertyvalue object) {
		// TODO Auto-generated method stub
		if (object != null)
			propertyValueDao.delete(object);
		else
			logger.error("删除属性值对象失败，属性值对象为null!");
	}

	@Override
	public List<Propertyvalue> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Propertyvalue> findByPage(int pagenow, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Propertyvalue findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 *  插入指定属性值集合
	 * @param propertyvalues 属性值集合
	 */
	public void addAll(List<Propertyvalue> propertyvalues)
	{
		if (propertyvalues != null && propertyvalues.size() > 0)
		{
			for (Iterator<Propertyvalue> iterator = propertyvalues.iterator(); iterator
					.hasNext();) {
				Propertyvalue propertyvalue = (Propertyvalue) iterator.next();
				add(propertyvalue);
			}
		}
		else
			logger.error("批量插入数据失败，属性集合为null！");
	}
	/**
	 *  更新指定属性值集合
	 * @param propertyvalues 属性值集合
	 */
	public void updateAll(List<Propertyvalue> propertyvalues)
	{
		if (propertyvalues != null && propertyvalues.size() > 0)
		{
			for (Iterator<Propertyvalue> iterator = propertyvalues.iterator(); iterator
					.hasNext();) {
				Propertyvalue propertyvalue = (Propertyvalue) iterator.next();
				update(propertyvalue);
			}
		}
		else
			logger.error("批量插入数据失败，属性集合为null！");
	}
	/**
	 *  更新指定属性值集合
	 * @param propertyvalues 属性值集合
	 */
	public void updateAll(Set<Propertyvalue> propertyvalues)
	{
		if (propertyvalues != null && propertyvalues.size() > 0)
		{
			for (Iterator<Propertyvalue> iterator = propertyvalues.iterator(); iterator
					.hasNext();) {
				Propertyvalue propertyvalue = (Propertyvalue) iterator.next();
				update(propertyvalue);
			}
		}
		else
			logger.error("批量插入数据失败，属性集合为null！");
	}
	/**
	 *  删除指定属性值集合
	 * @param propertyvalues 属性值集合
	 */
	public void deleteAll(List<Propertyvalue> propertyvalues)
	{
		if (propertyvalues != null && propertyvalues.size() > 0)
		{
			for (Iterator<Propertyvalue> iterator = propertyvalues.iterator(); iterator
					.hasNext();) {
				Propertyvalue propertyvalue = (Propertyvalue) iterator.next();
				delete(propertyvalue);
			}
		}
		else
			logger.error("批量删除数据失败，属性集合为null！");
	}
	/**
	 *  删除指定属性值集合
	 * @param propertyvalues 属性值集合
	 */
	public void deleteAll(Set<Propertyvalue> propertyvalues)
	{
		if (propertyvalues != null && propertyvalues.size() > 0)
		{
			for (Iterator<Propertyvalue> iterator = propertyvalues.iterator(); iterator
					.hasNext();) {
				Propertyvalue propertyvalue = (Propertyvalue) iterator.next();
				delete(propertyvalue);
			}
		}
		else
			logger.error("批量删除数据失败，属性集合为null！");
	}

	public List<Propertyvalue> findAllByShopGoodsId(Integer shopGoodsId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
