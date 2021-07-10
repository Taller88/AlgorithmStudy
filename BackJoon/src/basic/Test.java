package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
	static int[][] arr;
	static int result = 0;
	static boolean[]visited;
	public static void main(String[]args) throws Exception{
//		7
//		6
//		1 2
//		2 3
//		1 5
//		5 2
//		5 6
//		4 7
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[f][b] = 1;
			arr[b][f] = 1;			
		}
		
		
		dfs(1);
		System.out.println(result);
	}
	private static void dfs(int start) {

		
		visited[start] = true;
		for(int i=1; i< arr.length; i++) {
			if(arr[start][i] == 1 && !visited[i]) {
				result++;
				
				dfs(i);
			}
		}
		
	}
}
