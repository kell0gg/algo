package programmers.level1.문자열_다루기_기본;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	public boolean solution(String s) {
		if (s.length() != 4 && s.length() != 6) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}