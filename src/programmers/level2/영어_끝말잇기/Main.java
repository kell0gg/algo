package programmers.level2.영어_끝말잇기;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(3,
				new String[] { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" });

	}
}

class Solution {
	private static Set<String> SET = new HashSet<>();

	public int[] solution(int n, String[] words) {
		SET = new HashSet<>();

		String beforeWord = words[0];
		SET.add(beforeWord);

		for (int i = 1; i < words.length; i++) {
			String currentWord = words[i];
			if (!isAvailable(beforeWord, currentWord)) {
				int a = i % n;
				int b = i / n;
				// System.out.printf("%d %d\n", a, b);
				return new int[] { a + 1, b + 1 };
			}
			beforeWord = currentWord;
		}

		return new int[] { 0, 0 };
	}

	private boolean isAvailable(String beforeWord, String currentWord) {

		if (beforeWord.charAt(beforeWord.length() - 1) == currentWord.charAt(0)) {
			if (SET.contains(currentWord)) {
				return false;
			} else {
				SET.add(currentWord);
				return true;
			}
		} else {
			return false;
		}
	}
}