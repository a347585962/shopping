package com.qx.dao;

import java.util.List;

import com.qx.model.Admininfo;
import com.qx.model.Userinfo;

public interface LoginDao {
	/**
	 * 管理员登录  
	 * @return  一级分类集合
	 */
	public List<Admininfo> findAdmininfo(String username,String password);
	/**
	 *  新增管理员
	 * @param admininfo 用户对象实例
	 */
	public void addAdmin(Admininfo admininfo);
	/**
	 *  更新管理员信息
	 * @param admininfo 管理员对象实例
	 */
	public void update(Admininfo admininfo);
	/**
	 *  查询所有管理员帐号信息
	 * @return 管理员信息对象集合
	 */
	public List<Admininfo> findAll();
	/**
	 *  删除管理员帐号信息
	 * @param admininfo 管理员对象实例
	 */
	public void delete(Admininfo admininfo);
	/**
	 *  根据管理员id，查询管理员对象
	 * @param id 管理员id
	 * @return 管理员对象实例
	 */
	public List<Admininfo> selectByPrimaryKey(Integer id);
	/**
	 *  根据用户姓名查找用户对象集合
	 * @param username 用户名
	 * @return 对象集合
	 */
	public List<Userinfo> findUserByName(String username);
}
