package s3_22;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A1 {// 여러개를 입력한 값(0 1 1 0 1 0 0 1 1 0 0 1)을 한번에 2차원 행렬에 넣어준다.

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			Queue<String> queue = new LinkedList<String>();
			for (int i = 0; i < 12; i++) {
				queue.offer(input.split(" ")[i]);// 입력한숫자들을 띄어쓰기를 기준으로 잘라서 큐에 넣어준다
			}
			String[][] arr = new String[3][4];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					arr[i][j] = queue.poll();// 큐에서 poll함수를 이용해 순서대로 하나씩 빼서 이차원행렬 arr에 넣어준다.
				}
			}
			String result1 = "";
			allLoop: for (int j = 0; j < 4; j++) {
				int count = 0;
				for (int i = 0; i < 3; i++) {
					if (Integer.parseInt(arr[i][j]) == 0) {
						count++;
					}
					if (count == 3) {
						result1 = "pass";// 한열에서 0이 3개가 나오면 pass
						break allLoop;
					} else {
						result1 = "fail";
					}
				}
			}
			String result2 = "";
			allLoop2: for (int i = 0; i < 3; i++) {
				int count = 0;
				for (int j = 0; j < 4; j++) {
					if (Integer.parseInt(arr[i][j]) == 0) {
						count++;
					}
					if (count == 4) {
						result2 = "pass";// 한행에서 0이 4개가 나오면 pass
						break allLoop2;
					} else {
						result2 = "fail";
					}
				}
			}
			if ((result1 == "pass") || (result2 == "pass")) {// pass가 열 또는 행 둘중 아무데서나 나오면 PASS출력
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		}
	}
}
//1 1 1 0 1 1 0 1 1 0 0 1
//1 0 0 0 1 1 0 1 0 1 0 1
//0 1 1 1 0 0 0 0 1 1 0 1