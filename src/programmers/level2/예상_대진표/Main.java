package programmers.level2.예상_대진표;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(8, 4, 5);
	}
}

class Solution {
	public int solution(int n, int a, int b) {

		int count = 0;
		while (a != b) {
			if (!(a % 2 == 0)) {
				a++;
			}
			if (!(b % 2 == 0)) {
				b++;
			}
			a /= 2;
			b /= 2;
			count++;
		}
		return count;
	}
}