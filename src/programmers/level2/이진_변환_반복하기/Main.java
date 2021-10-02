package programmers.level2.이진_변환_반복하기;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("110010101001");
	}
}

class Solution {
	public int[] solution(String s) {
		int loop = 0;
		int count = 0;
		while (!s.equals("1")) {
			String tmp = removeZero(s);
			count += (s.length() - tmp.length());
			s = getBinary(tmp.length());
			loop++;
		}
		return new int[] { loop, count };
	}

	private String getBinary(int length) {
		return Integer.toBinaryString(length);
	}

	private String removeZero(String s) {
		StringBuilder sb = new StringBuilder();
		for (char t : s.toCharArray()) {
			if (t != '0') {
				sb.append(t);
			} else {
			}
		}
		return sb.toString();
	}
}