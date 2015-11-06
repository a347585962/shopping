package com.qx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.qx.dao.GoodsManagerDao;
import com.qx.model.Goodsinfo;
import com.qx.model.Orderinfo;

@Repository
public class GoodsManagerDaoImpl implements GoodsManagerDao{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(GoodsManagerDaoImpl.class);

	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	
	@Override
	public void addgoods(Goodsinfo goodsinfo) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(goodsinfo);
	}

	@Override
	public List<Goodsinfo> findAll() {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Goodsinfo order by updateTime desc");
	}

	@Override
	public List<Goodsinfo> findByPage(final Integer start, final Integer size) {
		// TODO Auto-generated method stub
		final String hql = "from Goodsinfo  order by updateTime desc";
        List list = mysqlhibernateTemplete.executeFind(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql);
				query.setFirstResult(start);
				query.setMaxResults(size);
				List result = query.list();
				//logger.info("list = " + result);
				return result;
			}
		});
        //logger.info(list);
		return list;
	}

	@Override
	public int sizeOfAll() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Goodsinfo";
		Object o = mysqlhibernateTemplete.find(hql)
				.listIterator().next();
		Integer count = Integer.parseInt(o == null ?"0":o.toString());
		return count.intValue();
	}

	@Override
	public Goodsinfo findById(Integer goodsid) {
		// TODO Auto-generated method stub
		List list = mysqlhibernateTemplete.find("from Goodsinfo where goodsId="
				+ goodsid);
		return (list == null ? null : (Goodsinfo) list.get(0));
	}

	@Override
	public void update(Goodsinfo goodsinfo) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.update(goodsinfo);
	}

	@Override
	public List<Goodsinfo> findByLevelThreeId(String levelThreeId) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Goodsinfo where goodsClass3=" + levelThreeId + " order by updateTime desc");
	}

	@Override
	public void delete(Goodsinfo goodsinfo) {
		// TODO Auto-generated method stub
		if (goodsinfo != null)
			mysqlhibernateTemplete.delete(goodsinfo);
		else
			logger.error("删除商品对象为null！");
			
	}

	@Override
	public void importAll(List<Goodsinfo> goodsinfos) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.saveOrUpdateAll(goodsinfos);
	}

	@Override
	public List<Goodsinfo> selectByNameLike(String name) {
		// TODO Auto-generated method stub
		String hql = "from Goodsinfo where goodsName"  + " like:searchname";
		logger.info(hql + "===hql" + ",name=" + name);
		List list = mysqlhibernateTemplete.findByNamedParam(hql, new String []{"searchname"}, new String []{"%" + name + "%"});		
		return list;
	}

	@Override
	public List<Goodsinfo> searchByMap(Map<String, Object> parameters,
			final int start, final int size) {
		// TODO Auto-generated method stub
		String hql = "from Goodsinfo where " ;
		String sql = "SELECT * from goodsinfo ";
		final String fianl_sql;
		Set<String> set = parameters.keySet();
		sql = setSql(parameters, sql, set) + " order by UpdateTime desc";
		fianl_sql = sql;
		//logger.info(sql);
		@SuppressWarnings("unchecked")
		List<Goodsinfo> list = mysqlhibernateTemplete.executeFind(new HibernateCallback<Object>() {

			@Override
			public List<Goodsinfo> doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createSQLQuery(fianl_sql).addEntity(Goodsinfo.class);
				query.setFirstResult(start);
				query.setMaxResults(size);
				List result = query.list();
				
				//logger.info("list = " + result);
				return result;
			}
		});
		//List list = mysqlhibernateTemplete.findByNamedParam(hql, keys, values);		
		//logger.info(String.valueOf(list));
		return list;
		//return null;
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
		
        for (Iterator<String> it = set.iterator();it.hasNext();) {
             String key = it.next();
             Object value = parameters.get(key);
             if (i == 0)
             {
            	 if (key != null && key.toString().contains("Class"))
            	 {
            		 sql += " WHERE " + key + " = " + value ;
            	 }
            	 else {
            		 sql += " WHERE " + key + " like '%" + value + "%'";
            	 }
            	 
             }
             else {
            	 if (key != null && key.toString().contains("Class"))
            	 {
            		 sql += " and " + key + " = " + value ;
            	 }
            	 else {
            		 sql += " and " + key + " like '%" + value + "%'";
            	 }
            	
             }
             i++;
        }
		return sql;
	}

	@Override
	public int sizeofAllSearch(Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) from goodsinfo ";
		final String fianl_sql;
		Set<String> set = parameters.keySet();
		sql = setSql(parameters, sql, set);
        fianl_sql = sql;
        @SuppressWarnings("unchecked")
		List list = mysqlhibernateTemplete.executeFind(new HibernateCallback<Object>() {

			@Override
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createSQLQuery(fianl_sql);
				query.setMaxResults(1);
				List result = query.list();
				
				//logger.info("list = " + result);
				return result;
			}
		});
        Integer count = Integer.parseInt((list == null && list.size() == 0)?"0":list.get(0).toString());
       // logger.info(count);
		return count;
	}
}
