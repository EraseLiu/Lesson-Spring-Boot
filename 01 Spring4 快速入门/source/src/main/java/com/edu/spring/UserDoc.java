package com.edu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDoc {

	@Autowired
	private User user;

	@Override
	public String toString() {
		return String.format("UserDoc [user=%s]", user);
	}

}
