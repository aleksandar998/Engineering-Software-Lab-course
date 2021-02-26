package it.engineering.tasker.app.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

	T save(T entity);

	T update(T entity);

	void delete(int id);

	List<T> findAll();

	Optional<T> findById(int id);

}
