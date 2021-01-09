package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class No2178 {
	private static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static int[][] mat;
	private static boolean[][] visited;
	private static int N;
	private static int M;

	
	public static boolean check(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		if(mat[x][y] == 0) return false;
		if(visited[x][y]) return false;
		return true;
	} 
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mat = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				mat[i][j] = line.charAt(j) - '0';
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0, 1});

		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			int curC = queue.peek()[2];
			queue.poll();
			
			
			if (visited[curX][curY])
				continue;
			visited[curX][curY] = true;

			
			if (curX == N-1 && curY == M-1) {
				cnt =curC; break;
			}
			
			
			if(check(curX-1, curY)) queue.offer(new int[] {curX-1, curY, curC +1});
			if(check(curX+1, curY)) queue.offer(new int[] {curX+1, curY, curC +1});
			if(check(curX, curY-1)) queue.offer(new int[] {curX, curY-1, curC +1});
			if(check(curX, curY+1)) queue.offer(new int[] {curX, curY+1, curC +1});

			
		}
		
		System.out.println(cnt);

	}

}
