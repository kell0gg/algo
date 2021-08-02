package programmers.level1.이상한_문자_만들기;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		String[] tmp = s.split(" ", -1);

		for (String t : tmp) {
			for (int i = 0; i < t.length(); i++) {
				if (i == 0) {
					sb.append(Character.toUpperCase(t.charAt(i)));
				} else if (i % 2 == 0) {
					sb.append(Character.toUpperCase(t.charAt(i)));
				} else {
					sb.append(Character.toLowerCase(t.charAt(i)));
				}
			}
			sb.append(" ");
		}

		return sb.substring(0, sb.length() - 1).toString();
	}
}