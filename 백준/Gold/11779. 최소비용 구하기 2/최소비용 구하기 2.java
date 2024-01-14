

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String N_M = br.readLine();
//		String N_M_arr[] = N_M.split(" ");
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
//		System.out.println(n + " " + m);
		List<Pair> adj[] = new ArrayList[n+1];
		
		for(int i = 0; i< n+1; i++) {
			adj[i] = new ArrayList<Pair>();
		}
		
		for(int i =0; i < m; i++) {
			String A_B_W = br.readLine();
			String arr[] = A_B_W.split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int w = Integer.parseInt(arr[2]);
//			System.out.println(arr[0]);
			adj[a].add(new Pair(w,b));
//			adj[b].add(new Pair(w,a));
		}
		
		String A_B = br.readLine();
		String A_B_arr[] = A_B.split(" ");
		
		int A = Integer.parseInt(A_B_arr[0]);
		int B = Integer.parseInt(A_B_arr[1]);
		
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair -> Pair.weight));
		int d[] = new int[n+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[A] = 0;
		int pre[] = new int[n+1];
		pq.add(new Pair(d[A],A));
		
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			if(d[cur.dis] != cur.weight) continue;
			
			for(Pair nxt : adj[cur.dis]) {
				if(d[nxt.dis] <= d[cur.dis] + nxt.weight) continue;
				d[nxt.dis] = d[cur.dis] + nxt.weight;
				pq.add(new Pair(d[nxt.dis], nxt.dis));
				pre[nxt.dis] = cur.dis;
			}
		}
		
//		for(int i =1; i < n+1; i++) {
//			System.out.println(i + " : " + d[i] + " pre : " + pre[i]);
//		}
		
		System.out.println(d[B]);
		List<Integer> path = new ArrayList<>();
		int cur = B;
		while(cur != A) {
			path.add(cur);
			cur = pre[cur];
		}
		path.add(cur);
		Collections.reverse(path);
		System.out.println(path.size());
		
		for(int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i) + " ");
		}
		
		
		
	}
	
	static class Pair{
		int weight = 0;
		int dis = 0;
		
		Pair(int weight, int dis){
			this.weight = weight;
			this.dis = dis;
		}
	}
}