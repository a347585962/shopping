package com.qx.dao;

import java.util.List;

import com.qx.model.Level2;

public interface ILevelTwoDao {

	/**
	 *  添加二级分类
	 * @param level2 二级分类对象
	 */
	public Level2 add(Level2 level2);
	/**
	 *  根据level2id查询二级分类
	 * @param level2id 二级分类id
	 * @return 二级分类对象
	 */
	public Level2 findById(Integer level2id);
	/**
	 *  删除二级分类
	 * @param level2 二级对象实例 
	 */
	public void delete(Level2 level2);
	/**
	 *  更新二级分类
	 * @param level2 二级分类对象实例
	 */
	public Level2 update(Level2 level2);
	/**
	 *  根据一级分类id查询二级分类
	 * @param levelOneId 一级分类id
	 * @return 二级分类集合
	 */
	public List<Level2> findByLevelOneId(Integer levelOneId);
}
