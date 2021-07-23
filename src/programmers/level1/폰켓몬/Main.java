package programmers.level1.폰켓몬;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] {});
	}
}

class Solution {
	public int solution(int[] nums) {
		int answer = (int) (Arrays.stream(nums).distinct().count());
		return answer > nums.length / 2 ? nums.length / 2 : answer;
	}
}