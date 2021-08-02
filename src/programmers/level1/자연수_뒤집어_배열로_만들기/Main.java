package programmers.level1.자연수_뒤집어_배열로_만들기;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String... args) {
		System.out.println(Integer.MAX_VALUE);
	}
}

class Solution {
	public int[] solution(long n) {
		List<Integer> lists = new ArrayList<>();

		while (n != 0) {
			int remains = (int) (n % 10);
			lists.add(remains);
			n /= 10;
		}
		return lists.stream().mapToInt(a -> a).toArray();
	}
}