package com.paireye.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.paireye.dao.UserDao;
import com.paireye.entity.User;

/**
 * user的持久层实现类
 * 
 * @author Administ
 *
 */
@Transactional
@SuppressWarnings("unchecked")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	@Override
	public List<User> getAllUser() {
		List<User> find = (List<User>) this.getHibernateTemplate().find("from User");
		return find;
	}

	@Override
	public User isUser(String name, String password) {
		String hql = "from User where uname = ? and upassword = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, name, password);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 按名次查询是否有该用户
	@Override
	public User findByUsername(String uname) {
		String hql = "from User where uname = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, uname);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;

	}

	@Override
	public User register(User user) {
		Serializable id = this.getHibernateTemplate().save(user);
		return this.getHibernateTemplate().get(User.class, id);

	}

	@Override
	public boolean delete(User user) {
		User us = this.getHibernateTemplate().get(User.class, user.getUid());
		if (us != null) {
			this.getHibernateTemplate().delete(us);
			return true;
		}
		return false;
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}
}
