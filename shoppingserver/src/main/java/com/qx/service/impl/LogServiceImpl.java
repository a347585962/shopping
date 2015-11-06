package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qx.dao.ILogDao;
import com.qx.model.Admininfo;
import com.qx.model.Loginfo;
import com.qx.model.Userinfo;
import com.qx.service.ICommonUserService;
import com.qx.service.ILogService;
import com.qx.utils.ConstantUtil;
@Service
public class LogServiceImpl implements ILogService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LogServiceImpl.class);

	@Autowired
	private ILogDao logDao;
	@Resource(name="clientUserService")
	private ICommonUserService<Userinfo> userService;
	@Resource(name="adminUserService")
	private ICommonUserService<Admininfo> adminService;
	
	@Override
	public void add(Loginfo loginfo) {
		// TODO Auto-generated method stub
        if (loginfo != null)
        {
        	
        	loginfo.setLogTime(new Date());
        	logDao.add(loginfo);
        }
        else
        	logger.info("新增的对象为null");
        	
	}

	@Override
	public List<Loginfo> findAll() {
		// TODO Auto-generated method stub
		return logDao.findAll();
	}

	@Override
	public List<Loginfo> findByPage(int start, int size) {
		// TODO Auto-generated method stub
		start = (start - 1) * size;
		List<Loginfo> list = logDao.findByPage(start , size);
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++) {
				Loginfo loginfo = list.get(i);
				//logger.info(loginfo.getOperaterType() + "," + loginfo.getOperaterType().equals(ConstantUtil.ADMINTYPE));
				if (loginfo.getOperaterType().equals(ConstantUtil.ADMINTYPE))
				{
					Admininfo admin = adminService.selectByPrimaryKey(Integer.parseInt(loginfo.getOperaterType()));
					loginfo.setOperaterType("管理员日志");
					loginfo.setAdmininfo(admin);
				}
				else if (loginfo.getOperaterType().equals(ConstantUtil.USERTYPE)) {
					Userinfo user = userService.selectByPrimaryKey(Integer.parseInt(loginfo.getOperaterType()));
					loginfo.setOperaterType("用户日志");
					loginfo.setUserinfo(user);
				}
				list.set(i, loginfo);
			}
		}
		return list;
	}

	@Override
	public int findLogSize() {
		// TODO Auto-generated method stub
		return logDao.findLogSize();
	}

	@Override
	public Loginfo selectByPrimaryId(Integer id) {
		// TODO Auto-generated method stub
		if (id != null)
		{
			List<Loginfo> list = logDao.selectByPrimaryId(id);
			Loginfo loginfo = null;
			if (list != null && list.size() > 0)
			{
				loginfo = list.get(0);
				if (loginfo.getOperaterType().equals(ConstantUtil.ADMINTYPE)) {
					Admininfo admin = adminService.selectByPrimaryKey(Integer
							.parseInt(loginfo.getOperaterType()));
					loginfo.setOperaterType("管理员日志");
					loginfo.setAdmininfo(admin);
				} else if (loginfo.getOperaterType().equals(ConstantUtil.USERTYPE)) {
					Userinfo user = userService.selectByPrimaryKey(Integer
							.parseInt(loginfo.getOperaterType()));
					loginfo.setOperaterType("用户日志");
					loginfo.setUserinfo(user);
				}
			}

			return loginfo;
		}
		else
		{
			logger.error("查询的日志id为null!");
			return null;
		}
	}

}
