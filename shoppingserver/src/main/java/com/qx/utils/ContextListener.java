package com.qx.utils;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;

import com.qx.model.Admininfo;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *  用于在web服务关闭时手动关闭Quartz启动的线程
 * @author Administrator
 *
 */
public class ContextListener implements ServletContextListener, HttpSessionListener {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ContextListener.class);

	
	
	/**
	 * 在服务启动时执行的方法，不做操作
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
    /**
     *  在服务停止时执行的方法
     */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		 logger.info("关闭所有定时任务的线程！");
		 WebApplicationContext webApplicationContext = (WebApplicationContext) sce  
	                .getServletContext()  
	                .getAttribute(  
	                        WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);  
		 //sce.
	     
	}


	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		Admininfo admininfo = (Admininfo)session.getAttribute("admin");
		logger.info("前 = " + admininfo);
		arg0.getSession().invalidate(); 
		admininfo = (Admininfo)session.getAttribute("admin");
		logger.info("后 = " + admininfo);
        logger.info("销毁一个会话");  
	}
	
}
