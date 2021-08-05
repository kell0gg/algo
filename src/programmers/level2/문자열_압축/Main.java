package programmers.level2.문자열_압축;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int tmp = solution.solution("a");
		System.out.println(tmp);
	}
}

class Solution {
	public int solution(String s) {
		int answer = Integer.MAX_VALUE;

		if (s.length() == 1) {
			return 1;
		}

		for (int i = 1; i <= s.length() / 2; i++) {
			answer = Math.min(answer, compress(s, i));
		}
		return answer;
	}

	private int compress(String s, int n) {
		List<String> lists = new ArrayList<>();

		for (int i = 0; i < s.length(); i += n) {
			int start = i;
			int end = (i + n) > s.length() ? s.length() : (i + n);
			lists.add(s.substring(start, end));
		}

		int tmp = 0;
		StringBuilder sb = new StringBuilder();

		String before = lists.get(0);
		for (int i = 0; i < lists.size(); i++) {
			String current = lists.get(i);

			if (current.equals(before)) {
				tmp++;
				continue;
			} else {
				if (tmp >= 2) {
					sb.append(tmp);
				}
				sb.append(before);
				tmp = 1;
				before = current;
			}
		}
		if (tmp >= 2) {
			sb.append(tmp);
			sb.append(before);
		} else {
			sb.append(before);
		}

		return sb.toString().length();
	}
}