package programmers.level2.점프와_순간_이동;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(5);
	}
}

class Solution {
	public int solution(int n) {
		int ans = 0;

		while (n != 0) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				ans++;
				n--;
			}
		}
		return ans;
	}
}