package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class No1260 {
	static int[][] mat;
	static boolean[] checked;
	static int N;
	static int M;
	static int V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		mat = new int [N+1][N+1];
		checked =  new boolean [N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			mat[x][y] = mat[y][x] = 1;
		}
		
		dfs(V);
		
		checked = new boolean[N+1];
		System.out.println();
		bfs();
	}

	private static void dfs(int i) {
		checked[i] = true;
		System.out.print(i + " ");
		for(int j = 1; j<=N;j++) {
			if(mat[i][j] == 1 && checked[j] == false)
				dfs(j);
		}
		
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		checked[V] = true;
		System.out.print(V + " ");
		
		while(!queue.isEmpty()) {
			int temp =  queue.poll();
			
			for(int j = 1; j<=N; j++ ) {
				if(mat[temp][j] == 1 && checked[j] == false) {
					queue.offer(j);
					checked[j] = true;
					System.out.print(j + " ");
				}
			}
		}
		
	}


	
	
}

