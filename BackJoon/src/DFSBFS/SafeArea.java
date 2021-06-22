package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SafeArea {
	static int[][] arr;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	public static void main(String[]args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		int max = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int value = Integer.parseInt(st.nextToken());
				arr[i][j] = value; 
				if(value > max) {
					max = value; 
				}
			}
		}
		System.out.println("?");
		int result = 0;
		while(max != 0) {
			//System.out.println(max);
			visited = new boolean[arr.length][arr[0].length];
			for(int i=0; i< arr.length; i++) {
				for(int j=0; j<arr[0].length; j++) {
					if(arr[i][j]<max) {
						visited[i][j] = true;
					}
				}
			}
			int temp =temp(max);
			if(temp >result) {
				result = temp;
			}
			max--;
			
		}
		System.out.println("temp: "+result);
	}

	private static int temp(int max ) {
		int result = 0;
		
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(visited[i][j]) {
					bfs(i, j);
					result ++;
				}
			}
		}
		
		
		return result ;
	}
	public static void bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<SafeArea.Dot>();
		q.add(new Dot(x, y));
		while(!q.isEmpty()) {
			Dot d = q.poll();
			for(int i=0; i< 4; i++) {
				int xx = d.x+ dx[i];
				int yy = d.y+ dy[i];
				if(xx>=0 && yy>=0 && xx<arr.length && yy<arr.length && visited[xx][yy]) {
					visited[xx][yy] = false;
					q.add(new Dot(xx, yy));
				}
				
			}
		}
	}

	public static class Dot{
		int x; 
		int y;
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Dot() {
			// TODO Auto-generated constructor stub
		}
	}

}
