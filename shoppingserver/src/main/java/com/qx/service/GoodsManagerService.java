package com.qx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qx.model.Goodsinfo;
import com.qx.model.Shopgoods;


public interface GoodsManagerService {
	/**
	 *  添加商品
	 * @param 商品信息对象
	 */
	public void addgoods(Goodsinfo goodsinfo);
	/**
	 *  查询所有的商品数据集合
	 * @return 商品信息集合
	 */
	public List<Goodsinfo> findAll();
	/**
	 *  根据当前页和每页数量，查询商品信息集合
	 * @param pagenow 当前页数
	 * @param pagesize 每页数量
	 * @return 商品信息集合
	 */
	public List<Goodsinfo> findByPage(final Integer pagenow, final Integer pagesize);
	/**
	 *  根据当前页和每页数量，查询商品信息集合
	 * @param pagenow 当前页数
	 * @param pagesize 每页数量
	 * @param shopId 商家id
	 * @return 商品信息集合
	 */
	public List<Goodsinfo> findByPage(final Integer pagenow, final Integer pagesize, Integer shopId);
	/**
	 *  查询当前商品总数目
	 * @return 商品总数目
 	 */
	public int sizeOfAll();
	/**
	 *  查询当前商品总数目
	 *  @param shopId 商家id
	 * @return 商品总数目
 	 */
	public int sizeOfAll(Integer shopId);
	/**
	 *  根据商品id查询商品信息
	 * @param goodsid 商品id
	 * @return
	 */
	public Goodsinfo findById(Integer goodsid);
	/**
	 *  更新商品信息
	 * @param goodsinfo 商品信息对象实例
	 */
	public void update(Goodsinfo goodsinfo);
	/**
	 *  根据三级分类id查询商品集合
	 * @param levelThreeId 三级分类id
	 * @return 分类集合
	 */
	public List<Goodsinfo> findByLevelThreeId(Integer levelThreeId);
	/**
	 *  删除商品对象
	 * @param goodsinfo 商品
	 */
	public void delete(Goodsinfo goodsinfo);
	/**
	 *  批量导入商品
	 * @param goodsinfos 商品集合
	 */
	public void importAll(List<Goodsinfo> goodsinfos);
	/**
	 *  将普通list转为goodsinfo对象集合
	 * @param list 普通list
	 * @return
	 */
	public List<Goodsinfo> list2objectlist(ArrayList<ArrayList<String>> list) throws Exception;
	/**
	 *  根据商品名称模糊查询
	 * @param name
	 * @return
	 */
	public List<Goodsinfo> selectByNameLike(String name);
	
	/**
	 * 根据传入的值进行like动态查找，并分页返回结果
	 * @param goodsid 商品id
	 * @param isup 是否上线
	 * @param levelone 一级分类
	 * @param leveltwo 二级分类
	 * @param levelthree 三级分类
	 * @param barcode 编号
	 * @param goodsname 名称
	 * @param pagenow 当前页数
	 * @param pagesize 最大页面返回大小
	 * @return 分页显示的商品集合
	 */
	public List<Shopgoods> searchByMap(String goodsid, String isup, String levelone , String leveltwo
			, String levelthree, String barcode, String goodsname, final int pagenow, final int pagesize);
	/**
	 * 根据传入的值进行like动态查找，并分页返回结果
	 * @param goodsid 商品id
	 * @param isup 是否上线
	 * @param levelone 一级分类
	 * @param leveltwo 二级分类
	 * @param levelthree 三级分类
	 * @param barcode 编号
	 * @param goodsname 名称
	 * @param pagenow 当前页数
	 * @param pagesize 最大页面返回大小
	 * @param shopId 商家id
	 * @return 分页显示的商品集合
	 */
	public List<Shopgoods> searchByMap(String goodsid, String isup, String levelone , String leveltwo
			, String levelthree, String barcode, String goodsname, final int pagenow, final int pagesize, Integer shopId);
	/**
	 *  根据传入的map查找返回的结果集合大小
	 * @param goodsid 商品id
	 * @param isup 是否上线
	 * @param levelone 一级分类
	 * @param leveltwo 二级分类
	 * @param levelthree 三级分类
	 * @param barcode 编号
	 * @param goodsname 名称
	 * @return 集合大小
	 */
	public int sizeofAllSearch(String goodsid, String isup, String levelone,
			String leveltwo, String levelthree , String barcode, String goodsname);
	/**
	 *  根据传入的map查找返回的结果集合大小
	 * @param goodsid 商品id
	 * @param isup 是否上线
	 * @param levelone 一级分类
	 * @param leveltwo 二级分类
	 * @param levelthree 三级分类
	 * @param barcode 编号
	 * @param goodsname 名称
	 * @param shopId 商家id
	 * @return 集合大小
	 */
	public int sizeofAllSearch(String goodsid, String isup, String levelone,
			String leveltwo, String levelthree , String barcode, String goodsname, Integer shopId);
}
