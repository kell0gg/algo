package programmers.level1.평균_구하기;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	public double solution(int[] arr) {
		int tmp = Arrays.stream(arr).reduce(0, (a, b) -> (a + b));
		return (double) tmp / arr.length;
	}
}