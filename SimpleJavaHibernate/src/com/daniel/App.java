package com.daniel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.daniel.dao.UserDao;
import com.daniel.model.User;
import com.daniel.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		UserDao dao = new UserDao();

		// Add new user
		User user = new User();
		user.setFirstName("Daniel");
		user.setLastName("Niko");
		try {
			Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("1986-01-02");
			user.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEmail("daniel@example.com");
		dao.addUser(user);

		// Update user
		user.setEmail("daniel@updated.com");
		dao.updateUser(user);

		// Delete user
		// dao.deleteUser(1);

		// Get all users
		for (User iter : dao.getAllUsers()) {
			System.out.println(iter);
		}

		// Get user by id
		System.out.println(dao.getUserById(2));
	}


}
