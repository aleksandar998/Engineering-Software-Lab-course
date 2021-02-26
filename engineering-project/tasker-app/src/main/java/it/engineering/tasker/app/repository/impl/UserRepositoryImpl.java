package it.engineering.tasker.app.repository.impl;

import it.engineering.tasker.common.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import it.engineering.tasker.app.repository.Repository;

public class UserRepositoryImpl implements Repository<User> {
	private final Map<Integer, User> map = new HashMap<>();

	@Override
	public User save(User entity) {
		int id = max();
		User u = new User(++id, entity.getName(), entity.getUsername(), entity.getPassword());
		map.put(u.getId(), u);
		return u;
	}

	@Override
	public User update(User entity) {
		map.put(entity.getId(), entity);
		return entity;
	}

	@Override
	public void delete(int id) {
		map.remove(id);
	}

	@Override
	public List<User> findAll() {
		return new ArrayList<>(map.values());
	}

	@Override
	public Optional<User> findById(int id) {
		User user = map.get(id);
		if (user != null) {
			return Optional.of(user);
		}
		return Optional.empty();
	}

	private int max() {
		return map.keySet().stream().max(Integer::compareTo).orElse(0);
	}

}
