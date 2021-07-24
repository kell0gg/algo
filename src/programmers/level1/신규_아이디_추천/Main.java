package programmers.level1.신규_아이디_추천;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String ans = solution.solution("...!@BaT#*..y.abcdefghijklm");
		System.out.println("ans =>" + ans);
	}
}

class Solution {
	public String solution(String new_id) {
		new_id = step1(new_id);
		// System.out.println(new_id);
		new_id = step2(new_id);
		// System.out.println(new_id);
		new_id = step3(new_id);
		// System.out.println(new_id);
		new_id = step4(new_id);
		// System.out.println(new_id);
		new_id = step5(new_id);
		// System.out.println(new_id);
		new_id = step6(new_id);
		// System.out.println(new_id);
		new_id = step7(new_id);
		// System.out.println(new_id);

		return new_id;
	}

	private String step1(String new_id) {
		return new_id.toLowerCase();
	}

	private String step2(String new_id) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			if ((int) 'a' <= new_id.charAt(i) && (int) 'z' >= new_id.charAt(i)) {
				sb.append(new_id.charAt(i));
			}
			if ((int) '0' <= new_id.charAt(i) && (int) '9' >= new_id.charAt(i)) {
				sb.append(new_id.charAt(i));
			}
			if (new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.') {
				sb.append(new_id.charAt(i));
			}
		}

		return sb.toString();
	}

	private String step3(String new_id) {
		StringBuilder sb = new StringBuilder();
		int culmulativeCount = 0;
		for (int i = 0; i < new_id.length(); i++) {
			if (new_id.charAt(i) == '.') {
				culmulativeCount++;
			} else {
				if (culmulativeCount > 0) {
					sb.append('.');
				}
				culmulativeCount = 0;
				sb.append(new_id.charAt(i));
			}
		}
		return sb.toString();
	}

	private String step4(String new_id) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			if ((i == 0 || i == new_id.length() - 1) && new_id.charAt(i) == '.') {
				// pass
			} else {
				sb.append(new_id.charAt(i));
			}
		}
		return sb.toString();
	}

	private String step5(String new_id) {
		StringBuilder sb = new StringBuilder();
		if (new_id.equals("")) {
			sb.append('a');
		} else {
			sb.append(new_id);
		}
		return sb.toString();
	}

	private String step6(String new_id) {
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if (new_id.charAt(new_id.length() - 1) == '.') {
				new_id = new_id.substring(0, new_id.length() - 1);
			}
		} else {
			// pass
		}
		return new_id;
	}

	private String step7(String new_id) {
		StringBuilder sb = new StringBuilder();
		if (new_id.length() <= 2) {
			sb.append(new_id);
			int size = 3 - new_id.length();
			char tmp = new_id.charAt(new_id.length() - 1);
			for (int i = 0; i < size; i++) {
				sb.append(tmp);
			}
		} else {
			sb.append(new_id);
		}
		return sb.toString();
	}
}