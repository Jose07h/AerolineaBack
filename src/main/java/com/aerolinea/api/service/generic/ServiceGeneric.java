package com.aerolinea.api.service.generic;

import java.util.List;

public interface ServiceGeneric<T> {
	public List<T> findAll();

	public List<T> findByOrden(String orden);

	public T findById(Integer id);
	
	public T save(T entity) ;
	
	public void delete(T entity);
	
	public T MapNewToOld(T oldEnity,T newEntity);
	
	public Boolean isUsed(T entity);
	
}
