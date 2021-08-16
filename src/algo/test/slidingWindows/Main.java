package algo.test.slidingWindows;

// https://www.geeksforgeeks.org/sliding-window-maximum-set-2/

public class Main {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };

		Solution solution = new Solution();
		solution.solutionDP(a.length, 3, a);
		System.out.println();
		solution.solutionTwoPointer(a.length, 3, a);
	}
}

class Solution {
	public void solutionTwoPointer(int n, int k, int[] a) {
		// Time Complexity O(N*K), Space Complexity O(1)

		if (k == 1) {
			for (int i = 0; i < n; i++) {
				System.out.print(a[i] + " ");
			}
			return;
		}

		int leftp = 0, rightp = k - 1;
		int tmp = leftp;
		int max = a[k - 1];

		while (rightp <= n - 1) {
			if (a[leftp] > max) {
				max = a[leftp];
			}

			leftp += 1;

			if (leftp == rightp && leftp != n) {
				System.out.print(max + " ");
				rightp++;
				leftp = ++tmp;

				if (rightp < n) {
					max = a[rightp];
				}
			}
		}
	}

	public void solutionDP(int n, int k, int[] a) {
		// Time Complexity O(N), Space Complexity O(N)
		if (k == 1) {
			for (int i = 0; i < n; i++) {
				System.out.print(a[i] + " ");
			}
			return;
		}

		int[] left = new int[n];
		int[] right = new int[n];

		for (int i = 0; i < n; i++) {
			if (i % k == 0) {
				left[i] = a[i];
			} else {
				left[i] = Math.max(left[i - 1], a[i]);
			}

			if ((n - i) % k == 0 || i == 0) {
				right[n - 1 - i] = a[n - 1 - i];
			} else {
				right[n - 1 - i] = Math.max(right[n - i], a[n - 1 - i]);
			}
		}
		// 좌측부터 k개로 나누어서, 가장 큰 애들로 구성
		// 1, 2, 3, // 1, 4, 5, // 2, 3, 6
		// 3, 3, 5, // 5, 5, 5, // 6, 6, 6
		// left[0] = 1, right[0] = 3
		// left[1] = 2, right[1] = 3
		// left[2] = 3, right[2] = 5
		// left[3] = 1, right[3] = 5
		// left[4] = 4, right[4] = 5
		// left[5] = 5, right[5] = 5
		// left[6] = 2, right[6] = 6
		// left[7] = 3, right[7] = 6
		// left[8] = 6, right[8] = 6

		// i = 0, j = 2
		// max(left[2], right[0])
		// max(left[3], right[1])
		// max(left[4], right[2])
		// ..
		// max(left[8], right(6])
		for (int i = 0, j = k - 1; j < n; i++, j++) {
			System.out.print(Math.max(left[j], right[i]) + " ");
		}

	}
}
