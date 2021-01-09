package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7562 {
	
	private static int N, sx, sy, fx, fy;
	private static int mat[][];
	private static boolean visit[][];
	private static int dir[][] = {{-2,1}, {-1, 2}, {1, 2}, {2, 1}, {2,-1}, {1, -2}, {-1, -2},{-2, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i< caseNum; i++) {
			N = Integer.parseInt(br.readLine());
			mat = new int[N][N];
			visit = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			mat[sx][sy] = 0;
			
			st = new StringTokenizer(br.readLine());
			fx = Integer.parseInt(st.nextToken());
			fy = Integer.parseInt(st.nextToken());
			
			
			bfs();
		}
		
	}

	private static void bfs() {
		//System.out.println(sx + " " + sy + " to " + fx + " " + fy);
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {sx, sy, 0});
		visit[sx][sy] = true;
		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			int curC = queue.peek()[2];
			queue.poll();
			
			if(curX == fx && curY == fy) {
				System.out.println(curC);
				return;
			}
			
			for(int i=0; i<8; i++) {
				int nx = curX + dir[i][0];
				int ny = curY + dir[i][1];
				int nc = curC + 1;
				

				
				if(nx >= 0 && ny >= 0 && nx <N && ny <N) {
					if(!visit[nx][ny]){
                        queue.offer(new int[]{nx,ny,nc});
                        visit[nx][ny] = true;
                    }
				}
			}
			
		}
		
		
	}

}
