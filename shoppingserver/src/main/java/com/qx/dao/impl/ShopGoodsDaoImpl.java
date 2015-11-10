package com.qx.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ICommonDao;
import com.qx.model.Shopgoods;
@Repository("shopGoodsDao")
public class ShopGoodsDaoImpl implements ICommonDao<Shopgoods> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ShopGoodsDaoImpl.class);

	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	
	@Override
	public void add(Shopgoods object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(object);
	}

	@Override
	public void update(Shopgoods object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(object);
	}

	@Override
	public void delete(Shopgoods object) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.delete(object);
	}

	@Override
	public List<Shopgoods> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Shopgoods";
		Object o = mysqlhibernateTemplete.find(hql)
				.listIterator().next();
		Integer count = Integer.parseInt(o == null ?"0":o.toString());
		return count.intValue();
	}

	@Override
	public List<Shopgoods> findByPage(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shopgoods findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 分页查询商家对应商品信息
	 * @param start 开始
	 * @param size 大小
	 * @param shopId 商家id 
	 * @return 商品信息集合
	 */
	public List<Shopgoods> findByPage(final int start, final int size, Integer shopId) {
		// TODO Auto-generated method stub
		//final String hql = "from Shopgoods t1,Goodsinfo t2,Propertyvalue t3 where "
		//     + "t1.goodsinfo.goodsId=t2.goodsId " +
		//		" and t1.shopId="+ shopId +"  order by date desc";
		final String hql = "from Shopgoods t1 where " +
				 "t1.shopId="+ shopId +"  order by date desc";
        List list = mysqlhibernateTemplete.executeFind(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql);
				query.setFirstResult(start);
				query.setMaxResults(size);
				List result = query.list();
//				for (int i = 0; i < result.size(); i++) {
//
//					Object[] os = (Object[]) result.get(i);
//					logger.info("os.size = " + os.length);
//				}
				//logger.info("list = " + result);
				return result;
			}
		});
        logger.info(list);
		return list;
	}
	public List<Shopgoods> findById(Integer id, Integer shopId) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Shopgoods where shopgoodsId=" + id + " and shopId=" + shopId + " and shopgoodsStatus=1");
	}
	public List<Shopgoods> findEveryById(Integer id, Integer shopId) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Shopgoods where shopgoodsId=" + id + " and shopId=" + shopId );
	}
}
