package com.qx.dao.impl;

import org.apache.log4j.Logger;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ICommonUserDao;
import com.qx.model.Userinfo;
@Repository("clientUserDao")
public class ClientUserDaoImpl implements ICommonUserDao<Userinfo> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ClientUserDaoImpl.class);

	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	@Override
	public List<Userinfo> findAllUser() {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Userinfo");
	}

	@Override
	public List<Userinfo> findUserByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Userinfo user) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(user);
	}

	@Override
	public void delete(Userinfo user) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(user);
	}

	@Override
	public void update(Userinfo user) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(user);
	}

	@Override
	public int countofsize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Userinfo> findUserByName(String username) {
		// TODO Auto-generated method stub
		String hql="from Userinfo  where userPhone='" + username + "'";
		logger.info(hql);
		//List<Admininfo> adminlist = mysqlhibernateTemplete.findByNamedParam(hql, new String [] {"username"}, new Object[]{username,password});
		//logger.info(adminlist);
		return mysqlhibernateTemplete.find(hql);
	}

	@Override
	public List<Userinfo> selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Userinfo where adminId = " + id);
	}

	

}
