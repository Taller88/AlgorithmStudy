package DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus {
	static boolean[]visited;
	static int[][] arr;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[f][b] = 1;
			arr[b][f] = 1;			
		}
		dfs(1, 0);
		System.out.println(result);
		
	}

	private static void dfs(int start, int count) {
		visited[start] = true;
		for(int i=1; i<arr.length; i++) {
			if( (arr[i][start]== 1 ||arr[start][i] == 1) && !visited[i]) {
				result++;
				dfs(i, count);
				
			}
		}
		return;
	}
}
