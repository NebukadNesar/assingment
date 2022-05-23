package com.example.assigment.smallcache;

public interface Cache<T> {

	T add(T t);

	T find(T t);

	T delete(T t);
}
