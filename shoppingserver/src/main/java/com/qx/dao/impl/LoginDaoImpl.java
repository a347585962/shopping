package com.qx.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ICommonUserDao;
import com.qx.dao.LoginDao;
import com.qx.model.Admininfo;
import com.qx.model.Userinfo;
import com.qx.utils.ConstantUtil;
@Repository("adminUserDao")
public class LoginDaoImpl implements ICommonUserDao<Admininfo>{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);
	@Resource(name="mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	@Override
	public void update(Admininfo admininfo) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(admininfo);
	}

	

	@Override
	public void delete(Admininfo admininfo) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(admininfo);
	}

	@Override
	public List<Admininfo> selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Admininfo where adminId = " + id);
	}

	@Override
	public List<Admininfo> findUserByName(String username) {
		// TODO Auto-generated method stub
		String hql="from Admininfo  where userName='" + username + "'";
		logger.info(hql);
		//List<Admininfo> adminlist = mysqlhibernateTemplete.findByNamedParam(hql, new String [] {"username"}, new Object[]{username,password});
		//logger.info(adminlist);
		return mysqlhibernateTemplete.find(hql);
	}

	@Override
	public List<Admininfo> findAllUser() {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Admininfo");
	}

	@Override
	public List<Admininfo> findUserByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Admininfo user) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(user);
	}

	@Override
	public int countofsize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Admininfo> selectByPrimaryKey(Integer id, Integer shopId) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Admininfo where adminId = " + id + " and shopId=" + shopId);
	}
	public List<Admininfo> findAllUserByShopId(Integer shopId) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Admininfo where adminStatus=1 and shopId=" + shopId);
	}
}
