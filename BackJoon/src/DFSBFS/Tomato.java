package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
	public static class Dot{
		int x;
		int y; 
		int day;
		public Dot(int x, int y , int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
		public Dot() {
		}
		
	}
	static int[]dx = {1,-1,0,0};
	static int[]dy = {0,0,1,-1};
	
	
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][] arr = new int[h][w];
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		int result = bfs(arr);
		System.out.println(result);
	}


	private static int bfs(int[][] arr) {
		int result = 0;
		Queue<Dot> q= new LinkedList<>();
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]==1) {
					q.add(new Dot(i, j, 0));
				}
			}
		}
		while(!q.isEmpty()) {
			Dot t = q.poll();
			result = t.day;
			for(int i=0; i<4; i++) {
				int xx = t.x+dx[i];
				int yy = t.y+dy[i];
				if(xx>=0 && yy>=0 && xx<arr.length && yy<arr[0].length ) {
					if(arr[xx][yy]==0) {
//						System.out.println("xx: "+xx+ " yy: "+yy);
						arr[xx][yy] =1;
						q.add(new Dot(xx, yy, t.day+1));						
					}
					
				}
				
			}
		}
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]==0) {
					return -1;
				}
			}
		}
		return result;
	}

}
