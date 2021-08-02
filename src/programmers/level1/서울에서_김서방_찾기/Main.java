package programmers.level1.서울에서_김서방_찾기;

public class Main {
	public static void main(String... args) {
		Solution solution = new Solution();
		String tmp = solution.solution(new String[] { "Jane", "Kim" });
		System.out.println(tmp);
	}
}

class Solution {
	public String solution(String[] seoul) {
		String tmp = "Kim";
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals(tmp)) {
				return String.format("김서방은 %d에 있다", i);
			}
		}
		return null;
	}
}