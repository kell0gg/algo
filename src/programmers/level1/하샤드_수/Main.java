package programmers.level1.하샤드_수;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(10);
	}
}

class Solution {
	public boolean solution(int x) {
		int tmp = x;
		int sum = 0;
		while (x != 0) {
			sum += x % 10;
			x /= 10;
		}

		return tmp % sum == 0;
	}
}