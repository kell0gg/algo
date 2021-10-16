package programmers.weekly._10주차;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[][] { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 0, 1 } });
	}
}

class Solution {
	public String[] solution(int[][] line) {
		Set<Point> set = new HashSet<>();

		long minRow = Long.MAX_VALUE, minCol = Long.MAX_VALUE, maxRow = Long.MIN_VALUE, maxCol = Long.MIN_VALUE;

		for (int i = 0; i < line.length; i++) {
			long a = line[i][0];
			long b = line[i][1];
			long e = line[i][2];
			for (int j = i + 1; j < line.length; j++) {
				long c = line[j][0];
				long d = line[j][1];
				long f = line[j][2];

				long denominator = (a * d) - (b * c);
				if (denominator == 0) {
					continue;
				}

				long numerator_1 = (b * f) - (e * d);
				long numerator_2 = (e * c) - (a * f);

				if ((numerator_1 % denominator != 0) || (numerator_2 % denominator != 0)) {
					continue;
				}

				long x = numerator_1 / denominator;
				long y = numerator_2 / denominator;

				minRow = Math.min(minRow, y);
				minCol = Math.min(minCol, x);
				maxRow = Math.max(maxRow, y);
				maxCol = Math.max(maxCol, x);

				set.add(new Point(x, y));

			}
		}

		String[] map = new String[(int) (maxRow - minRow + 1)];
		int rowCount = 0;
		for (long i = maxRow; i >= minRow; i--) {
			StringBuilder sb = new StringBuilder();
			for (long j = minCol; j <= maxCol; j++) {

				if (set.contains(new Point(j, i))) {
					sb.append('*');
				} else {
					sb.append('.');
				}
			}
			map[rowCount++] = sb.toString();
		}

		return map;
	}
}

class Point {
	String key;

	public Point(long x, long y) {
		StringBuilder sb = new StringBuilder();
		sb.append(x);
		sb.append('@');
		sb.append(y);
		key = sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return Objects.equals(key, other.key);
	}
}