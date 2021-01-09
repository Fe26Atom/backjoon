package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		long arr[] = {1,1,1,1,1,1,1,1,1,1};
		
		for(int i=1; i<num; i++) {
			arr[0] = 1;
			for(int j=1; j<=9; j++) {
				arr[j] = (arr[j - 1] + arr[j]) % 10007;
			}
		}

		
		long score =0;
		for(int i=0; i<=9; i++) {
			score = (score + arr[i]) % 10007;
		}
		
		System.out.println(score);
	}
}
