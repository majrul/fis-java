package com.fis.component;

import org.springframework.stereotype.Component;

@Component("login")
public class LoginService {

	public boolean isValid(String username, String password) {
		if(username.equals("majrul") && password.equals("123"))
			return true;
		return false;
	}
}
