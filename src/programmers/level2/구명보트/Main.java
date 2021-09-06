package programmers.level2.구명보트;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] { 70, 50, 80, 50 }, 100);
	}
}

class Solution {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);

		int left = 0;
		int right = people.length - 1;
		int count = 0;

		while (left <= right) {
			if (people[left] + people[right] <= limit) {
				count++;
				left++;
				right--;
			} else {
				count++;
				right--;
			}
		}
		return count;
	}
}