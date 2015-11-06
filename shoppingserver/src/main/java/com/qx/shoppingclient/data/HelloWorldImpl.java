package com.qx.shoppingclient.data;

import com.qx.utils.XMLParserUtil;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHello(String username) {
		// TODO Auto-generated method stub
		System.out.println("username = " + username);
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> "+ "<EventList Count=\"1\">"
					+ "<Event0 ycyx_no=\"0\" ycyx_type=\"E\" event=\"W3机柜温度通讯故障\" time=\"2015/07/24 16:38:17\" lvl_level=\"2\" /> "
					+ "</EventList>";
		return result;
	}

	
	public  void main() {
		String text = XMLParserUtil.getInstance().parserXmlFile2String("alertinfo.xml");
	    System.out.println(text);
	}
	

}
