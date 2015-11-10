package com.qx.service.impl;

import org.apache.log4j.Logger;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qx.dao.impl.ShopGoodsDaoImpl;
import com.qx.model.Shopgoods;
import com.qx.service.ICommonService;
@Service("shopGoodsService")
public class ShopGoodsServiceImpl implements ICommonService<Shopgoods> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ShopGoodsServiceImpl.class);

	@Resource(name="shopGoodsDao")
	private ShopGoodsDaoImpl shopGoodsDao;
	
	@Override
	public void add(Shopgoods object) {
		// TODO Auto-generated method stub
		if (object != null)
			shopGoodsDao.add(object);
		else
			logger.error("插入的商家商品对象失败，对象为null!");
	}

	@Override
	public void update(Shopgoods object) {
		// TODO Auto-generated method stub
		if (object != null)
			shopGoodsDao.update(object);
		else
			logger.error("更新的商家商品对象失败，对象为null!");
	}

	@Override
	public void delete(Shopgoods object) {
		// TODO Auto-generated method stub
		if (object != null)
			shopGoodsDao.delete(object);
		else
			logger.error("删除的商家商品对象失败，对象为null!");
	}

	@Override
	public List<Shopgoods> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		return shopGoodsDao.sizeoflist();
	}

	@Override
	public List<Shopgoods> findByPage(int pagenow, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shopgoods findById(Integer id) {
		// TODO Auto-generated method stub
		return shopGoodsDao.findById(id);
	}
	/**
	 * 分页查询商家对应商品信息
	 * @param start 开始
	 * @param size 大小
	 * @param shopId 商家id 
	 * @return 商品信息集合
	 */
	public List<Shopgoods> findByPage(final int pagenow, final int size, Integer shopId) {
		int start = (pagenow - 1) * size;
		List<Shopgoods> shopgoods = shopGoodsDao.findByPage(start, size, shopId);
		return shopgoods;
	}
	public Shopgoods findById(Integer id, Integer shopId) {
		// TODO Auto-generated method stub
		List list = shopGoodsDao.findById(id, shopId);
		return (list != null && list.size() > 0)?(Shopgoods)list.get(0) : null;
	}
	public Shopgoods findEveryById(Integer id, Integer shopId) {
		// TODO Auto-generated method stub
		List list = shopGoodsDao.findEveryById(id, shopId);
		return (list != null && list.size() > 0)?(Shopgoods)list.get(0) : null;
	}
}
