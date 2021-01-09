package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1463 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N + 1];

		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		int nu;

		if (N >= 4) {
			for (int i = 2; i <= N; i++) {
				nu = arr[i - 1] + 1;
				if (i % 2 == 0) {
					nu = Math.min(nu, arr[i / 2] + 1);
				} else if (i % 3 == 0) {
					nu = Math.min(nu, arr[i / 3] + 1);
				}

				arr[i] = nu;
			}
		}

		System.out.println(arr[N]);
	}

}
