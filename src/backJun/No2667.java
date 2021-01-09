package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class No2667 {
	private static int apartNum = 0;
	private static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	private static int[][] mat;
	private static boolean [][]visited;
	private static int[] aparts;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		mat = new int[N][N];
		aparts = new int[N*N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				mat[i][j] =line.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(mat[i][j]==1 && visited[i][j]==false) {
					apartNum++;
					dfs(i, j);
				}
			}
		}
		
		
		Arrays.sort(aparts);
		System.out.println(apartNum);
		
		for(int i:aparts) {
			if(i!=0) {
				System.out.println(i);
			}
		}
		
		
		
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		aparts[apartNum]++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			if(nx >=0 && ny >=0 && nx < N && ny < N) {
				if(mat[nx][ny] == 1 && visited[nx][ny] == false) {
					dfs(nx, ny);
				}
			}
		}
		
	}



}
