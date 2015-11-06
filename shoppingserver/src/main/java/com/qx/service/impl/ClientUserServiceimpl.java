package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qx.dao.ICommonUserDao;
import com.qx.model.Admininfo;
import com.qx.model.Userinfo;
import com.qx.service.ICommonUserService;
@Service("clientUserService")
public class ClientUserServiceimpl implements ICommonUserService<Userinfo>{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ClientUserServiceimpl.class);

	@Resource(name="clientUserDao")
	private ICommonUserDao<Userinfo> userDao;
	@Override
	public Userinfo findUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Userinfo user) {
		// TODO Auto-generated method stub
		if (user != null)
			userDao.add(user);
		else
			logger.error("新增用户对象为null!");
	}

	@Override
	public void update(Userinfo user) {
		// TODO Auto-generated method stub
		if (user != null)
			userDao.update(user);
		else
			logger.error("修改用户对象为null!");
	}

	@Override
	public List<Userinfo> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}

	@Override
	public void delete(Userinfo user) {
		// TODO Auto-generated method stub
		if (user != null)
			userDao.delete(user);
		else 
			logger.error("删除用户对象为null!");
	}

	@Override
	public Userinfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		List list = userDao.selectByPrimaryKey(id); 
		return (list ==null || list.size() == 0)?null:(Userinfo)list.get(0);
	}

	@Override
	public boolean loginCheck(Userinfo userinfo, String pwd) {
		// TODO Auto-generated method stub
		
		if ( userinfo != null)
		{
			if (userinfo.getPassword().equals(pwd))
				return true;
		}
		return false;
	}

	@Override
	public Userinfo findUserByName(String username) {
		// TODO Auto-generated method stub
		List list = userDao.findUserByName(username); 
		return (list ==null || list.size() == 0)?null:(Userinfo)list.get(0);
	}

}
