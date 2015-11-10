package com.qx.service;

import java.util.List;

import com.qx.model.Level1;

public interface ILevelOneService {


	/**
	 *  查询数据库中所有的商品一级分类
	 * @return  一级分类集合
	 */
	public List<Level1> findAllLevelOne(Integer shopId);
	/**
	 *  查询数据库中所有的商品一级分类并转为json数据
	 *  @param shopId 商家id
	 * @return  一级分类集合
	 */
	public String findAllLevelOne2Json(Integer shopId);
	/**
	 *  添加一级分类
	 * @param level1 一级分类对象
	 */
	public void add(Level1 level1);
	/**
	 *  根据levelid查询一级分类
	 * @param level1id 一级分类id
	 * @return 一级分类对象
	 */
	public Level1 findById(Integer level1id);
	/**
	 *  删除指定一级分类，及其子类
	 * @param level1 一级分类对象
	 * @return 删除的一级分类对象
	 */
	public Level1 delete(Level1 level1);
	/**
	 *  更新指定的一级分类
	 * @param level1 一级分类对象实例
	 * @return 修改的一级分类实例对象
	 */
	public Level1 update(Level1 level1);
}
