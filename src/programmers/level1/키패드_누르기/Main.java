package programmers.level1.키패드_누르기;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";
		solution.solution(numbers, hand);
	}
}

class Solution {
	// 0,0 0,1 0,2
	// 1,0 1,1 1,2
	// 2,0 2,1 2,2
	// 3,0 3,1 3,2

	public String solution(int[] numbers, String hand) {
		Hands hands = new Hands(hand);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			int tmp = numbers[i];
			int[] to = mappingNumToArray(numbers[i]);
			if (tmp == 1 || tmp == 4 || tmp == 7) {
				sb.append(hands.moveLeftHand(to));
			} else if (tmp == 3 || tmp == 6 || tmp == 9) {
				sb.append(hands.moveRightHand(to));
			} else {
				sb.append(hands.getDistance(to));
			}
		}
		return sb.toString();
	}

	private int[] mappingNumToArray(int number) {
		if (number == 1) {
			return new int[] { 0, 0 };
		}
		if (number == 2) {
			return new int[] { 0, 1 };
		}
		if (number == 3) {
			return new int[] { 0, 2 };
		}
		if (number == 4) {
			return new int[] { 1, 0 };
		}
		if (number == 5) {
			return new int[] { 1, 1 };
		}
		if (number == 6) {
			return new int[] { 1, 2 };
		}
		if (number == 7) {
			return new int[] { 2, 0 };
		}
		if (number == 8) {
			return new int[] { 2, 1 };
		}
		if (number == 9) {
			return new int[] { 2, 2 };
		}
		if (number == 0) {
			return new int[] { 3, 1 };
		}
		return null;
	}
}

class Hands {
	int[] left = { 3, 0 };
	int[] right = { 3, 2 };
	String main;

	public Hands(String main) {
		this.main = main;
	}

	public String getDistance(int[] to) {

		int leftDist = Math.abs(to[0] - this.left[0]) + Math.abs(to[1] - this.left[1]);
		int rightDist = Math.abs(to[0] - this.right[0]) + Math.abs(to[1] - this.right[1]);

		if (leftDist > rightDist) {
			return this.moveRightHand(to);
		} else if (leftDist < rightDist) {
			return this.moveLeftHand(to);
		} else {
			if (this.main.equals("left")) {
				return this.moveLeftHand(to);
			} else if (this.main.equals("right")) {
				return this.moveRightHand(to);
			} else {
				// pass
			}
		}
		return null;
	}

	public String moveLeftHand(int[] to) {
		this.left[0] = to[0];
		this.left[1] = to[1];
		return "L";
	}

	public String moveRightHand(int[] to) {
		this.right[0] = to[0];
		this.right[1] = to[1];
		return "R";
	}
}