package com.qx.dao;

import java.util.List;
import java.util.Map;

import com.qx.model.Goodsinfo;

public interface GoodsManagerDao {
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
	public List<Goodsinfo> findByPage(final Integer start, final Integer size);
	/**
	 *  查询当前商品总数目
	 * @return 商品总数目
 	 */
	public int sizeOfAll();
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
	public List<Goodsinfo> findByLevelThreeId(String levelThreeId);
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
	 *  根据商品名称模糊查询
	 * @param name
	 * @return
	 */
	public List<Goodsinfo> selectByNameLike(String name);
	/**
	 *  根据传入的map进行like动态查找，并分页返回结果
	 * @param parameters 参数map
	 * @return 商品集合
	 */
	public List<Goodsinfo> searchByMap(Map<String, Object> parameters, final int start, final int size);
	/**
	 *  根据传入的map查找返回的结果集合大小
	 * @param parameters 参数
	 * @return 集合大小
	 */
	public int sizeofAllSearch(Map<String, Object> parameters);
}
