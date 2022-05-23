package com.example.assigment.smallcache;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BaseCach<K, T> {
	private Map<K, T> baseCache = new HashMap<>();

	private BaseCach() {
	}

	public static BaseCach createBaseCache() {
		return new BaseCach();
	}

	public T add(K key, T t) {
		baseCache.put(key, t);
		return baseCache.get(key);
	}

	public T find(K key) {
		return baseCache.get(key);
	}

	public T delete(K key) {
		T cached = baseCache.remove(key);
		return cached;
	}
}
