package com.daniel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.daniel.dao.UserDao;
import com.daniel.model.User;

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
