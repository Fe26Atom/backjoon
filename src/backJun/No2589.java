package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2589 {
	
	public static int N, M, Max = 0;
	public static char[][] mat;
	public static boolean[][] visit;
	public static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new char[N][M];
		visit = new boolean[N][M];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0; j<M; j++) {
				mat[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(mat[i][j]=='L') {
					visit = new boolean[N][M];
					bfs(i,j);
				}
			}
		}
		System.out.println(Max);
		
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {x,y,0});
		visit[x][y] = true;
		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			int curC = queue.peek()[2];
			queue.poll();
			
			for(int i=0; i<4; i++) {
				int nX = curX + dir[i][0];
				int nY = curY + dir[i][1];
				
				if(nX >=0 && nX <N && nY >=0 && nY <M) {
					if(!visit[nX][nY] && mat[nX][nY]=='L') {
						queue.offer(new int[] {nX, nY, curC + 1});
						visit[nX][nY] = true;
						Max = Math.max(Max, curC + 1);
					}
				}
				
			}
		}
		
	}
}
