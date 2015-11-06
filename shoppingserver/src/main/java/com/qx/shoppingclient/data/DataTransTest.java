package com.qx.shoppingclient.data;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/requestdate")
public class DataTransTest {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DataTransTest.class);

	@ResponseBody
	@RequestMapping("/test")
	public String test()
	{
		logger.info("tyun");
		return "{\"data\":\"张洪\"}";
	}
}
