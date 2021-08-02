package programmers.level1.시저_암호;

public class Main {
	public static void main(String[] args) {
		System.out.println((int)'A');
	}
}

class Solution {
	public String solution(String s, int n) {

		char[] ua = new char[26];
		char[] la = new char[26];

		for (int i = 0; i < 26; i++) {
			la[i] = (char) ('a' + i);
			ua[i] = (char) ('A' + i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				sb.append(la[(s.charAt(i) - 'a' + n) % 26]);
				
			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				sb.append(ua[(s.charAt(i) - 'A' + n) % 26]);
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}