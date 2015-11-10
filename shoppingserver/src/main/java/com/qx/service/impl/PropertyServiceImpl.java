package com.qx.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.qx.dao.impl.PropertyDaoImpl;
import com.qx.model.Baseproperty;
import com.qx.model.Property;
import com.qx.service.ICommonService;
@Service("propertyService")
public class PropertyServiceImpl implements ICommonService<Property> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PropertyServiceImpl.class);

	@Resource(name="propertyDao")
	private PropertyDaoImpl propertyDaoImpl;
	@Resource(name="basepropertyService")
	private BasepropertyServiceImpl basepropertyServiceImpl;
	@Override
	public void add(Property object) {
		// TODO Auto-generated method stub
		if (object != null)
			propertyDaoImpl.add(object);
		else
			logger.error("待插入属性异常，属性为null！");
	}

	@Override
	public void update(Property object) {
		// TODO Auto-generated method stub
		if (object != null)
			propertyDaoImpl.update(object);
		else
			logger.error("待更新属性异常，属性为null！");
	}

	@Override
	public void delete(Property object) {
		// TODO Auto-generated method stub
		if (object != null)
			propertyDaoImpl.delete(object);
		else
			logger.error("待删除属性异常，属性为null！");
	}

	@Override
	public List<Property> findAll() {
		// TODO Auto-generated method stub
		return propertyDaoImpl.findAll();
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Property> findByPage(int pagenow, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 *  添加属性集合
	 * @param properties 属性集合
	 */
	public void addAll(List<Property> properties)
	{
		for (Iterator<Property> iterator = properties.iterator(); iterator.hasNext();) {
			Property property = (Property) iterator.next();
			add(property);
		}
	}
	/**
	 *  添加指定商家的默认属性集合
	 * @param shopId 商家id
	 */
	public void addDefaultPropertyByShopId(Integer shopId)
	{
		List<Baseproperty> baseproperties = basepropertyServiceImpl.findAllActiveBaseproperty();
		List<Property> properties = new ArrayList<Property>();
		for (Iterator<Baseproperty> iterator = baseproperties.iterator(); iterator.hasNext();) {
			Baseproperty baseproperty = (Baseproperty) iterator.next();
			Property property = new Property();
			property.setPropertyName(baseproperty.getBaseName());
			property.setPropertyStatus(1);
			property.setShopId(shopId);
			property.setPropertyType(baseproperty.getBaseType());
			property.setPropertyShowname(baseproperty.getBaseShowname());
			properties.add(property);
		}
		addAll(properties);
	}
	/**
	 *  查询指定商家的所有属性列表
	 * @param shopId 商家id
	 * @return 属性列表集合
	 */
	public List<Property> findAllByShopId(Integer shopId)
	{
		if ( shopId != null)
			return propertyDaoImpl.findAllByShopId(shopId);
		else
		{
			logger.error("查询属性的商家id为null！");
			return null;
		}
	}
	/**
	 *  查询指定商家的所有未激活属性列表
	 * @param shopId 商家id
	 * @return 属性列表集合
	 */
	public List<Property> findAllNonActiveByShopId(Integer shopId)
	{
		if ( shopId != null)
			return propertyDaoImpl.findAllNonActiveByShopId(shopId);
		else
		{
			logger.error("查询属性的商家id为null！");
			return null;
		}
	}
	/**
	 * 根据属性id和商家id查询属性
	 * @param id 属性id
	 * @param shopId 商家id
	 * @return 属性对象实例
	 */
	public Property findByIdAndShopId(Integer id, Integer shopId) {
		// TODO Auto-generated method stub
		List list = propertyDaoImpl.findById(id, shopId);
		return  ((list != null && list.size() > 0)?(Property)list.get(0):null);
	}
	/**
	 *  根据商家id和属性名查询属性实例
	 * @param pName 属性名
	 * @param shopId 商家id
	 * @return 属性对象实例
	 */
	public Property findByShopIdAndName(String pName, Integer shopId) {
		// TODO Auto-generated method stub
		List list = propertyDaoImpl.findByShopIdAndName(pName, shopId);
		return  ((list != null && list.size() > 0)?(Property)list.get(0):null);
	}

}
