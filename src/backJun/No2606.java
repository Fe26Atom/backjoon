package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2606 {
	private static int N;
	private static int mat[][];
	private static boolean visit[];
	private static int vNum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int pair;
		
		N = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		
		mat = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=1; i<=pair; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			mat[x][y] = mat[y][x] = 1;
			
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(1);
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			int curN = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(mat[curN][i]==1 && !visit[i]) {
					queue.offer(i);
					visit[i]=true;
					vNum++;
				}
			}
		}
		System.out.println(vNum);
		
	}
}
