package programmers.level1._3진법_뒤집기;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(45);
	}
}

class Solution {
	public int solution(int n) {
		return change(n);
	}

	private int change(int n) {
		StringBuilder sb = new StringBuilder();
		do {
			int r = n % 3;
			n /= 3;
			sb.append(r);
		} while (n != 0);

		String dec = sb.toString();
		System.out.println(dec);
		int sum = 0;
		for (int i = dec.length() - 1; i >= 0; i--) {
			sum += (dec.charAt(i) - '0') * (int) Math.pow(3, dec.length() - 1 - i);
		}
		return sum;
	}
}