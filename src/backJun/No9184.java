package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class No9184 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st ;
		
		int arr[][][] = new int[21][21][21];
		
		for(int i=0; i<21; i++) {
			for(int j=0; j <21; j++ ) {
				for(int k = 0; k<21; k++) {
					if(i==0||j==0||k==0) {
						arr[i][j][k] = 1;
					}
					else if(i < j && j < k) {
						arr[i][j][k] = arr[i][j][k-1] + arr[i][j-1][k-1] - arr[i][j-1][k];
					} else {
						arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
					}
				}
			}
		}
		

		int a, b, c;
		int iA, iB, iC;
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			iA = a;
			iB = b;
			iC = c;
			
			if(a==-1 && b== -1 && c == -1) {
				break;
			}
			
			else if(a<=0||b<=0||c<=0)
			{
				a=0;
				b=0;
				c=0;
			}
			else if(a>20 || b > 20 || c> 20) {
				a = 20;
				b = 20;
				c = 20;
			}
			System.out.println("w(" + iA + ", " + iB + ", " + iC + ") = " + arr[a][b][c]);
			
		}
	}
}
