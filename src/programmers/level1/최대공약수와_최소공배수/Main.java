package programmers.level1.최대공약수와_최소공배수;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	public int[] solution(int n, int m) {
		int g = gcd(n, m);
		return new int[] { g, (n * m)/g };
	}

	private int gcd(int n, int m) {
		int a = Math.max(n, m);
		int b = Math.min(n, m);
		while (b != 0) {
			int remains = a % b;
			a = b;
			b = remains;
		}
		return a;
	}
}
