package com.qx.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ICommonDao;
import com.qx.model.Orderstatus;
@Repository("orderstatusDao")
public class OrderStatusDaoImpl implements ICommonDao<Orderstatus> {

	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	@Override
	public void add(Orderstatus object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(object);
	}

	@Override
	public void update(Orderstatus object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(object);
	}

	@Override
	public void delete(Orderstatus object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(object);
	}

	@Override
	public List<Orderstatus> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Orderstatus> findByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orderstatus findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Orderstatus findByOrderid(Integer orderid)
	{
		List list = mysqlhibernateTemplete.find("from Orderstatus where orderinfo.orderId=" + orderid);
		return ( list == null || list.size() == 0)? null: (Orderstatus)list.get(0);
	}

}
