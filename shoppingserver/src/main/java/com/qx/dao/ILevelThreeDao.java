package com.qx.dao;


import java.io.Serializable;
import java.util.List;

import com.qx.model.Level2;
import com.qx.model.Level3;

public interface ILevelThreeDao {

	/**
	 *  添加三级分类
	 * @param level3 三级分类对象
	 */
	public Serializable add(Level3 level3);
	/**
	 *  根据level3id查询三级分类
	 * @param level3id
	 * @return
	 */
	public Level3 findById(Integer level3id);
	/**
	 *  删除三级分类
	 * @param level3 三级分类对象实例
	 */
	public void delete(Level3 level3);
	/**
	 *  更新三级分类
	 * @param level3 三级分类对象实例
	 */
	public void update(Level3 level3);
	/**
	 * 更具二级分类id查询三级分类集合
	 * @param LevelTwoId 二级分类id
	 * @return 三级分类集合
	 */
	public List<Level3> findByLevelTwoId(Integer LevelTwoId);
}
