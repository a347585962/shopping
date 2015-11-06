package com.qx.utils;

import org.apache.log4j.Logger;

import org.springframework.web.multipart.MultipartFile;


public class FileUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FileUtil.class);

	private FileUtil() {
	}

	private static class SingletonFactory {
		private static FileUtil fileUtil = new FileUtil();
	}

	public static FileUtil getInstance() {
		return SingletonFactory.fileUtil;
	}

	/**
	 * 
	 * @param files
	 *            要进行上传的图片文件
	 * @return 上传照片的路径
	 */
	public String uploadFiels(MultipartFile[] files) {
		String imagepath = "";
		String imagepaths = "";
	    //logger.info("funck .....");
		for (MultipartFile file : files) {
			if (file.isEmpty())
				continue;
			else {
			//	logger.info("size = " + files.length);
				if (files.length == 1)
				{
					imagepath = UploadUtil.getInstance().upload(
							file,
							StringUtil.getInstance()
									.getPhysicsPath(PropertiesUtil.getInstace().
											getFileProperties("file.uploadpath")));
					imagepaths += imagepath;
				}
				else {
					imagepath = UploadUtil.getInstance().upload(
							file,
							StringUtil.getInstance()
									.getPhysicsPath(PropertiesUtil.getInstace().
											getFileProperties("file.uploadpath")));
					imagepaths += imagepath + PropertiesUtil.getInstace().getFileProperties("image.regex");
				}
			}
		}
		return imagepaths;
	}
}
