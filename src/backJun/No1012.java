package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1012 {

	private static int M;
	private static int N;
	private static int K;
	private static int mat[][];
	private static boolean visit[][];
	private static int count;
	private static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			count = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			mat = new int[N][M];
			visit = new boolean[N][M];
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				mat[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			bfs();
			
		}

	}


	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(mat[i][j]==0 || visit[i][j]==true)
					continue;
				queue.offer(new int[] {i,j});
				visit[i][j] = true;
				
				count++;
				while(!queue.isEmpty()) {
					int curX =queue.peek()[0];
					int curY = queue.peek()[1];
					queue.poll();
					
					
					for(int k=0; k<4; k++) {
						int nx = curX + dir[k][0];
						int ny = curY + dir[k][1];
						
						if(nx>=0 && nx <N && ny>= 0 && ny < M) {
							if(!visit[nx][ny] && mat[nx][ny] == 1) {
								queue.offer(new int[] {nx,ny});
								visit[nx][ny] = true;
							}
						}
					}
					
				}
				
			}
			
		}
		System.out.println(count);
	}
}
