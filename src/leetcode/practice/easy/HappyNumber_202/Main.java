package leetcode.practice.easy.HappyNumber_202;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean tmp = solution.isHappy(19);
		System.out.println(tmp);
	}
}

class Solution {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		do {
			set.add(n);
			n = splitAndSqure(n);
			if (n == 1) {
				return true;
			}
		} while (!set.contains(n));

		return false;
	}

	private int splitAndSqure(int n) {
		int tmp = 0;
		while (n != 0) {
			int remains = n % 10;
			n /= 10;
			tmp += (remains * remains);
		}
		return tmp;
	}
}