package programmers.level1.다트게임;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("1D2S#10S");
	}
}

class Solution {
	public int solution(String dartResult) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		int[] scores = new int[3];
		int index = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			char _t = dartResult.charAt(i);
			if (Character.isDigit(_t)) {
				sb.append(_t);
			}
			if (Character.isAlphabetic(_t)) {
				int score = Integer.parseInt(sb.toString());
				sb = new StringBuilder();

				// S,D,T
				int m = 0;
				if (_t == 'S') {
					m = 1;
				}
				if (_t == 'D') {
					m = 2;
				}
				if (_t == 'T') {
					m = 3;
				}

				score = (int) Math.pow(score, m);
				scores[index] = score;

				if (i + 1 < dartResult.length()) {
					_t = dartResult.charAt(i + 1);
					if (_t == '*') {
						i++;
						if (index == 0) {
							scores[index] *= 2;
						} else {
							scores[index - 1] *= 2;
							scores[index] *= 2;
						}
					}
					if (_t == '#') {
						i++;
						scores[index] *= -1;
					}
				}
				index++;
			}
		}

		for (int s : scores) {
			answer += s;
		}
		return answer;
	}
}