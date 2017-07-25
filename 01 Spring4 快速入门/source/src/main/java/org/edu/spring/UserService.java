package org.edu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDoc userDoc;

	@Override
	public String toString() {
		return String.format("UserService [userDoc=%s]", userDoc);
	}

}
