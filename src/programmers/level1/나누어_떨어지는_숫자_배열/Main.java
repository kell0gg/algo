package programmers.level1.나누어_떨어지는_숫자_배열;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = Arrays.stream(arr).filter(a -> a % divisor == 0).sorted().toArray();
		if (answer.length == 0) {
			return new int[] { -1 };
		} else {
			return answer;
		}
	}
}
