package backJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


class Queue {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	
	private int count = 0;

	public void add(int num) {
		list.addLast(num);
		count++;
	}
	
	public void pop() {
		this.front();
		if(count != 0){
			list.removeFirst();
			count--;
		}
	}

	public void size() {
		System.out.println(count); 
	}

	public void empty() {
		if (count == 0)
			System.out.println(1);
		else System.out.println(0);
	}

	public void front() {
		if(count != 0){
			System.out.println(list.get(0));
		}else
			System.out.println(-1);
		
	}

	public void back() {
		if(count != 0){
			System.out.println(list.get(count -1));
		}else
			System.out.println(-1);
	}
	
	
	
	
}

public class no10845 {
	public static void main(String[] args) throws IOException {
		
		Queue queue = new Queue();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		
		
		for(int i=0; i<N; i++) {
			String operator[] = br.readLine().split(" ");
			if(operator.length == 2) {
				queue.add(Integer.parseInt(operator[1]));
			}
			else {
				if(operator[0].equals("pop")) {
					queue.pop();
				} else if(operator[0].equals("size")) {
					queue.size();
				} else if(operator[0].equals("empty")) {
					queue.empty();
				} else if(operator[0].equals("front")) {
					queue.front();
				} else if(operator[0].equals("back")) {
					queue.back();
				}
			}
			
		}
		
	}
	
}
