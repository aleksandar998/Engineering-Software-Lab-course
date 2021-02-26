package it.engineering.tasker.app.service.impl;

import java.util.List;

import it.engineering.tasker.app.repository.Repository;
import it.engineering.tasker.app.service.UserService;
import it.engineering.tasker.common.exception.UserException;
import it.engineering.tasker.common.model.User;

public class UserServiceImpl implements UserService {
	private final Repository<User> repository;

	public UserServiceImpl(Repository<User> repository) {
		super();
		this.repository = repository;
	}

	@Override
	public User login(String username, String password) throws UserException {
		List<User> users = repository.findAll();
		for (User u : users) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		throw new UserException("Invalid user data!");
	}

	@Override
	public User save(User user) throws UserException {
		List<User> users = repository.findAll();
		for (User u:users) {
			if (u.getUsername().equals(user.getUsername())){
				throw new UserException("Username alredy exists!");
			}
		}
		return repository.save(user);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

}
