package programmers.level1.숫자_문자열과_영단어;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int a = solution.solution("one4seveneight");
		System.out.println(a);
	}
}

class Solution {
	public int solution(String s) {
		s = s.replaceAll("zero", "0");
		s = s.replaceAll("one", "1");
		s = s.replaceAll("two", "2");
		s = s.replaceAll("three", "3");
		s = s.replaceAll("four", "4");
		s = s.replaceAll("five", "5");
		s = s.replaceAll("six", "6");
		s = s.replaceAll("seven", "7");
		s = s.replaceAll("eight", "8");
		s = s.replaceAll("nine", "9");
		return Integer.parseInt(s);
	}
}