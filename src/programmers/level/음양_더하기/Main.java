package programmers.level.음양_더하기;

public class Main {
	public static void main(String[] args) {
	}
}

class Solution {
	public int solution(int[] absolutes, boolean[] signs) {
		long t1 = 0;
		long t2 = 0;
		for (int i = 0; i < absolutes.length; i++) {
			if (signs[i]) {
				t1 += absolutes[i];
			} else {
				t2 += absolutes[i];
			}
		}
		return (int) (t1 - t2);
	}
}