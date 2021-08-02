package programmers.level1.수박수박수박수박수박수;

public class Main {

}

class Solution {
	public String solution(int n) {
		StringBuilder sb = new StringBuilder();
		String[] tmps = { "수", "박" };

		for (int i = 0; i < n; i++) {
			sb.append(tmps[i % 2]);
		}
		return sb.toString();
	}
}