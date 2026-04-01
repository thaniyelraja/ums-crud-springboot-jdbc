package com.proj.ums.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proj.ums.entity.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// CREATE
	public void addUser(User user) {
		String sql = "INSERT INTO users(name, age, email) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail());
	}
	
	//GET USER BY ID
	public User getUser(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		List<User> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setAge(rs.getInt("age"));
			u.setEmail(rs.getString("email"));
			return u;
		}, id);
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	// GET ALL USERS
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM users";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setAge(rs.getInt("age"));
			u.setEmail(rs.getString("email"));
			return u;
		});
	}

	// UPDATE
	public void updateUser(User user) {
		String sql = "UPDATE users SET name=?, age=?, email=? WHERE id=?";
		jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail(), user.getId());
	}

	// DELETE
	public void deleteUser(int id) {
		String sql = "DELETE FROM users WHERE id=?";
		jdbcTemplate.update(sql, id);
	}
	
	

}