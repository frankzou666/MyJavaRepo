package com.aa.repository;
import java.util.*;

// why should create interface
public interface CommonRepository<T> {
	public T save(T toDo);
	public Iterable<T> save(Collection<T> domains);
	public void delete(T domain);
	public T findById(String id);
	public Iterable<T> findAll();

}
