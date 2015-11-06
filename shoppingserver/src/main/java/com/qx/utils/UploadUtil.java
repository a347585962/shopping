package com.qx.utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {
	private static final String  ORIGNALSTR = "abcdefghijklmnopqrstuvwxyz";
	private static final int LENGTH = 8; 
	private static final String FILEWEBPATH = PropertiesUtil.getInstace().getFileProperties("file.uploadpath");
  private static UploadUtil uploadUtil = new UploadUtil();
  private UploadUtil()
  {
	  
  }
  public static  UploadUtil getInstance()
  {
	  return uploadUtil;
  }
  /**
   * 
   * @param file 文件
   * @param savePath 存储路径
   * @return
   */
  public String upload(MultipartFile file,String savePath)
  {
	  //Map<String,String> filepro = XMLParserUtil.getInstance().ParserUtil("file.xml");
	  String imgPath = null;
	  String filename = file.getOriginalFilename();
	  String filesuffix = StringUtil2.getInstance().getSuffix(filename);
	  String realfilename = StringUtil2.getInstance().getRandomStr(ORIGNALSTR, LENGTH) + "." + filesuffix;	  
	  File f = new File(savePath,realfilename);
	  if(!f.exists())
	  {
		  f.mkdirs();
	  }
	  try {
		file.transferTo(f);
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	  imgPath = FILEWEBPATH +"/"+ realfilename;
	  return imgPath;
  }
}
