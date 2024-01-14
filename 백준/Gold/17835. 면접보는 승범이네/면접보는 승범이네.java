import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N_M_K = br.readLine();
		String N_M_K_arr[] = N_M_K.split(" ");
		
		int n = Integer.parseInt(N_M_K_arr[0]);
		int m = Integer.parseInt(N_M_K_arr[1]);
		int k = Integer.parseInt(N_M_K_arr[2]);
		
		
		
//		int n = Integer.parseInt(br.readLine());
//		int m = Integer.parseInt(br.readLine());
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
//			adj[a].add(new Pair(w,b));
			adj[b].add(new Pair(w,a));
		}
		
		boolean interview_place[] = new boolean[n+1];
		
		String ip = br.readLine();
		String ip_arr[] = ip.split(" ");
		
		for(int i=0; i< k; i++) {
			interview_place[Integer.parseInt(ip_arr[i])] = true;
		}
		
//		for(int i=0; i<= k; i++) {
//			System.out.println(interview_place[i]);
//		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair -> Pair.weight));
		
		long d[] = new long[n+1];
		Arrays.fill(d, Long.MAX_VALUE);
		
		for(int i = 1 ; i <= n; i++) {
			if(interview_place[i] != true) continue;
			d[i] = 0;
			pq.add(new Pair(d[i],i));
			
		}
		
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			if(d[cur.dis] < cur.weight) continue;
				
			for(Pair nxt : adj[cur.dis]) {
				if(d[nxt.dis] <= d[cur.dis] + nxt.weight) continue;
				d[nxt.dis] = d[cur.dis] + nxt.weight;
				pq.add(new Pair(d[nxt.dis], nxt.dis));
					
			}
		}
		
		int idx = 0;
		long answer = 0;
		
		for(int j =1; j<=n; j++) {
//			System.out.println(d[j]);
			if(answer < d[j]) {
				idx = j;
				answer = d[j];
			}
		}
		
		System.out.println(idx);
		System.out.println(answer);
		
		
		
		
		
		
		
	}
	
	static class answer_st{
		int target = 0;
		long answer = 0;
		
		answer_st(int target, long answer){
			this.target = target;
			this.answer = answer;
		}
		
		public int getTarget() {
			return target;
		}
		
		public long getAnswer() {
			return answer;
		}
		
	}
	
	static class Pair{
		long weight = 0;
		int dis = 0;
		
		Pair(long weight, int dis){
			this.weight = weight;
			this.dis = dis;
		}
	}
}