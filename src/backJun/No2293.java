package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(st.nextToken());
		
		int coins[] = new int[n + 1];
		
		int arr[] = new int[k + 1];
		
		for(int i=1; i<=n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		arr[0] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				if(j >= coins[i]) {
					arr[j] += arr[j-coins[i]];
				}
				else
					arr[j] = arr[j-1];
			}
		}
		System.out.println(arr[k]);
	}

}
