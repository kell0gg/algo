package programmers.weekly.부족한_금액_계산하기;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		long tmp = solution.solution(2500, 10, 2500);
		System.out.println(tmp);
	}
}

class Solution {
	public long solution(int price, int money, int count) {
		long tmp = ((((long) count * (count + 1)) / 2) * price) - money;
		return tmp < 0 ? 0 : tmp;
	}
}