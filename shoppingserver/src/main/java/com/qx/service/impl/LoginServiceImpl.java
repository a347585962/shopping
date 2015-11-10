package com.qx.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qx.dao.ICommonUserDao;
import com.qx.dao.impl.LoginDaoImpl;
import com.qx.model.Admininfo;
import com.qx.model.Userinfo;
import com.qx.service.ICommonUserService;
import com.qx.utils.ConstantUtil;

@Service("adminUserService")
public class LoginServiceImpl implements ICommonUserService<Admininfo> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(LoginServiceImpl.class);
	@Resource(name="adminUserDao")
	private LoginDaoImpl LoginDao;

	@Override
	public Admininfo findUser(String username, String password) {
		// TODO Auto-generated method stub
		List list = LoginDao.findUserByName(username);
		logger.info(list.size());
		return (list == null || list.size() == 0) ? null : ((Admininfo) list.get(0));
	}

	@Override
	public void add(Admininfo admininfo) {
		// TODO Auto-generated method stub
		if (admininfo != null)
		{
			LoginDao.add(admininfo);
		}
		else
			logger.info("新增对象为null");
	}

	@Override
	public void update(Admininfo admininfo) {
		// TODO Auto-generated method stub
		if (admininfo != null)
			LoginDao.update(admininfo);
		else
			logger.info("更新对象为null");
	}

	@Override
	public List<Admininfo> findAll() {
		// TODO Auto-generated method stub
		return LoginDao.findAllUser();
	}

	@Override
	public void delete(Admininfo admininfo) {
		// TODO Auto-generated method stub
		if (admininfo != null)
			LoginDao.delete(admininfo);
		else
			logger.info("删除对象为null");
	}

	@Override
	public Admininfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		List list = LoginDao.selectByPrimaryKey(id);
		return list == null?null:(Admininfo)list.get(0);
	}
	
	

	@Override
	public boolean loginCheck(Admininfo userinfo, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admininfo findUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addDefaultAdminByShopId(Integer shopId, String phone)
	{
		Admininfo admin = new Admininfo();
		admin.setAdminStatus(1);
		admin.setPassword(ConstantUtil.DEFAULTADMINPWD);
		admin.setUserName(phone);
		admin.setRegisterTime(new Date());
		admin.setShopId(shopId);
		LoginDao.add(admin);
	}
	public Admininfo selectByPrimaryKey(Integer id , Integer shopId) {
		// TODO Auto-generated method stub
		List list = LoginDao.selectByPrimaryKey(id, shopId);
		return list == null?null:(Admininfo)list.get(0);
	}
	public List<Admininfo> findAllByShopId(Integer shopId) {
		// TODO Auto-generated method stub
		return LoginDao.findAllUserByShopId(shopId);
	}
}
