package com.qx.dao;

import java.util.List;

import com.qx.model.Admininfo;
import com.qx.model.Userinfo;

public interface ICommonUserDao<T> {

	/**
	 *  查询所有用户信息
	 * @return 用户信息列表
	 */
	public List<T> findAllUser();
	/**
	 *  查询所有的用户
	 * @param start 开始序列
	 * @param size 查询的用户数量
	 * @return 用户集合
	 */
	public List<T> findUserByPage(final int start, final int size);
	/**
	 *  新增用户
	 * @param user 用户对象实例
	 */
	public void add(T user);
	/**
	 *  删除用户
	 * @param user 用户对象实例
	 */
	public void delete(T user);
	/**
	 *  修改用户信息
	 * @param user 用户对象实例
	 */
	public void update(T user);
	/**
	 *  查询用户表中行数量
	 * @return 用户表行数量
	 */
	public int countofsize();
	/**
	 *  根据用户姓名查找用户对象集合
	 * @param username 用户名
	 * @return 对象集合
	 */
	public List<T> findUserByName(String username);
	/**
	 *  根据用户id，查询用户对象
	 * @param id 用户id
	 * @return 用户对象实例
	 */
	public List<T> selectByPrimaryKey(Integer id);
	
}
