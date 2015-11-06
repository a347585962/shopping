package com.qx.dao;

import java.util.List;

import com.qx.model.Loginfo;

public interface ILogDao {

	/**
	 *  新增操作日志
	 * @param loginfo 日志对象
	 */
	public void add(Loginfo loginfo);
	/**
	 *  查询所有日志信息
	 * @return 日志信息集合
	 */
	public List<Loginfo> findAll();
	/**
	 *  分页查询日志集合
	 * @param start 开始序列
	 * @param size 返回最大的数量
	 * @return 分页查询日志集合
	 */
	public List<Loginfo> findByPage(final int start, final int size);
	/**
	 *  查询所有日志的数量
	 * @return 日志数量
	 */
	public int findLogSize();
	/**
	 *  根据日志id查询日志对象实例
	 * @param id 日志id
	 * @return 日志对象实例
	 */
	public List<Loginfo> selectByPrimaryId(Integer id);
}
