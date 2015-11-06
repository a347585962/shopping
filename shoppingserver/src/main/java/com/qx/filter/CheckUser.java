package com.qx.filter;

import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qx.model.Admininfo;

// 检查登录状态的过滤器
public class CheckUser implements Filter{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CheckUser.class);

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0; 
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		Admininfo u =(Admininfo)session.getAttribute("admin");
		//logger.info(u + "=========");
		arg0.setAttribute("uri",request.getRequestURI());
		if(u != null)
		{
			arg2.doFilter(arg0,arg1);	
		}
		else
		{
			request.getRequestDispatcher("/loginui").forward(arg0, arg1);
		}
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
