package com.paireye.service;

import java.util.List;

import com.paireye.entity.User;

/**
 * user的服务层接口
 * 
 * @author Administ
 *
 */
public interface UserService {

	public List<User> getAllUser();

	public User isUser(String name, String password);

	// 按用户名查询用户的方法
	public User findByUsername(String username);

	public User register(User user);

	public boolean delete(User user);

	public void update(User user);

}
