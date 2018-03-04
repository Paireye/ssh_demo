package com.paireye.dao;

import java.util.List;

import com.paireye.entity.User;

/**
 * user的持久层接口
 * 
 * @author Administ
 *
 */
public interface UserDao {

	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	public List<User> getAllUser();

	/**
	 * 用用户名密码查找用户是否存在
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public User isUser(String name, String password);

	/**
	 * 通过用户名查找用户是否存在
	 * 
	 * @param uname
	 * @return
	 */
	public User findByUsername(String uname);

	/**
	 * 注册新的用户
	 * 
	 * @param user
	 * @return
	 */
	public User register(User user);

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean delete(User user);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 */
	public void update(User user);
}
