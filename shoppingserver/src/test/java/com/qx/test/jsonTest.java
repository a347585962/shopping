package com.qx.test;

import org.apache.log4j.Logger;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qx.model.Level1;
import com.qx.model.Level2;
import com.qx.model.Level3;
import com.qx.model.Orderinfo;
import com.qx.service.ILevelOneService;
import com.qx.service.impl.LevelOneServiceImpl;
import com.qx.utils.JsonParserUtil;

public class jsonTest {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(jsonTest.class);

	private JsonGenerator jsonGenerator = null;
	private ObjectMapper objectMapper = null;
	
	private ILevelOneService levelOneService; 
	private OutputStream os;
	//ByteArrayOutputStream baos = new ByteArrayOutputStream(1024 *10);  
	StringWriter stringWriter = null;
	//@Before
	public void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		levelOneService = context.getBean(LevelOneServiceImpl.class);
		objectMapper = new ObjectMapper();
		stringWriter = new StringWriter(); 
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
					stringWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After
	public void destory() {
		try {
			if (jsonGenerator != null) {
				jsonGenerator.flush();
			}
			if (!jsonGenerator.isClosed()) {
				jsonGenerator.close();
			}
			jsonGenerator = null;
			objectMapper = null;
			System.gc();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test      
	public void testjson() throws Exception {
		//List<Level1> list = levelOneService.findAllLevelOne();
		List<Level1> list = null;
		logger.info("list = " + String.valueOf(list));
		// list转换成JSON字符串
		//jsonGenerator.writeObject(list);
		//System.out.println();
		System.out.println("ObjectMapper"); 
		// 用objectMapper直接返回list转换成的JSON字符串
		System.out.println("1###=" + objectMapper.writeValueAsString(list));
		jsonGenerator.writeStartArray();   
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Level1 level1 = (Level1) iterator.next();
			jsonGenerator.writeStartObject();
			jsonGenerator.writeObjectField("id", level1.getLevel1Id());
			jsonGenerator.writeObjectField("name", level1.getLevel1Name());
			
			
			jsonGenerator.writeFieldName("children");
			jsonGenerator.writeStartArray();
			Set leve2s = level1.getLevel2s();
			for (Iterator iterator2 = leve2s.iterator(); iterator2.hasNext();) {
				Level2 object = (Level2) iterator2.next();
				jsonGenerator.writeStartObject();
				jsonGenerator.writeObjectField("id", object.getLevel2Id());
				jsonGenerator.writeObjectField("name", object.getLevel2Name());
				
				jsonGenerator.writeFieldName("children");
				jsonGenerator.writeStartArray();
				Set leve3s = object.getLevel3s();
				for (Iterator iterator3 = leve3s.iterator(); iterator3.hasNext();) {
					Level3 level3  = (Level3) iterator3.next();
					jsonGenerator.writeStartObject();
					jsonGenerator.writeObjectField("id", level3.getLevel3Id());
					jsonGenerator.writeObjectField("name", level3.getLevel3Name());
					jsonGenerator.writeEndObject();
				}
				jsonGenerator.writeEndArray();
				jsonGenerator.writeEndObject();
			}
			
		    jsonGenerator.writeEndArray();
			jsonGenerator.writeEndObject();
		}
		//System.out.println("json = " + jsonGenerator.toString());
		jsonGenerator.writeEndArray();
		jsonGenerator.close();
		//baos.writeTo(System.out);
		//System.out.println("=========================");
		logger.info("json = " + stringWriter.toString());
		//System.out.print("2###=");
		// objectMapper list转换成JSON字符串
		//objectMapper.writeValue(baos, list);
		
		//System.out.println("fuck = " + baos.toString());
	}
	@Test
	public void main() throws JsonGenerationException, JsonMappingException, IOException {
		Level1 bean = new Level1();
		bean.setLevel1Id(1);
		bean.setLevel1Name("123");
		//List<Level1> level1s = new Arra
		StringWriter writer = new StringWriter();
//		List<Level1> list = levelOneService.findAllLevelOne();
		List<Level1> list = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
				writer);
		jsonGenerator.writeStartArray();
		    for(Level1 key: list) {
		    	jsonGenerator.writeStartObject();
		    	jsonGenerator.writeObjectField("id", key.getLevel1Id());
		      jsonGenerator.writeEndObject();
		    }
		    jsonGenerator.writeEndArray();
		    jsonGenerator.close();
        System.out.println(writer);

		String str = objectMapper.writeValueAsString(bean);
		System.out.println(str);
		
		
		

	     try {  
	   
	    JsonFactory jfactory = new JsonFactory();  
	   
	    /*** write to file ***/  
	    JsonGenerator jGenerator = jfactory.createJsonGenerator(new File(  
	            "d:\\user.json"), JsonEncoding.UTF8);  
	    jGenerator.writeStartArray();
	    for(Level1 key: list) {
	    	jGenerator.writeStartObject();
	    	jGenerator.writeObjectField("id", key.getLevel1Id());
	    	jGenerator.writeEndObject();
	    }
	    jGenerator.writeEndArray();
	   
	    jGenerator.close();  
	   
	     } catch (JsonGenerationException e) {  
	   
	    e.printStackTrace();  
	   
	     } catch (JsonMappingException e) {  
	   
	    e.printStackTrace();  
	   
	     } catch (IOException e) {  
	   
	    e.printStackTrace();  
	   
	     }  
		
		}
	@Test
	public void testjsonorder() 
	{
		//String order = \"{\"orderAddress\":\"四川省 遂宁市 安居区 西山路\n吴松霖\n999999\",\"orderTime\":1445679902576,\"orderType\":1,\"payType\":0,\"suborder\":[{\"goodsId\":5,\"goodsNum\":0,\"remark\":\"呕吐\"},{\"goodsId\":4,\"goodsNum\":0,\"remark\":\"考虑考虑\"}],\"userId\":0}";
		//String order = "{\"orderAddress\":\"四川省 遂宁市 安居区 西山路\n吴松霖\n999999\",\"orderTime\":1445679902576,\"orderType\":1,\"payType\":0,\"suborders\":[{\"goodsId\":5,\"goodsNum\":0,\"remark\":\"呕吐\"},{\"goodsId\":4,\"goodsNum\":0,\"remark\":\"考虑考虑\"}],\"userId\":0}";
		String order = "{\"orderAddress\":\"四川省 遂宁市 安居区 西山路\n吴松霖\n999999\",\"orderType\":1,\"payType\":0,\"suborders\":[{\"goodsId\":5,\"goodsNum\":0,\"remark\":\"哦拒绝\"},{\"goodsId\":4,\"goodsNum\":0,\"remark\":\"无图\"},{\"goodsId\":6,\"goodsNum\":0,\"remark\":\"哦哦呕吐\"},{\"goodsId\":7,\"goodsNum\":0,\"remark\":\"哦兔兔\"}],\"userId\":0}";
		order = order.replaceAll("\n", "");
		logger.info(order);
		try {
			Orderinfo orderinfo = (Orderinfo)JsonParserUtil.getInstance().jsonToBean(order, Orderinfo.class);
			logger.info(String.valueOf(orderinfo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
