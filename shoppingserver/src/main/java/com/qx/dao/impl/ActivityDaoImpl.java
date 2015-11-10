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
import com.qx.model.Activity;

@Repository("activityDao")
public class ActivityDaoImpl implements ICommonDao<Activity> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ActivityDaoImpl.class);

	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;

	@Override
	public void add(Activity object) {
		// TODO Auto-generated method stub

		mysqlhibernateTemplete.save(object);

	}

	@Override
	public void update(Activity object) {
		// TODO Auto-generated method stub

		mysqlhibernateTemplete.update(object);

	}

	@Override
	public void delete(Activity object) {
		// TODO Auto-generated method stub

		mysqlhibernateTemplete.delete(object);
	}

	@Override
	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Activity");
	}

	@Override
	public int sizeoflist() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Activity";
		Object o = mysqlhibernateTemplete.find(hql).listIterator().next();
		Integer count = Integer.parseInt(o == null ? "0" : o.toString());
		return count.intValue();
	}

	@Override
	public List<Activity> findByPage(final int start, final int size) {
		// TODO Auto-generated method stub
		final String hql = "from Activity";
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

	@Override
	public Activity findById(Integer id) {
		// TODO Auto-generated method stub
		List list = mysqlhibernateTemplete.find("from Activity where activityId=" + id + " and activityStatus=1");
		return (list == null || list.size() == 0) ? null : (Activity) list
				.get(0);
	}

	public Activity findById(Integer id, Integer shopId) {
		// TODO Auto-generated method stub
		List list = mysqlhibernateTemplete.find("from Activity where activityId=" + id + " and shopId=" + 
		shopId + "  and activityStatus=1");
		return (list == null || list.size() == 0) ? null : (Activity) list
				.get(0);
	}
	
	public List<Activity> findByType(Integer type)
	{
		List list = mysqlhibernateTemplete.find("from Activity where activityType=" + type);
		return list;
	}
	
	public List<Activity> findByPage(final int start, final int size, Integer shopId) {
		// TODO Auto-generated method stub
		final String hql = "from Activity where shopId=" + shopId + " and activityStatus=1";
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
}
