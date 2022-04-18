package s3_22;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A1 {// �������� �Է��� ��(0 1 1 0 1 0 0 1 1 0 0 1)�� �ѹ��� 2���� ��Ŀ� �־��ش�.

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			Queue<String> queue = new LinkedList<String>();
			for (int i = 0; i < 12; i++) {
				queue.offer(input.split(" ")[i]);// �Է��Ѽ��ڵ��� ���⸦ �������� �߶� ť�� �־��ش�
			}
			String[][] arr = new String[3][4];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					arr[i][j] = queue.poll();// ť���� poll�Լ��� �̿��� ������� �ϳ��� ���� ��������� arr�� �־��ش�.
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
						result1 = "pass";// �ѿ����� 0�� 3���� ������ pass
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
						result2 = "pass";// ���࿡�� 0�� 4���� ������ pass
						break allLoop2;
					} else {
						result2 = "fail";
					}
				}
			}
			if ((result1 == "pass") || (result2 == "pass")) {// pass�� �� �Ǵ� �� ���� �ƹ������� ������ PASS���
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