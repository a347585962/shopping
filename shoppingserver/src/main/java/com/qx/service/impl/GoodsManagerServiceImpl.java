package com.qx.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qx.dao.GoodsManagerDao;
import com.qx.dao.ILevelOneDao;
import com.qx.dao.ILevelTwoDao;
import com.qx.model.Goodsinfo;
import com.qx.model.Level1;
import com.qx.model.Level2;
import com.qx.model.Level3;
import com.qx.service.GoodsManagerService;
import com.qx.service.ILevelOneService;
import com.qx.service.ILevelThreeService;
import com.qx.service.ILevelTwoService;
@Service
public class GoodsManagerServiceImpl implements GoodsManagerService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GoodsManagerServiceImpl.class);
	@Autowired
	private GoodsManagerDao goodsmanagerDao;
	@Autowired
	ILevelOneService levelOneService;
	@Autowired
	ILevelTwoService levelTwoService;
	@Autowired
	ILevelThreeService levelThreeService;
	@Override
	public void addgoods(Goodsinfo goodsinfo) {
		// TODO Auto-generated method stub
		if (goodsinfo != null)
		{
			goodsinfo.setStatus(1);
			goodsmanagerDao.addgoods(goodsinfo);
		}
		else {
			logger.error("添加的商品对象为null!");
		}
	}
	@Override
	public List<Goodsinfo> findAll() {
		// TODO Auto-generated method stub
		return goodsmanagerDao.findAll();
	}
	@Override
	public List<Goodsinfo> findByPage(final Integer pagenow, final Integer pagesize) {
		// TODO Auto-generated method stub
		List<Goodsinfo> goodsinfos = (pagenow == null || pagesize == null || pagenow == 0 || pagesize == 0)?null:goodsmanagerDao.findByPage((pagenow - 1) * pagesize, pagesize);
		if (goodsinfos != null)
		{
			for (int i = 0 ; i < goodsinfos.size(); i++) {
				Goodsinfo goodsinfo = (Goodsinfo) goodsinfos.get(i);
				String classone = goodsinfo.getGoodsClass1();
				String classtwo = goodsinfo.getGoodsClass2();
				String classthree = goodsinfo.getGoodsClass3();
				 
				Level1 level1 = levelOneService.findById(classone == null?null:Integer.parseInt(classone));
				
				Level2 level2 = levelTwoService.findById(classone == null?null:Integer.parseInt(classtwo));
				
				Level3 level3 = levelThreeService.findById(classone == null?null:Integer.parseInt(classthree));
				goodsinfo.setGoodsClass1(level1 == null?null:level1.getLevel1Name());
				goodsinfo.setGoodsClass2(level2 == null?null:level2.getLevel2Name());
				goodsinfo.setGoodsClass3(level3 == null?null:level3.getLevel3Name());
				goodsinfos.set(i, goodsinfo);
			}
		}
		return goodsinfos;
	}
	@Override
	public int sizeOfAll() {
		// TODO Auto-generated method stub
		return goodsmanagerDao.sizeOfAll();
	}
	@Override
	public Goodsinfo findById(Integer goodsid) {
		// TODO Auto-generated method stub
		return (goodsid == null || goodsid == 0)?null:goodsmanagerDao.findById(goodsid);
	}
	@Override
	public void update(Goodsinfo goodsinfo) {
		// TODO Auto-generated method stub
		if (goodsinfo != null)
			goodsmanagerDao.update(goodsinfo);
	}
	@Override
	public List<Goodsinfo> findByLevelThreeId(Integer levelThreeId) {
		// TODO Auto-generated method stub
		if (levelThreeId != null)
		{
			List list = goodsmanagerDao.findByLevelThreeId(levelThreeId.toString());	
			return (list == null || list.size() == 0)?null:list;
		}
		logger.error("没根据第三级分类查询到商品结果集合！");
		return null;
	}
	@Override
	public void delete(Goodsinfo goodsinfo) {
		// TODO Auto-generated method stub
		goodsmanagerDao.delete(goodsinfo);
	}
	@Override
	public void importAll(List<Goodsinfo> goodsinfos) {
		// TODO Auto-generated method stub
		if (goodsinfos != null)
			goodsmanagerDao.importAll(goodsinfos);
		else
			logger.error("批量导入错误，商品集合为null!");
	}
	@Override
	public List<Goodsinfo> list2objectlist(ArrayList<ArrayList<String>> list) throws Exception {
		// TODO Auto-generated method stub
		List<Goodsinfo> goodsinfos = null;
        goodsinfos = new LinkedList<Goodsinfo>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        for (int i = 1; i < list.size(); i++) {
        	Goodsinfo goodsinfo = new Goodsinfo();
            ArrayList<String> aList = list.get(i);  
            for (int j = 0; j < aList.size(); j++) {
            	String value = aList.get(j);
				switch (j) {
				case 0:
					goodsinfo.setBarCode(value); 
					break;
				case 1:
					goodsinfo.setGoodsName(value);
					break;
				case 2:
					goodsinfo.setGoodsPrice1((value == null || value.isEmpty())?null:BigDecimal.valueOf(Double.parseDouble(value)));
					break;
				case 3:
					goodsinfo.setGoodsPrice2((value == null || value.isEmpty())?null:BigDecimal.valueOf(Double.parseDouble(value)));
					break;
				case 4:
					goodsinfo.setGoodsPrice3((value == null || value.isEmpty())?null:BigDecimal.valueOf(Double.parseDouble(value)));
					break;
				case 5:
					goodsinfo.setGoodsPriceIn((value == null || value.isEmpty())?null:BigDecimal.valueOf(Double.parseDouble(value)));
					break;
				case 6:
					goodsinfo.setGoodsClass1(value);
					break;
				case 7:
					goodsinfo.setGoodsClass2(value);
					break;
				case 8:
					goodsinfo.setGoodsClass3(value);
					break;
				case 9:
					goodsinfo.setGoodsType(value);
					break;
				case 10:
					goodsinfo.setGoodsUntis(value);
					break;
				case 11:
					goodsinfo.setProductAddress(value);
					break;
				case 12:
					goodsinfo.setUpdateTime((value == null || value.isEmpty())?null:df.parse(value));
					break;
				case 13:
					goodsinfo.setPhotoUrl(value);
					break;
				case 14:
					goodsinfo.setGoodsStock((value == null || value.isEmpty())?null:Integer.parseInt(value));
					break;
				case 15:
					goodsinfo.setGoodsPrice4((value == null || value.isEmpty())?null:BigDecimal.valueOf(Double.parseDouble(value)));
					break;
				case 16:
					goodsinfo.setActivityId((value == null || value.isEmpty())?null:Integer.parseInt(value));
					break;
				case 17:
					goodsinfo.setStatus((value == null || value.isEmpty())?null:Integer.parseInt(value));
					break;
				default:
					break;
				}
			}
            //logger.info(String.valueOf(goodsinfo));
            goodsinfos.add(goodsinfo);
            //System.out.println();
        }
        return goodsinfos;
	}
	@Override
	public List<Goodsinfo> selectByNameLike(String name) {
		// TODO Auto-generated method stub
		if (name != null)
			return goodsmanagerDao.selectByNameLike(name);
		logger.error("查询商品的name为null!");
		return null;
	}
	@Override
	public List<Goodsinfo> searchByMap(String goodsid, String isup, String levelone , String leveltwo
			, String levelthree, String barcode, String goodsname, final int pagenow, final int pagesize) {
		// TODO Auto-generated method stub
		Map<String, Object> parameters = setSearchParameters(goodsid, isup, levelone, barcode, goodsname, leveltwo, levelthree);
		
		
		return goodsmanagerDao.searchByMap(parameters, (pagenow - 1)*pagesize, pagesize);
	}
	@Override
	public int sizeofAllSearch(String goodsid, String isup, String levelone,
			String leveltwo, String levelthree , String barcode, String goodsname) {
		// TODO Auto-generated method stub
		Map<String, Object> parameters = setSearchParameters(goodsid, isup, levelone, barcode, goodsname, leveltwo, levelthree);
		Set<String> set = parameters.keySet();
		for (Iterator<String> it = set.iterator();it.hasNext();) {
            String key = it.next();
           
           logger.info(key + ":" + parameters.get(key));
           
        }
		return goodsmanagerDao.sizeofAllSearch(parameters);
	}
	
	public Map<String, Object> setSearchParameters(String goodsid, String isup,
			String levelone, String barcode, String goodsname, String leveltwo, String levelthree)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (goodsid != null && !goodsid.isEmpty())
		{
			parameters.put("GoodsID", Integer.parseInt(goodsid));
		}
		if (barcode != null && !barcode.isEmpty())
		{
			parameters.put("barcode", barcode);
		}
		if (goodsname != null && !goodsname.isEmpty())
		{
			parameters.put("GoodsName", goodsname);
		}
		if (isup != null && !isup.isEmpty())
		{
			parameters.put("status", Integer.parseInt(isup));
		}
		if (levelthree != null && !levelthree.isEmpty() && !levelthree.equals("0"))
		{
			parameters.put("GoodsClass_3", levelthree);
		}
		else if ((levelthree == null || levelthree.isEmpty() || levelthree.equals("0")) && leveltwo != null && !leveltwo.isEmpty() && !leveltwo.equals("0"))
		{
			parameters.put("GoodsClass_2", leveltwo);
		}
		else if ((leveltwo == null || leveltwo.isEmpty() || leveltwo.equals("0")) && levelone != null && !levelone.isEmpty() && !levelone.equals("0"))
		{
			parameters.put("GoodsClass_1", levelone);
		}
		return parameters;
	}
}


