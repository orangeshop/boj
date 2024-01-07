import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		String N_M = sc.nextLine();
		String[] tmp_N_M = N_M.split(" ");
		int N = Integer.parseInt(tmp_N_M[0]);
		int M = Integer.parseInt(tmp_N_M[1]);
		
		
		List<Pair>[] adj = new ArrayList[N+1];
		
		for(int i =0; i<= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		
		
		for(int i =0; i< M; i++) {
			String scan = sc.nextLine();
			String scan_tmp[] = scan.split(" ");
			
			int A = Integer.parseInt(scan_tmp[0]);
			int B = Integer.parseInt(scan_tmp[1]);
			int C = Integer.parseInt(scan_tmp[2]);
//			System.out.println("A :" + A + "B : " + B + "C : " + C);
			
			Pair pair = new Pair(C,B);
			
			adj[A].add(pair);
			Pair pair_r = new Pair(C,A);
			adj[B].add(pair_r);
			
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.x));
		
		int d[] = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		d[1] = 0;
		
		
		pq.add(new Pair(d[1], 1));
		
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			if(d[cur.y] != cur.x) continue;
			for(Pair nxt : adj[cur.y]) {
				if(d[nxt.y] <= d[cur.y] + nxt.x) continue;
				d[nxt.y] = d[cur.y] + nxt.x;
				pq.add(new Pair(d[nxt.y], nxt.y));
			}
		}
		
		System.out.println(d[N]);
		
	}
	
	static class Pair {
		int x = 0;
		int y = 0;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}