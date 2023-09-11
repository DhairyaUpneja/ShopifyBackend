package com.ecomm.service;

import com.ecomm.exception.UserException;
import com.ecomm.modal.User;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	


}
