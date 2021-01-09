package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7576 {
	private static int dx[] = {0,0,1,-1};
	private static int dy[] = {1,-1,0,0};
	private static int mat[][];
	private static boolean visit[][];
	private static int N;
	private static int M;
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		visit = new boolean[N][M];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		bfs();
		
		int count = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(mat[i][j]==0) {
					count = 0;
					break;
				}		
				count = Math.max(mat[i][j], count);
			}if(count == 0)
				break;
		}
		System.out.println(count - 1);
		


	}

	private static void bfs() {
		
		Queue<int []> queue = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(mat[i][j]==1) {
					queue.offer(new int[] {i, j, 1});
					visit[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			int curC = queue.peek()[2];
			
			queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx <N && ny <M) {
					if(mat[nx][ny] != -1 && !visit[nx][ny]){
						if(mat[nx][ny] != 0)
							mat[nx][ny] = Math.min(curC + 1, mat[nx][ny]);
						else
							mat[nx][ny] = curC + 1;
                        queue.offer(new int[]{nx,ny, curC + 1});
                        visit[nx][ny] = true;
                    }
				}
			}
		}
		
	}
}
