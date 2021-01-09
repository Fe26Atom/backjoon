package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class No1697 {
	public static int[] map= new int[100001];
	public static boolean[] visit= new boolean[100001];
	public static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {s, 0});

		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curC = queue.peek()[1];
			visit[curX] = true;
			queue.poll();
			
			if(curX == f) {
				System.out.println(curC);
				break;
			}
			if(curX-1 >= 0 && !visit[curX-1]) {
				queue.offer(new int[]{curX-1,curC + 1});
			}
			if(curX+1 <= 100000 && !visit[curX+1]) {
				queue.offer(new int[]{curX+1,curC + 1});
			}
			if(curX*2 <= 100000 && !visit[curX*2]) {
				queue.offer(new int[] {curX*2, curC + 1});
			}
			
		}
	}
}	
