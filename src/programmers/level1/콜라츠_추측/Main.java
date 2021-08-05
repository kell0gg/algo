package programmers.level1.콜라츠_추측;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(626331);
	}
}

class Solution {
	public int solution(int num) {
		return dfs((long) num, 0);
	}

	private int dfs(long num, int count) {
		if (count > 500) {
			return -1;
		}

		if (num == 1) {
			return count;
		}

		if (num % 2 == 0) {
			return dfs(num / 2, count + 1);
		} else {
			return dfs(((num * 3) + 1), count + 1);
		}
	}
}