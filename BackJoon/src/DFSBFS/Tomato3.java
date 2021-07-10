package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato3 {
	static int[][][] arr;
	static int[]dx= {1,-1,0,0,0,0};
	static int[]dy= {0,0,1,-1,0,0};
	static int[]dz= {0,0,0,0,1,-1};
	
	static class Dot{
		int x;
		int y;
		int z;
		int day;
		
		public Dot(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}
	
	public static void main(String[]args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		arr = new int[h][m][n];
		boolean check = false;
		for(int i=0; i<h; i++) {
			for(int j=0; j<m; j++) {
				st = new StringTokenizer(br.readLine());
				for(int z =0; z<n; z++) {
					arr[i][j][z] = Integer.parseInt(st.nextToken());
					if(arr[i][j][z] == 0) {
						check = true;
					}
				}
			}
		}
		if(!check) {
			System.out.println(0);
			return;
		}
		int result = bfs();
		System.out.println(result);
		
		
		
	}
	private static int bfs() {
	
		Queue<Dot> q = new LinkedList<>();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				for(int z =0; z<arr[0][0].length; z++) {
					if(arr[i][j][z]==1) {
						q.add(new Dot(i, j, z, 0));
					}
				}
			}
		}
		int result = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Dot d = q.poll();
			result = d.day;
			System.out.println("xx: "+d.x + " yy: "+d.y+" zz: "+d.z+" day: "+d.day);
			for(int i=0; i<6; i++) {
				int xx = d.x+dx[i];
				int yy = d.y+dy[i];
				int zz = d.z+dz[i];
				if(xx>=0 && yy>=0 && zz>=0 && xx<arr.length && yy<arr[0].length && zz<arr[0][0].length && arr[xx][yy][zz] ==0 ) {
					arr[xx][yy][zz]=1;
					q.add(new Dot(xx,yy,zz,d.day+1));
					
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				for(int z =0; z<arr[0][0].length; z++) {
					if(arr[i][j][z]==0) {
						return -1;
					}
				}
			}
		}
		
		return result;
	}
}
