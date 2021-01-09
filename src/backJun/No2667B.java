package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2667B {
	private static int dx[] = {0,0,1,-1};
	private static int dy[] = {1,-1,0,0};
	private static int[] aparts = new int[25 * 25];
	private static int N;
	private static int apartNum = 0;
	private static boolean [][]visited = new boolean[25][25];
	private static int[][]map = new int[25][25];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0; j<N; j++) {
				map[i][j]= line.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					apartNum++;
					bfs(i, j);
				}
			}
		}
		
		Arrays.sort(aparts);
		System.out.println(apartNum);
		
		for(int i:aparts) {
			if(i == 0) {}
			else {
				System.out.println(i);
			}
		}
	}

	private static void bfs(int x, int y) {
		Queue<int []> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		
		visited[x][y] = true;
		aparts[apartNum]++;
		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx <N && ny <N) {
					if(map[nx][ny] == 1 && !visited[nx][ny]){
                        queue.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        aparts[apartNum]++;
                    }
				}
			}
		}
	}
}
