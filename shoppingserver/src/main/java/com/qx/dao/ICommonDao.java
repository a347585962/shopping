package com.qx.dao;

import java.util.List;

/**
 *  公共Dao类
 * @author Administrator 
 *
 * @param <T> 
 */
public interface ICommonDao<T> {

	/**
	 *  添加对象实例
	 * @param object 实例
	 */
	public void add(T object);
	/**
	 *  更新对象实例
	 * @param object 实例
	 */
	public void update(T object);
	/**
	 *  删除对象实例
	 * @param object 实例
	 */
    public void delete(T object);
    /**
     *  查询所有对象集合
     * @return 对象集合
     */
    public List<T> findAll();
    /**
     *  查询表中包含的实例数量
     * @return 实例数量
     */
    public int sizeoflist();
    /**
     *  分页查询对象实例集合
     * @param start 开始序列
     * @param size 查询数量
     * @return 实例集合
     */
    public List<T> findByPage(final int start, final int size);
    /**
     *  根据id查询对象实例
     * @param id
     * @return
     */
    public T findById(Integer id);
}
