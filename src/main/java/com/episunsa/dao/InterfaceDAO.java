package com.episunsa.dao;
import java.util.List;

public interface InterfaceDAO<T> {
	
	public void add(T dat);
	public List<T> listAll();
	public void update(T dat);
}
