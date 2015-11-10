package com.qx.service;

import java.util.Date;
import java.util.List;

import com.qx.model.Goodsinfo;
import com.qx.model.Orderinfo;
import com.qx.model.SubOrderinfo;
import com.qx.model.Userinfo;

public interface IOrderService {

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
	public List<Orderinfo> findOrder(int pagenow, int size);
	/**
	 *  从指定的位置开始查询size跳订单数据，分页展示
	 * @param start 开始的订单序号
	 * @param size 返回的订单最大行数
	 * @param shopId 商家id
	 * @return 订单集合
	 */
	public List<Orderinfo> findOrder(int pagenow, int size, Integer shopId);
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
	 *   根据传入的值进行like动态查找，并分页返回结果
	 * @param orderid 订单id
	 * @param username 用户名
	 * @param ordersendstatus 订单送货状态
	 * @param orderpaystatus 订单支付状态
	 * @param pagenow 当前页
	 * @param pagesize 页面数量
	 * @return 订单集合
	 */
	public List<Orderinfo> searchByMap(String orderid, String username, String ordersendstatus , String orderpaystatus, final int pagenow, final int pagesize);
	/**
	 *   根据传入的值进行like动态查找，并分页返回结果
	 * @param orderid 订单id
	 * @param username 用户名
	 * @param ordersendstatus 订单送货状态
	 * @param orderpaystatus 订单支付状态
	 * @param pagenow 当前页
	 * @param pagesize 页面数量
	 * @param shopId 商家id
	 * @return 订单集合
	 */
	public List<Orderinfo> searchByMap(String orderid, String username, String ordersendstatus , String orderpaystatus, final int pagenow, final int pagesize, Integer shopId);
	
	/**
	 *   根据传入的值进行like动态查找，并分页返回结果大小
	 * @param orderid 订单id
	 * @param username 用户名
	 * @param ordersendstatus 订单送货状态
	 * @param orderpaystatus 订单支付状态
	 * @param pagenow 当前页
	 * @param pagesize 页面数量
	 * @return 订单集合大小
	 */
	public int sizeofAllSearch(String orderid, String username, String ordersendstatus , String orderpaystatus);
	/**
	 *   根据传入的值进行like动态查找，并分页返回结果大小
	 * @param orderid 订单id
	 * @param username 用户名
	 * @param ordersendstatus 订单送货状态
	 * @param orderpaystatus 订单支付状态
	 * @param pagenow 当前页
	 * @param pagesize 页面数量
	 * @param shopId 商家id
	 * @return 订单集合大小
	 */
	public int sizeofAllSearch(String orderid, String username, String ordersendstatus
			, String orderpaystatus, Integer shopId);
	/**
	 *  在指定时间段内查询用户及购买量排行榜
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 用户排行榜
	 */
	public List<Userinfo> topTenPerson(Date start, Date end, Integer shopId);
	/**
	 *  在指定时间段内查询商品及销售量排行榜
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return 商品排行榜
	 */
	public List<Goodsinfo> topTenGoods(Date start, Date end, Integer shopId);
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
	/**
	 *  保存子订单集合信息
	 * @param orderinfos 子订单对象实例集合
	 */
	public void saveSubOrders(List<SubOrderinfo> subOrderinfos);
}
