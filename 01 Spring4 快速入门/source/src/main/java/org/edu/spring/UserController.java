package org.edu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Override
	public String toString() {
		return String.format("UserController [userService=%s]", userService);
	}

}
