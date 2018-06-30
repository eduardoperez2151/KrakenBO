package com.geocom.services;

import java.util.List;

public interface Service<T, K> {

	List<T> getAll();
	T get(final K id);
	T create(final T dto);
	T update(final T dto);
	void delete(final K id);

}
