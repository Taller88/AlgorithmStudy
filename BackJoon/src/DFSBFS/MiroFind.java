package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MiroFind {
	
	static int[][] arr;
	static int result = Integer.MAX_VALUE;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		arr= new int[h][w];
		for(int i=0; i<h ; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<temp.length; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		boolean[][] visited = new  boolean[h][w];
		visited[0][0] = true;
//		dfs(0,0,1, visited);
		
		bfs(0,0);
		System.out.println(result);
	}
	static class Dot{
		int x;
		int y;
		int count;
		public Dot(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	private static void bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		
		q.add(new Dot(x, y));
		while(!q.isEmpty()) {
			Dot d = q.poll();
			System.out.println(d.x+ " "+d.y+ " " +arr[d.x][d.y]);
			
			for(int i=0; i< 4; i++) {
				int xx = d.x + dx[i];
				int yy = d.y + dy[i];
				if(xx>=0 && yy>=0 && xx<arr.length && yy<arr[0].length && arr[xx][yy] == 1) {
					
					arr[xx][yy] = arr[d.x][d.y]+1;
					q.add(new Dot(xx, yy));
					
				}
				
			}
		}
		result = arr[arr.length-1][arr[0].length-1];
	}
	private static void dfs(int x, int y, int count, boolean[][] visited) {
		//System.out.println("x: "+x+" y: "+y+" count: "+count );
		if(result<=count) {
			return;
		}
		if(x == arr.length-1 && y == arr[0].length-1) {
			//System.out.println(count);
			if(count<result) {
				result = count;
				return;
			}
			
		}
		
		for(int i=0; i< 4 ; i++) {
			int xx = x+ dx[i];
			int yy = y+ dy[i];
			if(xx>=0 && yy>=0 && xx<arr.length && yy<arr[0].length && arr[xx][yy]==1 && !visited[xx][yy]) {
				//arr[xx][yy] = arr[x][y]+1;
				visited[xx][yy] = true;
				dfs(xx,yy, count+1, visited);
				visited[xx][yy] = false;
				
			}
			
		}
		
	}

}
