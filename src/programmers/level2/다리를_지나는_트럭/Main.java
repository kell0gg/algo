package programmers.level2.다리를_지나는_트럭;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		// solution.solution(2, 10, new int[] { 7, 4, 5, 6 });
		solution.solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 });
	}
}

class Solution {
	private static int CURRENT_WEIGHT;
	private static int CURRENT_TIME;
	private static int LAST_TRUCK_INPUT_TIME;

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		LAST_TRUCK_INPUT_TIME = 0;
		CURRENT_TIME = 0;
		CURRENT_WEIGHT = 0;

		int answer = 0;
		Deque<Truck> q = new ArrayDeque<>();

		for (int i = 0; i < truck_weights.length; i++) {
			removeTruck(q, bridge_length);
			CURRENT_TIME++;
			if (!pushTruck(q, truck_weights[i], weight)) {
				i--;
			}
		}

		if (!q.isEmpty()) {
			LAST_TRUCK_INPUT_TIME = q.peekLast().inputTime;
		}

		answer = LAST_TRUCK_INPUT_TIME + bridge_length;
		System.out.println(answer);
		return answer;
	}

	private boolean pushTruck(Deque<Truck> q, int truck_weight, int weight) {
		if (CURRENT_WEIGHT + truck_weight <= weight) {
			CURRENT_WEIGHT += truck_weight;
			q.addLast(new Truck(CURRENT_TIME, truck_weight));
			return true;
		} else {
			return false;
		}
	}

	private void removeTruck(Deque<Truck> q, int bridge_length) {
		while (!q.isEmpty()) {
			Truck tmp = q.peekFirst();

			if ((CURRENT_TIME - tmp.inputTime + 1) >= bridge_length) {
				CURRENT_WEIGHT -= tmp.weight;
				LAST_TRUCK_INPUT_TIME = tmp.inputTime;
				q.pollFirst();
			} else {
				break;
			}
		}
		return;
	}
}

class Truck {
	int inputTime, weight;

	public Truck(int inputTime, int weight) {
		this.inputTime = inputTime;
		this.weight = weight;
	}
}