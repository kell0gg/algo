package programmers.level1.비밀지도;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(5, new int[] { 2, 20, 28, 18, 11 }, new int[] { 2, 1, 21, 17, 28 });
	}
}

class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		List<String> lists = new ArrayList<>();

		for (int i = 0; i < arr1.length; i++) {
			int temp = arr1[i] | arr2[i];
			String _form = "%" + n + "s";
			String _temp = String.format(_form, Integer.toBinaryString(temp)).replaceAll("0", " ").replaceAll("1", "#");
			lists.add(_temp);
		}
		return lists.stream().toArray(size -> new String[size]);
	}
}