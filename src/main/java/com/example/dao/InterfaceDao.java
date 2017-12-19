package com.example.dao;
import java.util.List;
public interface InterfaceDao<T> {
	public List<T> listAll();

	public void add(T e);

	public void update(T e);

	public void delete(T e);

	public T findById(int id);

	public void changeState(int id, char state);
}
