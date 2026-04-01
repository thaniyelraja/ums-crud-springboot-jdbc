package com.proj.ums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.ums.dao.UserDao;
import com.proj.ums.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public void addUser(User user) {

		userDao.addUser(user);

	}

	public User getUser(int id) {
		return userDao.getUser(id);
	}

	public List<User> getAllUsers() {

		return userDao.getAllUsers();
	}

	public void updateUser(User user) {
		
		userDao.updateUser(user);
		
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

}
