package com.qx.utils;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLParserUtil {
     private static XMLParserUtil xmlParserUtil = new XMLParserUtil();
     private XMLParserUtil(){}
     public static XMLParserUtil getInstance()
     {
    	 return xmlParserUtil;
     }
     /**
      * 
      * @param filename 文件名
      * @return 解析xml文件
      */
     public Map<String,String> ParserUtil(String filename)
     {
    	 Map<String,String> filepro = new HashMap<String,String>();
    	 SAXReader saxReader = new SAXReader();
    	InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
	
			try {
				Document doc = saxReader.read(in);
				Element QQDocument = (Element) doc.selectObject("/file/filepath");
				
				String filepath = QQDocument.getStringValue();
				//System.out.println(filepath);
				filepro.put("filepath",filepath);
				Element passwordDocument = (Element) doc.selectObject("/file/imagepath");
				String imagepath = passwordDocument.getStringValue();
				filepro.put("imagepath",imagepath);
				/*Element stmp = (Element) doc.selectObject("/user/smtphost");
				String smtpost = stmp.getStringValue();
				userInfo.put("smtpost", smtpost);		*/		
			} catch (DocumentException e) {
				e.printStackTrace();
			}
     
    	 return filepro;
     }
     /**
      *  解析请求WebService的命令xml文件，转为字符串
      * @param fileName xml所在位置
      * @return 请求WebService的xml命令字符串
      */
 	public String parserXmlFile2String(String fileName) {
 		String realPath = this.getClass().getClassLoader().getResource("/").getPath();
 		realPath += fileName;
 		// logger.info(realPath );
 		Document document = null;
 		String xmlStr = "";
 		SAXReader reader = new SAXReader();
 		try {
 			document = reader.read(new File(realPath));
 			// document转换为String字符串
 			String documentStr = document.asXML();
 			xmlStr = documentStr;
 		} catch (DocumentException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();

 		}
 		return xmlStr;
 	}
}
