package be.duquesne.DAO;

import java.util.List;

public interface  DAO<T> 
{
	public  boolean create(T obj);
	
	public int findByLast(T s);// titre de test pas besoin reellement pr les cruds 
	
	public  boolean delete(T obj);
	
	
	public  boolean update(T obj);
	
	public  T find(T obj);
	
	public  List<?> findAll(T obj);
	
	
	
	

	

}

