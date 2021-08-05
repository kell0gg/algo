package programmers.level2.타겟_넘버;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	private static int COUNT = 0;

	public int solution(int[] numbers, int target) {
		COUNT = 0;
		dfs(0, numbers, target, 0);
		return COUNT;
	}

	private void dfs(int depth, int[] numbers, int target, int sum) {
		if (depth == numbers.length) {
			if (target == sum) {
				COUNT++;
			}
			return;
		}

		dfs(depth + 1, numbers, target, sum + numbers[depth]);
		dfs(depth + 1, numbers, target, sum - numbers[depth]);
	}
}