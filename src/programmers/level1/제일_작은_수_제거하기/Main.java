package programmers.level1.제일_작은_수_제거하기;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] tmp = solution.solution(new int[] { 1, 2, 3, 4, 4, 1, 1, 2 });
		for (int i : tmp) {
			System.out.println(i);
		}
	}
}

class Solution {
	public int[] solution(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}

		int tmpMin = min;

		int[] answer = Arrays.stream(arr).filter(m -> m != tmpMin).boxed().mapToInt(a -> a).toArray();

		return answer.length >= 2 ? answer : new int[] { -1 };
	}
}