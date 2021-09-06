package programmers.level2._2개_이하로_다른_비트;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new long[] { 9 });
	}
}

class Solution {
	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = findLowNumber(numbers[i]);
		}

		return answer;
	}

	private long findLowNumber(long number) {
		if (number % 2 == 0) {
			return ++number;
		} else {
			String tmpString = Long.toBinaryString(number);
			if (tmpString.indexOf('0') == -1) {
				tmpString = "0" + tmpString;
			}

			char[] tmpArr = tmpString.toCharArray();
			for (int i = tmpArr.length - 1; i >= 0; i--) {
				if (tmpArr[i] == '0') {
					tmpArr[i] = '1';
					tmpArr[i + 1] = '0';
					break;
				}
			}
			return Long.parseLong(String.valueOf(tmpArr), 2);
		}
	}
}