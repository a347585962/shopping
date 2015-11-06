package com.qx.utils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mysql.jdbc.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class StringUtil {
	/**
	 * Logger for this class
	 */
	private static StringUtil stringutil = new StringUtil();
	private static final Logger logger = Logger.getLogger(StringUtil.class);
	private List<String> filepaths = new ArrayList<String>();
	private String filepath = "";
	private String oldStr = "计算机与软件工程学院";
	private String newStr = "学院";

	private StringUtil() {
	}

	public static StringUtil getInstance() {
		if (stringutil == null) {
			stringutil = new StringUtil();
		}
		return stringutil;
	}

	/**
	 * 根据参数进行分割，“:”前面表示属性名称，“:”后面表示属性的传递值
	 * 
	 * @param str
	 *            传递的参数值
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String[] splitAConStr(String str) {
		// String result = "";
		String[] strs = {};
		strs = str.split(":");
		strs[0] = "set" + Character.toUpperCase(strs[0].charAt(0))
				+ strs[0].substring(1);
		return strs;
	}

	public List<String> getFilepaths() {
		return filepaths;
	}

	public void setFilepaths(List<String> filepaths) {
		this.filepaths = filepaths;
	}

	public void addfilepath(String filepath) {
		this.filepaths.add(filepath);
	}

	/**
	 * 根据路径参数获取相应前台页面
	 * 
	 * @param path
	 * @return
	 */
	public static String getPageName(String path) {
		String result = "";
		Properties properties = new Properties();
		try {
			properties.load(StringUtil.class.getClassLoader()
					.getResourceAsStream("com/mc/utils/path.properties"));
			result = properties.getProperty(path);
		} catch (Exception e) {
			logger.error("读取属性文件失败\n信息如下:" + e.getLocalizedMessage());
		}
		return result;
	}

	public String replaceStr(String oldstr) {
		String newstr = "";
		if (oldstr.contains(oldStr)) {
			newstr = oldstr.replaceAll(oldStr, newStr);

			return newstr;
		} else {
			return oldstr;
		}

	}

	/**
	 * 转义字符串，为了在UEditor中完整的显示字符串
	 * 
	 * @param content
	 *            需要转义的文章字符串
	 * @return 转义之后的文章字符串
	 */
	public String zy(String content) {
		String result = content;
		result = result.replaceAll("\"", "&quot;");
		return result;
	}

	public String formatTime(String resDateStr) {
		java.text.DateFormat format1 = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		Timestamp date = Timestamp.valueOf(resDateStr);
		return format1.format(date);
	}

	/**
	 * 
	 * @param path
	 *            文件路径
	 * @return 文件物理绝对路径
	 */
	public String getPhysicsPath(String path) {
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest().getSession();
		String realPath = session.getServletContext().getRealPath(path);
		return realPath;
	}
	public boolean isNotEmpty(String str)
	{
		return str == null?false: !str.isEmpty();
	}
	public  String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        //logger.info("ip1 = " + ip + ",!StringUtils.isNullOrEmpty(ip) = " + !StringUtils.isNullOrEmpty(ip));
        if(!StringUtils.isNullOrEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        
        ip = request.getHeader("X-Real-IP");
        //logger.info("ip2 = " +ip + ",!StringUtils.isNullOrEmpty(ip)" + !StringUtils.isNullOrEmpty(ip));
        if(!StringUtils.isNullOrEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
}
