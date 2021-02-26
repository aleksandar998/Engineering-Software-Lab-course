package it.engineering.tasker.app.service;

import it.engineering.tasker.common.exception.UserException;
import it.engineering.tasker.common.model.User;

import java.util.List;

public interface UserService {
	User login(String username, String password) throws UserException;
	User save(User user) throws UserException;
	List<User> findAll();
}
