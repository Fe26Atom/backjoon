package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11727 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		int arr[] = new int[num + 1];

		arr[0] = 0;
		arr[1] = 1;
		if (num >= 2) {
			arr[2] = 3;
			for (int i = 3; i <= num; i++) {
				arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
			}
		}
		System.out.println(arr[num]);
	}
}
