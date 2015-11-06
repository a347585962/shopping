package com.qx.utils;

import java.util.Random;

import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class StringUtil2 {
  private static StringUtil2 stringUtil = new StringUtil2();
  private StringUtil2(){}
  public static StringUtil2 getInstance()
  {
	  return stringUtil;
  }
  /**
   * 
   * @param orignalStr 愿字母集
   * @param length 长度
   * @return 随机得到length长度的字母
   */
  public String getRandomStr(String orignalStr,int length)
  {
	  String randomStr = "";
	  Random random = new Random();
	  for(int i=0;i<length;i++)
	  {
		  int index = random.nextInt(orignalStr.length()-1);
		  randomStr += orignalStr.charAt(index);
	  }
	  return randomStr;
  }
  /**
   * 
   * @param filename 文件名字
   * @return 得到文件后缀
   */
  public String getSuffix(String filename)
  {
	  String fileSuffix = "";
	 if(filename.contains("."))
	 {	 
		 int to = filename.lastIndexOf(".");
		 fileSuffix = filename.substring(to+1, filename.length());
	 }
	  return fileSuffix;
  }
  /**
   * 
   * @param path 文件路径
   * @return 文件物理绝对路径
   */
  public String getPhysicsPath(String path)
	{
		HttpSession session=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
		String realPath = session.getServletContext().getRealPath(path);
		return realPath;
	}
  public String getPictureFirstPath(String paths)
  {
	  String [] results = paths.split(",");
	  return results[0];
  }
}
