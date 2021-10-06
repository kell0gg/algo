package programmers.level2.캐시;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		String[] cities = { "LA", "LA" };
		Solution solution = new Solution();
		solution.solution(0, cities);
	}
}

class Solution {
	private static Map<String, Integer> CACHE;

	public int solution(int cacheSize, String[] cities) {
		CACHE = new HashMap<>();
		if (cacheSize == 0) {
			return cities.length * 5;
		}

		int entryTime = 0;
		int responseTime = 0;
		for (String city : cities) {
			city = city.toLowerCase();
			if (CACHE.containsKey(city)) {
				responseTime++;
				CACHE.put(city, entryTime);
			} else {
				if (CACHE.size() == cacheSize) {
					removeCache();
					addCache(city, entryTime);
					responseTime += 5;
				} else {
					addCache(city, entryTime);
					responseTime += 5;
				}
			}
			entryTime++;
		}
		System.out.println(responseTime);
		return responseTime;
	}

	private void removeCache() {
		int min = Integer.MAX_VALUE;
		String key = "";
		for (Map.Entry<String, Integer> cache : CACHE.entrySet()) {
			if (cache.getValue() < min) {
				key = cache.getKey();
				min = Math.min(min, cache.getValue());
			}
		}
		CACHE.remove(key);
	}

	private void addCache(String city, int entryTime) {
		CACHE.put(city, entryTime);
	}
}

class Cache {
	String city;
	long entryTime;

	public Cache(String city, long entryTime) {
		this.city = city;
		this.entryTime = entryTime;
	}
}