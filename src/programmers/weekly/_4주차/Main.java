package programmers.weekly._4주차;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA" };
		String[] languages = { "PYTHON", "C++", "SQL" };
		int[] preference = { 7, 5, 5 };

		Solution solution = new Solution();
		solution.solution(table, languages, preference);
	}
}

class Solution {
	private static List<ScoreBoard> LIST = new ArrayList<>();

	public String solution(String[] table, String[] languages, int[] preference) {
		PriorityQueue<Group> q = new PriorityQueue<>((a, b) -> {
			if (a.totalScore == b.totalScore) {
				return a.group.compareTo(b.group);
			} else {
				return b.totalScore - a.totalScore;
			}
		});
		scoreTable(table);

		for (ScoreBoard sb : LIST) {
			int tmpTotalScore = 0;
			for (int i = 0; i < languages.length; i++) {
				int tmpScore = sb.map.getOrDefault(languages[i], 0) * preference[i];
				tmpTotalScore += tmpScore;
			}
			q.add(new Group(sb.group, tmpTotalScore));
		}

		// System.out.println(q.peek().group);
		return q.peek().group;
	}

	private void scoreTable(String[] table) {
		LIST = new ArrayList<>();

		for (String tmp : table) {
			String[] tmpArr = tmp.split(" ", -1);
			String group = tmpArr[0];
			ScoreBoard sb = new ScoreBoard(group);
			for (int i = 1; i < tmpArr.length; i++) {
				sb.map.put(tmpArr[i], 6 - i);
			}
			LIST.add(sb);
		}
	}
}

class Group {
	String group;
	int totalScore;

	public Group(String group, int totalScore) {
		this.group = group;
		this.totalScore = totalScore;
	}
}

class ScoreBoard {
	String group;
	Map<String, Integer> map;

	public ScoreBoard(String group) {
		this.group = group;
		this.map = new HashMap<>();
	}
}