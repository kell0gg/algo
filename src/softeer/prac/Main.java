package softeer.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		List<Integer> list = new ArrayList<>();

		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		int[] dp_up = new int[n];
		int totalCount = 0;

		for (int i = 1; i < list.size(); i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (list.get(j) < list.get(i)) {
					max = Math.max(dp_up[j] + 1, max);
				}
			}
			dp_up[i] = max;
		}

		for (int start = 1; start < list.size(); start++) {
			int[] dp_low = new int[n];
			for (int i = start; i < list.size(); i++) {
				int max = 0;
				for (int j = 0; j < i; j++) {
					if (list.get(j) > list.get(i)) {
						max = Math.max(dp_low[j] + 1, max);
					}
				}
				dp_low[i] = max;
			}

			int _max = 0;
			for (int left = start; left < list.size(); left++) {
				_max = Math.max(dp_low[left], _max);
			}
			totalCount = Math.max(_max + dp_up[start - 1], totalCount);
		}

		System.out.println(totalCount + 1);
	}
}
