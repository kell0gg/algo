package programmers.level2.뉴스_클러스터링;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("FRANCE", "french");
	}
}

class Solution {
	public int solution(String str1, String str2) {
		int answer = 65536;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		Map<String, Integer> map1 = makeElements(str1);
		Map<String, Integer> map2 = makeElements(str2);

		if (map1.size() == 0 && map2.size() == 0) {
			return 1 * answer;
		}

		int a = intersect(map1, map2);
		int b = union(map1, map2);

		b -= a;

		return (int) (((double) a / (double) b) * answer);
	}

	private int intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
		int count = 0;
		for (Map.Entry<String, Integer> m : map1.entrySet()) {
			if (map2.containsKey(m.getKey())) {
				count += Math.min(m.getValue(), map2.get(m.getKey()));
			}
		}
		return count;
	}

	private int union(Map<String, Integer> map1, Map<String, Integer> map2) {
		int count = 0;
		for (Map.Entry<String, Integer> m : map1.entrySet()) {
			count += m.getValue();
		}
		for (Map.Entry<String, Integer> m : map2.entrySet()) {
			count += m.getValue();
		}
		return count;
	}

	private Map<String, Integer> makeElements(String str) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length() - 1; i++) {
			char a = str.charAt(i);
			char b = str.charAt(i + 1);
			if ((a >= 'a' && a <= 'z') && (b >= 'a' && b <= 'z')) {
				StringBuilder sb = new StringBuilder();
				sb.append(a);
				sb.append(b);
				map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			} else {
				// pass
			}
		}
		return map;
	}
}