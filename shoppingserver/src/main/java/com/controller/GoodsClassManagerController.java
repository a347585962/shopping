package com.controller;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mc.model.Path;
import com.qx.model.Admininfo;
import com.qx.model.Level1;
import com.qx.model.Level2;
import com.qx.model.Level3;
import com.qx.model.Loginfo;
import com.qx.service.ILevelOneService;
import com.qx.service.ILevelThreeService;
import com.qx.service.ILevelTwoService;
import com.qx.service.ILogService;
import com.qx.utils.CommonUtil;
import com.qx.utils.ConstantUtil;
import com.qx.utils.FileUtil;
import com.qx.utils.PathUtil;
import com.qx.utils.StringUtil;

@Controller
@RequestMapping("/goodsclass")
public class GoodsClassManagerController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(GoodsClassManagerController.class);

	private Path path = null;

	@Autowired
	private ILevelOneService levelOneService;
	@Autowired
	private ILevelTwoService levelTwoService;
	@Autowired
	private ILevelThreeService levelThreeService;
	@Autowired
	private ILogService logService;

	private String sMenu = "goodsclass";
	// 商品类别管理
	@RequestMapping("/goodsclassmagview")
	public String GoodsClassManager(ModelMap modelMap) {

		String levelsJson = levelOneService.findAllLevelOne2Json();
		//logger.info(levelsJson);
		modelMap.addAttribute("levelsJson", levelsJson);
		// 根据字符串初始化Path类
		path = PathUtil.setPathParams(new String[] {
				"PackageName:goodsclassmanager", "ViewName:GoodsClassManager",
				"ViewTitle:商品管理--商品分类管理", "smenu:" + sMenu ,"mmenu:goodsclassmag"});
		return PathUtil.returnStr(path, modelMap);
	}

	@RequestMapping("/add")
	public String addClass(String parentid, String levelName, HttpSession httpSession, HttpServletRequest request,
			@RequestParam(value = "files", required = false) MultipartFile [] files) {
		//logger.info("parentId = " + parentid + ",levelName = " + levelName);

		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("admin");
		String imagePaths = FileUtil.getInstance().uploadFiels(files);
		Admininfo admin = object == null? null:(Admininfo)object;
		if (parentid != null && !parentid.isEmpty()) {
			String[] parentIds = parentid.split("_");
			Integer classType = Integer.parseInt(parentIds[0]);
			Integer classId = Integer.parseInt(parentIds[1]);
			//logger.info("classType = " + classType + ",classId = " + classId);
			switch (classType) {
			case 1:
				Level2 level2 = new Level2();
				level2.setLevel2Name(levelName);
				Level1 level1 = levelOneService.findById(classId);
				level2.setLevel1(level1);
				level2.setLevel2Img(imagePaths);
				//logger.info(String.valueOf(level1));
				//logger.info(String.valueOf(level2));
				
				level2 = levelTwoService.add(level2);
				CommonUtil.getInstance().saveLog("添加二级分类，二级分类id=" + level2.getLevel2Id(), ip, admin == null?null:admin.getAdminId(), logService);
				break;
			case 2:
				Level3 level3 = new Level3();
				Level2 level22 = levelTwoService.findById(classId);
				level3.setLevel2(level22);
				level3.setLevel3Name(levelName);
				level3.setLevel3Img(imagePaths);
				//logger.info(String.valueOf(level3));
				levelThreeService.add(level3);
				CommonUtil.getInstance().saveLog("添加三级分类，三级分类id=" + level3.getLevel3Id(), ip, admin == null?null:admin.getAdminId(), logService);
				
				break;
			case 3:
				break;
			default:
				break;
			}
		}
		else if (parentid == null || parentid.isEmpty())
		{
			Level1 level1 = new Level1();
			level1.setLevel1Name(levelName);
			level1.setLevel1Img(imagePaths);
			levelOneService.add(level1 );
			CommonUtil.getInstance().saveLog("添加一级分类，一级分类id=" + level1.getLevel1Id(), ip, admin == null?null:admin.getAdminId(), logService);
			
		}
		return "redirect:/goodsclass/goodsclassmagview";
	}
	@RequestMapping("/remove")
	@ResponseBody
	public String removeClass(HttpServletRequest request, HttpSession httpSession) {
		
		String parentid = request.getParameter("parentId");
        //String id = request.getAttribute("parentId") == null ? null:request.getAttribute("parentId").toString();
		//logger.info("parentId1 = " + parentid );
		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("admin");
		Admininfo admin = object == null? null:(Admininfo)object;
		if (parentid != null && !parentid.isEmpty()) {
			String[] parentIds = parentid.split("_");
			Integer classType = Integer.parseInt(parentIds[0]);
			Integer classId = Integer.parseInt(parentIds[1]);
			//logger.info("classType = " + classType + ",classId = " + classId);
			switch (classType) {
			case 1:
				Level1 level1 = levelOneService.findById(classId);
				levelOneService.delete(level1);
				CommonUtil.getInstance().saveLog("删除一级分类，一级分类id=" + level1.getLevel1Id(), ip, admin == null?null:admin.getAdminId(), logService);
				break;
			case 2:
				Level2 level2 = levelTwoService.findById(classId);
				levelTwoService.delete(level2);
				CommonUtil.getInstance().saveLog("删除二级分类，二级分类id=" + level2.getLevel2Id(), ip, admin == null?null:admin.getAdminId(), logService);
				break;
			case 3:
				Level3 level3 = levelThreeService.findById(classId);
				CommonUtil.getInstance().saveLog("删除三级分类，三级分类id=" + level3.getLevel3Id(), ip, admin == null?null:admin.getAdminId(), logService);
				break;
			default:
				break;
			}
			return "true";
		}
		return "false";
		
	}
	@RequestMapping("/update")
	public String updateClass(String parentid, String levelName, HttpServletRequest request, HttpSession httpSession,
			 @RequestParam(value = "files", required = false) MultipartFile [] files) {
		
		//logger.info("parentId = " + parentid + ",levelName = " + levelName);
		String ip = StringUtil.getInstance().getIp(request);
		Object object = httpSession.getAttribute("admin");
		Admininfo admin = object == null? null:(Admininfo)object;
		String imagePaths = null;
		if (parentid != null && !parentid.isEmpty()) {
			String[] parentIds = parentid.split("_");
			Integer classType = Integer.parseInt(parentIds[0]);
			Integer classId = Integer.parseInt(parentIds[1]);
			logger.info("classType = " + classType + ",classId = " + classId);
			switch (classType) {
			case 1:
				
				Level1 level1 = levelOneService.findById(classId);
				level1.setLevel1Name(levelName == "" || levelName == null ?level1.getLevel1Name():levelName);
				imagePaths = FileUtil.getInstance().uploadFiels(files);
				if (imagePaths != null && !imagePaths.isEmpty())
					level1.setLevel1Img(imagePaths);
				logger.info(String.valueOf(level1));
				levelOneService.update(level1);
				CommonUtil.getInstance().saveLog("修改一级分类，一级分类id=" + level1.getLevel1Id(), ip, admin == null?null:admin.getAdminId(), logService);
				break;
			case 2:
				Level2 level22 = levelTwoService.findById(classId);
				level22.setLevel2Name(levelName == "" || levelName == null ?level22.getLevel2Name():levelName);
				imagePaths = FileUtil.getInstance().uploadFiels(files);
				if (imagePaths != null && !imagePaths.isEmpty())
					level22.setLevel2Img(imagePaths);
				logger.info(String.valueOf(level22));
				levelTwoService.update(level22);
				CommonUtil.getInstance().saveLog("修改二级分类，二级分类id=" + level22.getLevel2Id(), ip, admin == null?null:admin.getAdminId(), logService);
				break;
			case 3:
				Level3 level3 = levelThreeService.findById(classId);
				level3.setLevel3Name(levelName == "" || levelName == null ?level3.getLevel3Name():levelName);
				imagePaths = FileUtil.getInstance().uploadFiels(files);
				if (imagePaths != null && !imagePaths.isEmpty())
					level3.setLevel3Img(imagePaths);
				logger.info(String.valueOf(level3));
				levelThreeService.update(level3);
				CommonUtil.getInstance().saveLog("修改三级分类，三级分类id=" + level3.getLevel3Id(), ip, admin == null?null:admin.getAdminId(), logService);
				break;
			default:
				break;
			}
		}
		
		return "redirect:/goodsclass/goodsclassmagview";
	}
}
