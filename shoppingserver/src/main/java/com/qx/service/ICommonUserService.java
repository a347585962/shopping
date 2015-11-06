package com.qx.service;

import java.util.List;

import com.qx.model.Admininfo;
import com.qx.model.Userinfo;

public interface ICommonUserService<T> {
	/**
	 *  用户登录
	 * @return  用户信息
	 */
	public T findUser(String username,String password);
	/**
	 *  新增用户
	 * @param user 用户对象实例
	 */
	public void add(T user);
	/**
	 *  更新用户信息
	 * @param user 用户对象实例
	 */
	public void update(T user);
	/**
	 *  查询所有用户帐号信息
	 * @return 管理员信息对象集合
	 */
	public List<T> findAll();
	/**
	 *  删除用户帐号信息
	 * @param user 管理员对象实例
	 */
	public void delete(T user);
	/**
	 *  根据用户id，查询用户对象
	 * @param id 用户id
	 * @return 用户对象实例
	 */
	public T selectByPrimaryKey(Integer id);
	/**
	 *  根据用户姓名和密码判断用户是狗存在
	 * @param userinfo 用户对象实例
	 * @param pwd 密码
	 * @return 是否登陆成功（用户是否存在）
	 */
	public boolean loginCheck(T userinfo, String pwd);
	/**
	 *  根据用户姓名查找用户对象
	 * @param username 用户名
	 * @return 对象
	 */
	public T findUserByName(String username);
}
