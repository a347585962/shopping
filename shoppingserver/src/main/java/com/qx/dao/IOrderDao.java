package com.qx.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.qx.model.Goodsinfo;
import com.qx.model.Orderinfo;
import com.qx.model.SubOrderinfo;
import com.qx.model.Userinfo;

public interface IOrderDao {

	/**
	 *  查询存在的所有订单数据
	 * @return 订单集合
	 */
	public List<Orderinfo> findAll();
	/**
	 *  通过订单id查询订单对象实例
	 * @param orderid 订单id
	 * @return 订单对象实例
	 */
	public Orderinfo findById(Integer orderid);
	/**
	 *  查看订单的总数
	 * @return 订单总数量
	 */
	public int findOrderSize();
	/**
	 *  查看订单的总数
	 *  @param shopId 商家id
	 * @return 订单总数量
	 */
	public int findShopOrderSizeByShopId(Integer shopId);
	/**
	 *  从指定的位置开始查询size跳订单数据，分页展示
	 * @param start 开始的订单序号
	 * @param size 返回的订单最大行数
	 * @return 订单集合
	 */
	public List<Orderinfo> findOrder(final int start, final int size);
	/**
	 *  从指定的位置开始查询size跳订单数据，分页展示
	 * @param start 开始的订单序号
	 * @param size 返回的订单最大行数
	 * @param shopId 商家id
	 * @return 订单集合
	 */
	public List<Orderinfo> findOrder(final int start, final int size, Integer shopId);
	/**
	 *  查询
	 * @param searchKey 查询键值
	 * @param searchName 查询键名
	 * @return 查询结构
	 */
	public List<Orderinfo> findBySearch(Object searchKey, String searchName);
	/**
	 *  查询
	 * @param searchKey 查询键值
	 * @param searchName 查询键名
	 * @param shopId 商家id
	 * @return 查询结构
	 */
	public List<Orderinfo> findBySearch(Object searchKey, String searchName, Integer shopId);
	/**
	 *  查询所有子订单集合
	 * @return 子订单集合
	 */
	public List<SubOrderinfo> findSubOrders();
	/**
	 *  查询所有子订单的数量
	 * @return 子订单数量
	 */
	public int findSubOrderSize();
	/**
	 *  从指定的位置开始查询size条子订单数据，分页展示
	 * @param start 开始的子订单序号
	 * @param size 返回的子订单最大行数
	 * @return 子订单集合
	 */
	public List<SubOrderinfo> findSubOrderByPage(final int start, final int size);
	/**
	 *  通过子订单id查询子订单对象实例
	 * @param suborderid 子订单id
	 * @return 子订单对象实例
	 */
	public SubOrderinfo findSubOrderById(Integer suborderid);
	/**
	 *  更新订单信息
	 * @param orderinfo 订单对象id
	 */
	public void update(Orderinfo orderinfo);
	/**
	 *  根据传入的map进行like动态查找，并分页返回结果
	 * @param parameters 参数map
	 * @return 订单集合
	 */
	public List<Orderinfo> searchByMap(Map<String, Object> parameters, final int start, final int size);
	/**
	 *  根据传入的map进行like动态查找，并分页返回结果
	 * @param parameters 参数map
	 * @param shopId 商家id
	 * @return 订单集合
	 */
	public List<Orderinfo> searchByMap(Map<String, Object> parameters, final int start, final int size, Integer shopId);
	/**
	 *  根据传入的map查找返回的结果集合大小
	 * @param parameters 参数
	 * @return 集合大小
	 */
	public int sizeofAllSearch(Map<String, Object> parameters);
	/**
	 *  根据传入的map查找返回的结果集合大小
	 * @param parameters 参数
	 * @param shopId 商家id
	 * @return 集合大小
	 */
	public int sizeofAllSearch(Map<String, Object> parameters, Integer shopId);
	/**
	 *  在指定时间段内查询用户及购买量排行榜
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 用户排行榜
	 */
	public List topTenPerson(Date start, Date end, Integer shopId);
	/**
	 *  在指定时间段内查询商品及销售量排行榜
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 商品排行榜
	 */
	public List topTenGoods(Date start, Date end, Integer shopId);
	/**
	 *  保存订单信息
	 * @param orderinfo 订单对象实例
	 */
	public void save(Orderinfo orderinfo);
	/**
	 *  保存子订单信息
	 * @param orderinfo 子订单对象实例
	 */
	public void saveSubOrder(SubOrderinfo subOrderinfo);
	
}
