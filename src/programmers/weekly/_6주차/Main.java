package programmers.weekly._6주차;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[] weights = new int[] { 60, 70, 60 };
		String[] head2head = new String[] { "NNN", "NNN", "NNN" };
		Solution solution = new Solution();
		solution.solution(weights, head2head);

	}
}

class Solution {
	public int[] solution(int[] weights, String[] head2head) {

		List<Boxer> boxers = new ArrayList<>();

		for (int i = 0; i < head2head.length; i++) {
			int winCount = 0;
			double winRate = 0;
			double _w = 0;
			int nCount = 0;
			for (int j = 0; j < head2head[i].length(); j++) {
				if (head2head[i].charAt(j) != 'N') {
					nCount++;
				}

				if (head2head[i].charAt(j) == 'W') {
					_w++;
					if (weights[i] < weights[j]) {
						winCount++;
					}
				}
			}
			if (_w == 0) {
				winRate = 0;
			} else {
				winRate = (double) _w / nCount;
			}
			boxers.add(new Boxer(winRate, winCount, weights[i], i + 1));
			// System.out.printf("winRate %f, winCount %d, weight %d, idx %d\n", winRate, winCount, weights[i], i + 1);
		}

		boxers.sort((a, b) -> {
			if (a.winRate != b.winRate) {
				return b.winRate - a.winRate > 0 ? 1 : -1;
			} else {
				if (a.winCount != b.winCount) {
					return b.winCount - a.winCount;
				} else {
					if (a.weight != b.weight) {
						return b.weight - a.weight;
					} else {
						return a.idx - b.idx;
					}
				}
			}
		});

		return boxers.stream().mapToInt(boxer -> boxer.idx).toArray();
	}
}

class Boxer {
	double winRate;
	int winCount;
	int weight;
	int idx;

	public Boxer(double winRate, int winCount, int weight, int idx) {
		this.winRate = winRate;
		this.winCount = winCount;
		this.weight = weight;
		this.idx = idx;
	}
}