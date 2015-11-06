package com.qx.utils;

import org.apache.log4j.Logger;

import com.qx.model.Loginfo;
import com.qx.service.ILogService;

public class CommonUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CommonUtil.class);

	private CommonUtil(){}
	private static class SingletonFactory {
		private static CommonUtil commonUtil = new CommonUtil(); 
	}
	public static CommonUtil getInstance ()
	{
		return SingletonFactory.commonUtil;
	}
	
	public boolean saveLog(String logInfo, String ip, Integer userid, ILogService logService)
	{
		Loginfo loginfo = new Loginfo();
		loginfo.setOperaterId(userid);
		loginfo.setOperaterType(ConstantUtil.ADMINTYPE);
		loginfo.setOperateValue(logInfo);
		loginfo.setOperaterIp(ip);
		logService.add(loginfo);
		logger.info(String.valueOf(loginfo));
		return true;
	}
}
