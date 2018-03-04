package com.paireye.service.impl;

import java.util.List;

import com.paireye.dao.impl.UserDaoImpl;
import com.paireye.entity.User;
import com.paireye.service.UserService;

/**
 * user的服务层实现类
 * 
 * @author Administ
 *
 */
public class UserServiceImpl implements UserService {

	private UserDaoImpl userDao;

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public User isUser(String name, String password) {
		return userDao.isUser(name, password);
	}

	// 按用户名查询用户的方法
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User register(User user) {
		return userDao.register(user);
	}

	@Override
	public boolean delete(User user) {
		boolean delete = userDao.delete(user);
		return delete;
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

}
