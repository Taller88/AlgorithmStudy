package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SafeArea2 {
	static int[][] arr;
	static boolean[][]visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[]args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
		int max =0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int temp =Integer.parseInt(st.nextToken());
				arr[i][j] =temp;
				if(temp > max) {
					max = temp;
				}
			}
		}
		
		int result =0;
		while(max != 0) {
			int rainResult = rain(max--);
			if(result< rainResult) {
				result = rainResult;
			}
		}
		System.out.println(result);
		
	}

	private static int rain(int rain) {
		visited = new boolean[arr.length][arr[0].length];
		int result =0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(rain <arr[i][j]) {
					visited[i][j] = true; 
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(visited[i][j]) {
					bfs(i,j);
					result++;
				}
				
			}
		}
		
		
		
		return result;
	}

	private static void bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<SafeArea2.Dot>();
		q.add(new Dot(x, y));
		visited[x][y] = false;
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			for(int i=0; i<4; i++) {
				int xx = d.x+dx[i];
				int yy = d.y+dy[i];
				if(xx>=0 && yy>=0 && xx<visited.length && yy<visited[0].length && visited[xx][yy]) {
					q.add(new Dot(xx, yy));
					visited[xx][yy] = false;
				}
			}
		}
		
	}

	
	static class Dot{
		int x; 
		int y;
		public Dot() {
			// TODO Auto-generated constructor stub
		}
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
