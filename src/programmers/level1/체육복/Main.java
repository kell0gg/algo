package programmers.level1.체육복;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int ans = solution.solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 });
		System.out.println(ans);
	}
}

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] total = new int[n];

		for (int i = 0; i < lost.length; i++) {
			total[lost[i] - 1]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			total[reserve[i] - 1]++;
		}

		for (int i = 0; i < n; i++) {
			int left = i - 1;
			int right = i + 1;
			if (total[i] == -1) {
				if (left >= 0) {
					if (total[left] > 0) {
						total[i]++;
						total[left]--;
						continue;
					}
				}
				if (right < n) {
					if (total[right] > 0) {
						total[i]++;
						total[right]--;
						continue;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (total[i] >= 0) {
				answer++;
			}
		}

		return answer;
	}
}