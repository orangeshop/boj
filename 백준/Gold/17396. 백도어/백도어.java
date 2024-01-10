import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N_M = br.readLine();
		String[] N_M_arr = N_M.split(" ");
		
		String ward = br.readLine();
		String[] ward_arr = ward.split(" ");

		
		long answer = -1;
		int N = Integer.parseInt(N_M_arr[0]);
		int M = Integer.parseInt(N_M_arr[1]);


		List<Pair> adj[] = new ArrayList[N + 1];
		
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<Pair>();
			
		}

		for (int i = 0; i < M; i++) {
			String scan = br.readLine();
			String[] scan_arr = scan.split(" ");

			int A = Integer.parseInt(scan_arr[0]);
			int B = Integer.parseInt(scan_arr[1]);
			int weight = Integer.parseInt(scan_arr[2]);
			
			adj[A].add(new Pair(weight, B));
			adj[B].add(new Pair(weight, A));
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair -> Pair.weight));

		pq.add(new Pair(0, 0));
		
		long d[] = new long[N + 1];
		boolean vis[] = new boolean[N+1];
		
		Arrays.fill(d, Long.MAX_VALUE);
		d[0] = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			Pair cur = pq.poll();
			if(cnt > N) break;
			if(cur.dis == N-1) {
				break;
			}
			if(vis[cur.dis] == true) continue;
			vis[cur.dis] = true;
			
			if(d[cur.dis] < cur.weight) continue;
			
//			System.out.println("cur dis" + cur.dis + " cur weight : " + cur.weight);
			
			for (Pair nxt : adj[cur.dis]) {
				if (vis[nxt.dis] == true) continue;
				if (nxt.dis != N-1 && ward_arr[nxt.dis].equals("1")) continue;
				if (d[nxt.dis] > d[cur.dis] + nxt.weight) {
				
					d[nxt.dis] = d[cur.dis] + nxt.weight;
				
					pq.add(new Pair(d[nxt.dis], nxt.dis));
				}
			}
			cnt++;
		}
		if(d[N-1] == Long.MAX_VALUE) {
			System.out.println(answer);
		}
		else {
			answer = d[N-1];
			System.out.println(answer);
		}
		return;
		
	}

	static class Pair {
		int dis = 0;
		long weight = 0;

		Pair(long weight, int dis) {
			this.weight = weight;
			this.dis = dis;
		}
	}

}