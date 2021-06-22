package DFSBFS;

import java.util.*;
public class DFSBFS {
	static boolean[] visited;
	static int[][] graph;
	static String bfs= "";
	static String dfs= "";
	
	public static void main(String[]args) {
		Scanner sc =new Scanner(System.in);
		int node = sc.nextInt();
		int rel = sc.nextInt();
		int start = sc.nextInt();
		graph = new int[node+1][node+1];
		visited = new boolean[node+1];

		for(int i=0; i<rel ; i++) {
			int a = sc.nextInt();
			int d = sc.nextInt();
			graph[a][d] = 1;
			graph[d][a] = 1;
			
		}
		for(int i=0; i<graph.length; i++) {
			String temp = "";
			for(int j=0; j<graph[0].length; j++) {
				temp += graph[i][j]+" ";
			}
			System.out.println(temp);
		}
		visited[start] = true;
		 dfs(start);
		System.out.println(dfs);
		
//		graph = new int[node+1][node+1];
		visited = new boolean[node+1];
		bfs(start);
		System.out.println(bfs);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int p =  q.poll();
			bfs+= p+" ";
			for(int i=0; i<graph[p].length; i++) {
				if(!visited[i] && graph[p][i] ==1) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}

	private static void dfs(int start) {
		dfs += start+" ";
//		System.out.println("dfs: "+start);
		for(int i=0; i<graph[start].length; i++) {
			if(!visited[i] && graph[start][i]== 1) {
				visited[i]= true;
				dfs(i);
			}
		}
		return;
	}
	
}
