package programmers.level1.가운데_글자_가져오기;

public class Main {
	public static void main(String... args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("abc"));
	}
}

class Solution {
	public String solution(String s) {
		if (s.length() % 2 == 0) {
			return s.substring((s.length() / 2) - 1, (s.length() / 2) + 1);
		} else {
			return s.substring(s.length() / 2, (s.length() / 2) + 1);
		}
	}
}
