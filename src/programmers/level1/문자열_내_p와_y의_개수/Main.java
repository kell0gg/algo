package programmers.level1.문자열_내_p와_y의_개수;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	boolean solution(String s) {
		int pc = 0, yc = 0;

		s = s.toLowerCase();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p') {
				pc++;
			}
			if (s.charAt(i) == 'y') {
				yc++;
			}
		}
		return pc == yc;
	}
}