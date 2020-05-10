package com.gestion.dao;

import java.util.List;

public abstract class DAO<T> {

	public abstract boolean add(T a);
	
	public abstract boolean delete(T a);
	
	public abstract boolean update(T a);
	
	public abstract List<T> find();
}
