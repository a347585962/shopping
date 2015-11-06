package com.qx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qx.dao.impl.OrderStatusDaoImpl;
import com.qx.model.Orderstatus;
import com.qx.service.ICommonService;
@Service("orderstatusService")
public class OrderStatusServiceImpl implements ICommonService<Orderstatus> {

	@Resource(name="orderstatusDao")
	private OrderStatusDaoImpl dao;
	@Override
	public void add(Orderstatus object) {
		// TODO Auto-generated method stub
		dao.add(object);
	}

	@Override
	public void update(Orderstatus object) {
		// TODO Auto-generated method stub
		dao.update(object);
	}

	@Override
	public void delete(Orderstatus object) {
		// TODO Auto-generated method stub
		dao.delete(object);
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
	public List<Orderstatus> findByPage(int pagenow, int pagesize) {
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
		return dao.findByOrderid(orderid);
	}


}
