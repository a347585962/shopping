package com.qx.utils;

import org.apache.log4j.Logger;


import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
//import java.util.logging.Logger;

import org.apache.commons.dbcp.BasicDataSource;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;
/**
 *  在服务停止时关闭数据库注册和数据库连接
 * @author John
 *
 */
public class XBasicDataSource extends BasicDataSource {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(XBasicDataSource.class);


	
	@Override
	public synchronized void close() throws SQLException {
		// TODO Auto-generated method stub
		 Enumeration<Driver> drivers = DriverManager.getDrivers();
		    Driver d = null;
		    while (drivers.hasMoreElements()) {
		        try {
		            d = drivers.nextElement();
		            DriverManager.deregisterDriver(d);
		            logger.warn(String.format("Driver %s deregistered", d));
		        }
		        catch (SQLException ex) {
		        	logger.warn(String.format("Error deregistering driver %s", d), ex);
		        }
		    }
		    try {
		        AbandonedConnectionCleanupThread.shutdown();
		    }
		    catch (InterruptedException e) {
		    	logger.warn("SEVERE problem cleaning up: " + e.getMessage() , e);
		        e.printStackTrace();
		    }
		    super.close();
	}
}
