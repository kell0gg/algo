package programmers.level2.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		String[] record = { "Enter 0 Ryan" };
		Solution solution = new Solution();
		solution.solution(record);
	}
}

class Solution {
	public String[] solution(String[] record) {
		Map<String, String> map = new HashMap<>();

		List<Result> commands = new ArrayList<>();
		List<String> result = new ArrayList<>();

		for (String r : record) {
			String[] arr = r.split(" ", -1);
			String command = arr[0];

			if (command.equals("Enter")) {
				String uid = arr[1];
				String name = arr[2];
				map.put(uid, name);
				commands.add(new Result(command, uid));
			}
			if (command.equals("Leave")) {
				String uid = arr[1];
				commands.add(new Result(command, uid));
			}
			if (command.equals("Change")) {
				String uid = arr[1];
				String name = arr[2];
				map.put(uid, name);
			}
		}

		for (Result s : commands) {
			if (s.command.equals("Enter")) {
				result.add(String.format("%s님이 들어왔습니다.", map.get(s.uid)));
			}
			if (s.command.equals("Leave")) {
				result.add(String.format("%s님이 나갔습니다.", map.get(s.uid)));
			}
		}

		return result.stream().toArray(size -> new String[size]);
	}
}

class Result {
	String command, uid;

	public Result(String command, String uid) {
		this.command = command;
		this.uid = uid;
	}
}