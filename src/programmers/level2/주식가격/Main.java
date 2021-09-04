package programmers.level2.주식가격;

import java.util.ListIterator;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] { 1, 2, 3, 2, 2, 1 });
	}
}

class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		// O(N^2)........ gg;
		Stack<Integer> stack = new Stack<>();
		for (int i = prices.length - 1; i >= 0; i--) {
			ListIterator<Integer> iterator = stack.listIterator(stack.size());
			int count = 0;
			while (iterator.hasPrevious()) {
				int tmp = iterator.previous();
				if (tmp < prices[i]) {
					count++;
					break;
				} else {
					count++;
				}
			}
			stack.add(prices[i]);
			if (count == 0) {
				if (i != prices.length - 1) {
					count++;
				}
			}
			answer[i] = count;
		}

		// O(N^2)
//		for (int i = 0; i < prices.length; i++) {
//			int tmp = 0;
//			for (int j = i + 1; j < prices.length; j++) {
//				if (prices[j] >= prices[i]) {
//					tmp++;
//				} else {
//					tmp++;
//					break;
//				}
//			}
//			if (tmp == 0) {
//				if (i != prices.length - 1) {
//					tmp++;
//				}
//			}
//			answer[i] = tmp;
//		}
		return answer;
	}
}