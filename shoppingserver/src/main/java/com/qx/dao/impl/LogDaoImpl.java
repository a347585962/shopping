package com.qx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qx.dao.ILogDao;
import com.qx.model.Loginfo;
@Repository
public class LogDaoImpl implements ILogDao {


	@Resource(name = "mysqlhibernateTemplete")
	private HibernateTemplate mysqlhibernateTemplete;
	@Override
	public void add(Loginfo loginfo) {
		// TODO Auto-generated method stub
		mysqlhibernateTemplete.save(loginfo);
	}

	@Override
	public List<Loginfo> findAll() {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Loginfo order by logTime desc");
	}

	@Override
	public List<Loginfo> findByPage(final int start, final int size) {
		// TODO Auto-generated method stub
		final String hql = "from Loginfo order by logTime desc";
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
	public int findLogSize() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Loginfo";
		Object o = mysqlhibernateTemplete.find(hql)
				.listIterator().next();
		Integer count = Integer.parseInt(o == null ?"0":o.toString());
		return count.intValue();
	}

	@Override
	public List<Loginfo> selectByPrimaryId(Integer id) {
		// TODO Auto-generated method stub
		return mysqlhibernateTemplete.find("from Loginfo where logId=" + id);
	}

}
