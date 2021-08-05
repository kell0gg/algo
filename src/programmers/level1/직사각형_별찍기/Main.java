package programmers.level1.직사각형_별찍기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		for (int i = 0; i < b; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < a; j++) {
				sb.append('*');
			}
			System.out.println(sb.toString());
		}
	}
}
