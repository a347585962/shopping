package com.qx.utils;

import org.apache.log4j.Logger;

import java.util.Properties;


public class PropertiesUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PropertiesUtil.class);
	
	private PropertiesUtil(){}
	private static class SingletonFactory {
		private static PropertiesUtil PROPERTIESUTIL = new PropertiesUtil();
	}
	public static PropertiesUtil getInstace()
	{
		return SingletonFactory.PROPERTIESUTIL;
	}
	/**
	 *  根据属性名称获取属性文件对应的属性值
	 * @param propertiesName 属性名称
	 * @return 属性值
	 */
	public String getFileProperties(String propertiesName)
	{
		String imsPropertiesValue = null;
    	Properties properties = new Properties();
    	try {
			properties.load(PropertiesUtil.class.getClassLoader().
					getResourceAsStream("/properties/file.properties"));
			imsPropertiesValue = properties.getProperty(propertiesName);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}
    	return imsPropertiesValue;
	}
}
