
import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String N_M_X = sc.nextLine();
		String[] N_M_X_arr = N_M_X.split(" ");
		int answer = 0;
		int N = Integer.parseInt(N_M_X_arr[0]);
		int M = Integer.parseInt(N_M_X_arr[1]);
		int X = Integer.parseInt(N_M_X_arr[2]);

		List<Pair> adj[] = new ArrayList[N + 1];
		List<Pair> r_adj[] = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<Pair>();
			r_adj[i] = new ArrayList<Pair>();
		}

		for (int i = 0; i < M; i++) {
			String scan = sc.nextLine();
			String[] scan_arr = scan.split(" ");

			int A = Integer.parseInt(scan_arr[0]);
			int B = Integer.parseInt(scan_arr[1]);
			int weight = Integer.parseInt(scan_arr[2]);

			adj[A].add(new Pair(weight, B));
			r_adj[B].add(new Pair(weight, A));
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair -> Pair.weight));

		pq.add(new Pair(0, X));
		int d[] = new int[N + 1];

		Arrays.fill(d, Integer.MAX_VALUE);
		d[X] = 0;
		while (!pq.isEmpty()) {
			Pair cur = pq.poll();
			if (d[cur.dis] != cur.weight)
				continue;
//				System.out.println("cur y : " + cur.dis + " cur weight : " + cur.weight);
			for (Pair nxt : adj[cur.dis]) {
				if (d[nxt.dis] <= d[cur.dis] + nxt.weight)
					continue;
//					System.out.println("dis : " + cur.dis + " weight : " + cur.weight + " nxt.weight : " + nxt.weight + " nxt.dis : " + nxt.dis);
				d[nxt.dis] = d[cur.dis] + nxt.weight;

				pq.add(new Pair(d[nxt.dis], nxt.dis));
			}

		}

		pq.add(new Pair(0, X));
		int d_r[] = new int[N + 1];

		Arrays.fill(d_r, Integer.MAX_VALUE);
		d_r[X] = 0;
		while (!pq.isEmpty()) {
			Pair cur = pq.poll();
			if (d_r[cur.dis] != cur.weight)
				continue;
//				System.out.println("cur y : " + cur.dis + " cur weight : " + cur.weight);
			for (Pair nxt : r_adj[cur.dis]) {
				if (d_r[nxt.dis] <= d_r[cur.dis] + nxt.weight)
					continue;
//					System.out.println("r dis : " + cur.dis + " r weight : " + cur.weight + " r nxt.weight : " + nxt.weight + " r nxt.dis : " + nxt.dis);
				d_r[nxt.dis] = d_r[cur.dis] + nxt.weight;

				pq.add(new Pair(d_r[nxt.dis], nxt.dis));
			}

		}

		for (int k = 1; k < N + 1; k++) {
//				System.out.println("d" + k + " " + d[k] + " " + d_r[k]);
			answer = Math.max(answer, (d[k] + d_r[k]));
		}

		System.out.println(answer);

	}

	static class Pair {
		int dis = 0;
		int weight = 0;

		Pair(int weight, int dis) {
			this.weight = weight;
			this.dis = dis;
		}
	}

}