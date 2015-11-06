package com.qx.service;

import com.qx.model.Userinfo;

public interface IUserService {

	/**
	 *  根据用户姓名和密码判断用户是狗存在
	 * @param userinfo 用户对象实例
	 * @param pwd 密码
	 * @return 是否登陆成功（用户是否存在）
	 */
	public boolean loginCheck(Userinfo userinfo, String pwd);
	/**
	 *  根据用户姓名查找用户对象
	 * @param username 用户名
	 * @return 对象
	 */
	public Userinfo findUserByName(String username);
}
