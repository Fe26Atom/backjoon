package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class no14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		ArrayList nArr = new ArrayList<String>();
		
		for(int i=0; i<N; i++) {
			nArr.add(br.readLine());
		}
		
		Collections.sort(nArr, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return o1.toString().length() - o2.toString().length();
			}
		});
		
		

		ArrayList mArr = new ArrayList<String>();
		
		for(int i=0; i<M; i++) {
			mArr.add(br.readLine());
		}
		
		Collections.sort(mArr, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return o1.toString().length() - o2.toString().length();
			}
		});
		
		int score = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(nArr.get(i).toString().length() <mArr.get(j).toString().length())
					break;
				else if(nArr.get(i).toString().length() == mArr.get(j).toString().length()) {
					if(nArr.get(i).toString().equals(mArr.get(j).toString())) {
						score++;
					}
				}
			}
		}
		System.out.println(score);
	}
}
