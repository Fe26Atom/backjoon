package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1260F {
	public static int N;
	public static int M;
	public static int V;
	
	public static int mat[][];
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		mat = new int[N][N];
		visited = new boolean[N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int imsiX = Integer.parseInt(st.nextToken());
			int imsiY = Integer.parseInt(st.nextToken());
			
			mat[imsiX - 1][imsiY - 1] = mat[imsiY - 1][imsiX - 1] = 1;
		}
		
		dfs(V);
		
		visited = new boolean[N];
		System.out.println();
		bfs();
		
	}

	private static void dfs(int v) {
		System.out.print(v + " ");
		visited[v-1] = true;
		for(int i=0; i<N; i++) {
			if(mat[v - 1][i] == 1 && !visited[i]) {
				dfs(i + 1);
			}
		}
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		visited[V-1] = true;
		System.out.print(V + " ");
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i=0; i<N; i++) {
				if(mat[temp - 1][i] == 1 && !visited[i]) {
					queue.add(i + 1);
					visited[i] = true;
					System.out.print(i + 1 + " ");
				}
			}
			
		}
		
		
		
	}

}
