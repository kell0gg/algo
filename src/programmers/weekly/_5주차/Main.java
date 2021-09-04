package programmers.weekly._5주차;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int tmp = solution.solution("A");
		System.out.println(tmp);
	}
}

class Solution {
	private static final String[] VOWEL = { "A", "E", "I", "O", "U" };

	public int solution(String word) {
		List<String> list = new ArrayList<>(3906);

		dfs("", list);

		return list.indexOf(word);
	}

	private void dfs(String currentWord, List<String> list) {
		if (currentWord.length() > 5) {
			return;
		} else {
			list.add(currentWord);
		}

		for (String vowel : VOWEL) {
			dfs(currentWord + vowel, list);
		}
	}
}