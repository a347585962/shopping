package com.qx.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.qx.model.Level1;
import com.qx.model.Level2;
import com.qx.model.Level3;
import com.qx.service.ILevelOneService;

public class JsonParserUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(JsonParserUtil.class);

	private JsonParserUtil() {
	}

	private static class SingletonFactory {
		private static JsonParserUtil jsonParserUtil = new JsonParserUtil();
	}

	public static JsonParserUtil getInstance() {
		return SingletonFactory.jsonParserUtil;
	}

	public String parserLevelList(List<Level1> level1s) {
		JsonGenerator jsonGenerator = null;
		ObjectMapper objectMapper = null;
		StringWriter stringWriter = null;
		String jsonStr = "";
		objectMapper = new ObjectMapper();
		stringWriter = new StringWriter();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
					stringWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (level1s != null) {
				jsonGenerator.writeStartArray();
				for (Iterator<Level1> iterator = level1s.iterator(); iterator
						.hasNext();) {
					Level1 level1 = (Level1) iterator.next();
					jsonGenerator.writeStartObject();
					jsonGenerator.writeObjectField("id",
							"1_" + level1.getLevel1Id());
					jsonGenerator.writeObjectField("name",
							level1.getLevel1Name());
					jsonGenerator.writeObjectField("img",
							level1.getLevel1Img());
					jsonGenerator.writeFieldName("children");
					jsonGenerator.writeStartArray();
					Set leve2s = level1.getLevel2s();
					for (Iterator<Level2> iterator2 = leve2s.iterator(); iterator2
							.hasNext();) {
						Level2 object = (Level2) iterator2.next();
						jsonGenerator.writeStartObject();
						jsonGenerator.writeObjectField("id",
								"2_" + object.getLevel2Id());
						jsonGenerator.writeObjectField("name",
								object.getLevel2Name());
						jsonGenerator.writeObjectField("img",
								object.getLevel2Img());
						jsonGenerator.writeFieldName("children");
						jsonGenerator.writeStartArray();
						Set leve3s = object.getLevel3s();
						for (Iterator<Level3> iterator3 = leve3s.iterator(); iterator3
								.hasNext();) {
							Level3 level3 = (Level3) iterator3.next();
							jsonGenerator.writeStartObject();
							jsonGenerator.writeObjectField("id",
									"3_" + level3.getLevel3Id());
							jsonGenerator.writeObjectField("name",
									level3.getLevel3Name());
							jsonGenerator.writeObjectField("img",
									level3.getLevel3Img());
							jsonGenerator.writeEndObject();
						}
						jsonGenerator.writeEndArray();
						jsonGenerator.writeEndObject();
					}

					jsonGenerator.writeEndArray();
					jsonGenerator.writeEndObject();
				}
				// System.out.println("json = " + jsonGenerator.toString());
				jsonGenerator.writeEndArray();
				jsonGenerator.close();
			}
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		jsonStr = stringWriter.toString();
		return jsonStr;
	}

	/**
	 * 将对象list转为json字符串
	 * 
	 * @param list
	 *            list集合
	 * @return json字符串
	 */
	public <T> String ParseListToJSON(List<T> list) {
		String result = "";
		ObjectMapper objectMapper = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		if (list != null) {
			try {
				objectMapper = new ObjectMapper();
				result = objectMapper.writeValueAsString(list);

			} catch (JsonGenerationException e) {

				e.printStackTrace();
			} catch (JsonMappingException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		// result = baos.toString();
		return result;
	}

	/**
	 * 对象转为json字符串
	 * 
	 * @param o
	 *            对象实例
	 * @return json字符串
	 */
	public String Obj2JsonStr(Object o) {
		String result = "";
		ObjectMapper objectMapper = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		if (o != null) {
			try {
				objectMapper = new ObjectMapper();
				result = objectMapper.writeValueAsString(o);

			} catch (JsonGenerationException e) {

				e.printStackTrace();
			} catch (JsonMappingException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 *  json 转为对象
	 * @param json json字符串
	 * @param cls class
	 * @return 对象
	 * @throws Exception
	 */
	public Object jsonToBean(String json, Class<?> cls) throws Exception {
		ObjectMapper objectMapper = null;
		objectMapper = new ObjectMapper();
		Object vo = objectMapper.readValue(json, cls);
		return vo;
	}
}
