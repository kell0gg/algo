package programmers.level1._2016년;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(4, 27);
	}
}

class Solution {
	public String solution(int a, int b) {
		// SUN,MON,TUE,WED,THU,FRI,SAT
		return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
	}
}
