package com.qx.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.IOrderDao;
import com.qx.model.Goodsinfo;
import com.qx.model.Orderinfo;
import com.qx.model.SubOrderinfo;
import com.qx.model.Userinfo;

@Repository
public class OrderDaoImpl implements IOrderDao {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderDaoImpl.class);

	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;

	@Override
	public List<Orderinfo> findAll() {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete
				.find("from Orderinfo order by orderTime desc");
	}

	@Override
	public Orderinfo findById(Integer orderid) {
		// TODO Auto-generated method stub
		List list = mysqlhibernateTemplete.find("from Orderinfo where orderId="
				+ orderid);
		return (list == null ? null : (Orderinfo) list.get(0));
	}

	@Override
	public int findOrderSize() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Orderinfo";
		Object o = mysqlhibernateTemplete.find(hql).listIterator().next();
		Integer count = Integer.parseInt(o == null ? "0" : o.toString());
		return count.intValue();
	}

	@Override
	public List<Orderinfo> findOrder(final int start, final int size) {
		// TODO Auto-generated method stub
		final String hql = "from Orderinfo order by orderTime desc";
		List list = mysqlhibernateTemplete
				.executeFind(new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createQuery(hql);
						query.setFirstResult(start);
						query.setMaxResults(size);
						List result = query.list();
						// logger.info("list = " + result);
						return result;
					}
				});
		// logger.info(list);
		return list;
	}

	/**
	 * 查询
	 * 
	 * @param searchKey
	 *            查询键值
	 * @param searchName
	 *            查询键名
	 * @return 查询结构
	 */
	public List<Orderinfo> findBySearch(Object searchKey, String searchName) {
		// TODO Auto-generated method stub
		String hql = "from Orderinfo where " + searchName + " like:searchname";
		String sql = "select * from orderinfo,sub_orderinfo,userinfo where orderinfo.OrderID=sub_orderinfo.OrderID AND orderinfo.UserID=userinfo.UserID AND  "
				+ searchName
				+ " like '%"
				+ searchKey
				+ "%'"
				+ " order by orderinfo.OrderTime desc";
		final String final_sql = sql;
		logger.info(sql);
		List list = mysqlhibernateTemplete
				.executeFind(new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createSQLQuery(final_sql)
								.addEntity(Orderinfo.class)
								.addEntity(Userinfo.class)
								.addEntity(SubOrderinfo.class);

						List result = query.list();

						List<Orderinfo> orderinfos = new ArrayList<Orderinfo>();
						Set<SubOrderinfo> subOrderinfos = null;
						int k = 0;
						int index = 0;
						Integer orderid = 0;
						for (int i = 0; i < result.size(); i++) {

							Object[] os = (Object[]) result.get(i);
							Orderinfo orderinfo = (Orderinfo) os[0];
							Userinfo userinfo = (Userinfo) os[1];
							// logger.info(userinfo);
							SubOrderinfo subOrderinfo = (SubOrderinfo) os[2];
							if (orderid != orderinfo.getOrderId()) {
								orderinfos.add(orderinfo);
								orderid = orderinfo.getOrderId();
								if (k != 0) {
									orderinfos.get(index).setSuborder(
											subOrderinfos);
								}

								orderinfos.get(index).setUserinfo(userinfo);
								subOrderinfos = new HashSet<SubOrderinfo>();
								subOrderinfos.add(subOrderinfo);
								index++;
							} else {
								// logger.info(subOrderinfo);
								subOrderinfos.add(subOrderinfo);
							}
							// logger.info("k = " + k + ",size = " +
							// result.size());
							if (k == (result.size() - 1)) {
								orderinfos.get(index - 1).setSuborder(
										subOrderinfos);
							}
							k++;
						}

						return orderinfos;
					}
				});
		logger.info(list);
		// List list = mysqlhibernateTemplete.findByNamedParam(hql,
		// new String[] { "searchname" }, new String[] { "%" + searchKey
		// + "%" });
		return list;
	}

	@Override
	public List<SubOrderinfo> findSubOrders() {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from SubOrderinfo");
	}

	@Override
	public int findSubOrderSize() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from SubOrderinfo";
		Object o = mysqlhibernateTemplete.find(hql).listIterator().next();
		Integer count = Integer.parseInt(o == null ? "0" : o.toString());
		return count.intValue();
	}

	@Override
	public List<SubOrderinfo> findSubOrderByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubOrderinfo findSubOrderById(Integer suborderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Orderinfo orderinfo) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(orderinfo);
	}

	@Override
	public List<Orderinfo> searchByMap(Map<String, Object> parameters,
			final int start, final int size) {
		// TODO Auto-generated method stub
		String sql = "select * from orderinfo,sub_orderinfo,userinfo,orderstatus where orderinfo.OrderID=sub_orderinfo.OrderID AND orderinfo.UserID=userinfo.UserID and orderstatus.OrderID=orderinfo.OrderID ";
		final String final_sql;
		Set<String> set = parameters.keySet();
		sql = setSql(parameters, sql, set) + " order by OrderTime desc";
		final_sql = sql;
		//logger.info(sql);
		@SuppressWarnings("unchecked")
		List<Orderinfo> list = mysqlhibernateTemplete
				.executeFind(new HibernateCallback<Object>() {

					@Override
					public List<Orderinfo> doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createSQLQuery(final_sql)
								.addEntity(Orderinfo.class)
								.addEntity(Userinfo.class)
								.addEntity(SubOrderinfo.class);
//						query.setFirstResult(start);
//						query.setMaxResults(size);
						List result = query.list();
						List<Orderinfo> orderinfos = new ArrayList<Orderinfo>();
						Set<SubOrderinfo> subOrderinfos = null;
						int k = 0;
						int index = 0;
						Integer orderid = 0;
						for (int i = 0; i < result.size(); i++) {

							Object[] os = (Object[]) result.get(i);
							Orderinfo orderinfo = (Orderinfo) os[0];
							Userinfo userinfo = (Userinfo) os[1];
							SubOrderinfo subOrderinfo = (SubOrderinfo) os[2];
							if (orderid != orderinfo.getOrderId()) {
								orderinfos.add(orderinfo);
								orderid = orderinfo.getOrderId();
								if (k != 0) {
									orderinfos.get(index).setSuborder(
											subOrderinfos);
								}

								orderinfos.get(index).setUserinfo(userinfo);
								subOrderinfos = new HashSet<SubOrderinfo>();
								subOrderinfos.add(subOrderinfo);
								index++;
							} else {
								// logger.info(subOrderinfo);
								subOrderinfos.add(subOrderinfo);
							}
							// logger.info("k = " + k + ",size = " +
							// result.size());
							if (k == (result.size() - 1)) {
								orderinfos.get(index - 1).setSuborder(
										subOrderinfos);
							}
							k++;
						}
                        if (orderinfos != null && orderinfos.size() > 0)
                        {
                        	orderinfos = orderinfos.subList(start, size > orderinfos.size() ? orderinfos.size() : (start + size));
                        }
						return orderinfos;
					}
				});
		// List list = mysqlhibernateTemplete.findByNamedParam(hql, keys,
		// values);
		//logger.info(String.valueOf(list));
		return list;
		// return null;
	}

	@Override
	public int sizeofAllSearch(Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		String sql = "select count(DISTINCT orderinfo.OrderID) from orderinfo,sub_orderinfo,userinfo,orderstatus where orderinfo.OrderID=sub_orderinfo.OrderID AND orderinfo.UserID=userinfo.UserID and orderstatus.OrderID=orderinfo.OrderID ";
		final String fianl_sql;
		Set<String> set = parameters.keySet();
		sql = setSql(parameters, sql, set);
		fianl_sql = sql;
		@SuppressWarnings("unchecked")
		List list = mysqlhibernateTemplete
				.executeFind(new HibernateCallback<Object>() {
					@Override
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createSQLQuery(fianl_sql);
						query.setMaxResults(1);
						List result = query.list();

						//logger.info("list = " + result);
						return result;
					}
				});
		Integer count = Integer
				.parseInt((list == null && list.size() == 0) ? "0" : list
						.get(0).toString());
		// logger.info(count);
		return count;
	}

	/**
	 * @param parameters
	 * @param sql
	 * @param set
	 * @return
	 */
	public String setSql(Map<String, Object> parameters, String sql,
			Set<String> set) {
		int i = 0;

		for (Iterator<String> it = set.iterator(); it.hasNext();) {
			String key = it.next();
			Object value = parameters.get(key);

			sql += " and " + key + " like '%" + value + "%'";
			i++;
		}
		return sql;
	}

	@Override
	public List topTenPerson(Date start, Date end, Integer shopId) {
		// TODO Auto-generated method stub
		String hql = "select sum(t1.totalNum),t1.userinfo from " +
				"Orderinfo t1 where t1.shopId=" + shopId + "  group by t1.userinfo" + 
				" order by sum(t1.totalNum) desc limit 0,10";
		logger.info("sql = " + hql);
		List list = mysqlhibernateTemplete.find(hql);
		return list;
	}

	@Override
	public List topTenGoods(Date start, Date end, Integer shopId) {
		// TODO Auto-generated method stub
		final String final_sql = "SELECT sum(t2.GoodsNum),t3.GoodsName" +
				" FROM orderinfo t, userinfo t1, sub_orderinfo t2,goodsinfo t3 WHERE t.UserID=t1.UserID "
                   + " AND t2.OrderID=t.OrderID AND t2.GoodsID=t3.GoodsID and t.shop_id=" + shopId +
                   " GROUP BY t2.GoodsID ORDER BY sum(t2.GoodsNum) desc limit 0,10";
		List list = mysqlhibernateTemplete
				.executeFind(new HibernateCallback<Object>() {
					@Override
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createSQLQuery(final_sql)
								;
						List result = query.list();
						for (int i = 0; i < result.size(); i++) {

							Object[] os = (Object[]) result.get(i);
							Integer sumsales = Integer.parseInt(os[0].toString());
							String goodsName = os[1].toString();
							Goodsinfo goodsinfo = new Goodsinfo();
							goodsinfo.setSumsalesrate(sumsales);
							goodsinfo.setGoodsName(goodsName);
							result.set(i, goodsinfo);
						}
						logger.info("list = " + result);
						return result;
					}
				});
		return list;
	}

	@Override
	public void save(Orderinfo orderinfo) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(orderinfo);
	}

	@Override
	public void saveSubOrder(SubOrderinfo subOrderinfo) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(subOrderinfo);
	}

	@Override
	public List<Orderinfo> findOrder(final int start, final int size, Integer shopId) {
		// TODO Auto-generated method stub
		final String hql = "from Orderinfo where shopId=" + shopId + " order by orderTime desc";
		List list = mysqlhibernateTemplete
				.executeFind(new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createQuery(hql);
						query.setFirstResult(start);
						query.setMaxResults(size);
						List result = query.list();
						// logger.info("list = " + result);
						return result;
					}
				});
		 logger.info(list);
		return list;
	}

	@Override
	public int findShopOrderSizeByShopId(Integer shopId) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Orderinfo where shopId=" + shopId;
		Object o = mysqlhibernateTemplete.find(hql).listIterator().next();
		Integer count = Integer.parseInt(o == null ? "0" : o.toString());
		return count.intValue();
	}

	@Override
	public List<Orderinfo> findBySearch(Object searchKey, String searchName,
			Integer shopId) {
		// TODO Auto-generated method stub
		String hql = "from Orderinfo where " + searchName + " like:searchname";
		String sql = "select * from orderinfo,sub_orderinfo,userinfo where orderinfo.OrderID=sub_orderinfo.OrderID AND orderinfo.UserID=userinfo.UserID AND  "
				+ searchName
				+ " like '%"
				+ searchKey
				+ "%'"
				+" and shop_id=" + shopId
				+ " order by orderinfo.OrderTime desc";
		final String final_sql = sql;
		logger.info(sql);
		List list = mysqlhibernateTemplete
				.executeFind(new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createSQLQuery(final_sql)
								.addEntity(Orderinfo.class)
								.addEntity(Userinfo.class)
								.addEntity(SubOrderinfo.class);

						List result = query.list();

						List<Orderinfo> orderinfos = new ArrayList<Orderinfo>();
						Set<SubOrderinfo> subOrderinfos = null;
						int k = 0;
						int index = 0;
						Integer orderid = 0;
						for (int i = 0; i < result.size(); i++) {

							Object[] os = (Object[]) result.get(i);
							Orderinfo orderinfo = (Orderinfo) os[0];
							Userinfo userinfo = (Userinfo) os[1];
							// logger.info(userinfo);
							SubOrderinfo subOrderinfo = (SubOrderinfo) os[2];
							if (orderid != orderinfo.getOrderId()) {
								orderinfos.add(orderinfo);
								orderid = orderinfo.getOrderId();
								if (k != 0) {
									orderinfos.get(index).setSuborder(
											subOrderinfos);
								}

								orderinfos.get(index).setUserinfo(userinfo);
								subOrderinfos = new HashSet<SubOrderinfo>();
								subOrderinfos.add(subOrderinfo);
								index++;
							} else {
								// logger.info(subOrderinfo);
								subOrderinfos.add(subOrderinfo);
							}
							// logger.info("k = " + k + ",size = " +
							// result.size());
							if (k == (result.size() - 1)) {
								orderinfos.get(index - 1).setSuborder(
										subOrderinfos);
							}
							k++;
						}

						return orderinfos;
					}
				});
		logger.info(list);
		// List list = mysqlhibernateTemplete.findByNamedParam(hql,
		// new String[] { "searchname" }, new String[] { "%" + searchKey
		// + "%" });
		return list;
	}

	@Override
	public int sizeofAllSearch(Map<String, Object> parameters, Integer shopId) {
		// TODO Auto-generated method stub
		String sql = "select count(DISTINCT orderinfo.OrderID) from orderinfo," +
				"sub_orderinfo,userinfo,orderstatus where" +
				" orderinfo.OrderID=sub_orderinfo.OrderID AND " +
				"orderinfo.UserID=userinfo.UserID and " +
				"orderstatus.OrderID=orderinfo.OrderID and orderinfo.shop_id=" + shopId + " ";
		final String fianl_sql;
		Set<String> set = parameters.keySet();
		sql = setSql(parameters, sql, set);
		fianl_sql = sql;
		@SuppressWarnings("unchecked")
		List list = mysqlhibernateTemplete
				.executeFind(new HibernateCallback<Object>() {
					@Override
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createSQLQuery(fianl_sql);
						query.setMaxResults(1);
						List result = query.list();

						//logger.info("list = " + result);
						return result;
					}
				});
		Integer count = Integer
				.parseInt((list == null && list.size() == 0) ? "0" : list
						.get(0).toString());
		// logger.info(count);
		return count;
	}

	@Override
	public List<Orderinfo> searchByMap(Map<String, Object> parameters,
			final int start, final int size, Integer shopId) {
		// TODO Auto-generated method stub
		String sql = "select * from orderinfo,sub_orderinfo,userinfo," +
				"orderstatus where orderinfo.OrderID=sub_orderinfo.OrderID " +
				"AND orderinfo.UserID=userinfo.UserID and " +
				"orderstatus.OrderID=orderinfo.OrderID and orderinfo.shop_id=" + shopId + " ";
		final String final_sql;
		Set<String> set = parameters.keySet();
		sql = setSql(parameters, sql, set) + " order by OrderTime desc";
		final_sql = sql;
		//logger.info(sql);
		@SuppressWarnings("unchecked")
		List<Orderinfo> list = mysqlhibernateTemplete
				.executeFind(new HibernateCallback<Object>() {

					@Override
					public List<Orderinfo> doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createSQLQuery(final_sql)
								.addEntity(Orderinfo.class)
								.addEntity(Userinfo.class)
								.addEntity(SubOrderinfo.class);
//						query.setFirstResult(start);
//						query.setMaxResults(size);
						List result = query.list();
						List<Orderinfo> orderinfos = new ArrayList<Orderinfo>();
						Set<SubOrderinfo> subOrderinfos = null;
						int k = 0;
						int index = 0;
						Integer orderid = 0;
						for (int i = 0; i < result.size(); i++) {

							Object[] os = (Object[]) result.get(i);
							Orderinfo orderinfo = (Orderinfo) os[0];
							Userinfo userinfo = (Userinfo) os[1];
							SubOrderinfo subOrderinfo = (SubOrderinfo) os[2];
							if (orderid != orderinfo.getOrderId()) {
								orderinfos.add(orderinfo);
								orderid = orderinfo.getOrderId();
								if (k != 0) {
									orderinfos.get(index).setSuborder(
											subOrderinfos);
								}

								orderinfos.get(index).setUserinfo(userinfo);
								subOrderinfos = new HashSet<SubOrderinfo>();
								subOrderinfos.add(subOrderinfo);
								index++;
							} else {
								// logger.info(subOrderinfo);
								subOrderinfos.add(subOrderinfo);
							}
							// logger.info("k = " + k + ",size = " +
							// result.size());
							if (k == (result.size() - 1)) {
								orderinfos.get(index - 1).setSuborder(
										subOrderinfos);
							}
							k++;
						}
                        if (orderinfos != null && orderinfos.size() > 0)
                        {
                        	orderinfos = orderinfos.subList(start, size > orderinfos.size() ? orderinfos.size() : (start + size));
                        }
						return orderinfos;
					}
				});
		// List list = mysqlhibernateTemplete.findByNamedParam(hql, keys,
		// values);
		//logger.info(String.valueOf(list));
		return list;
		// return null;
	}

}
