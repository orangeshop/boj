import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N_M_R = br.readLine();
		String[] N_M_R_arr = N_M_R.split(" ");
		int n = Integer.parseInt(N_M_R_arr[0]);
		int m = Integer.parseInt(N_M_R_arr[1]);
		int r = Integer.parseInt(N_M_R_arr[2]);
		
		String Item = br.readLine();
		String[] Item_arr = Item.split(" ");
		int Int_Item_Arr[] = new int[Item_arr.length];
		
		for(int i =0; i< Item_arr.length; i++) {
			Int_Item_Arr[i] = Integer.parseInt(Item_arr[i]);
		}
		
		List<Pair> adj[] = new ArrayList[n+1];
		
		for(int i =0; i < n+1; i++) {
			adj[i] = new ArrayList<Pair>();
		}
		
		for(int i =0; i<r; i++) {
			String A_B_I = br.readLine();
			String[] A_B_I_Arr = A_B_I.split(" ");
			int A = Integer.parseInt(A_B_I_Arr[0]);
			int B = Integer.parseInt(A_B_I_Arr[1]);
			int I = Integer.parseInt(A_B_I_Arr[2]);
			adj[A].add(new Pair(I, B));
			adj[B].add(new Pair(I, A));
			
		}
		

		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair -> Pair.weight));
		int answer = Integer.MIN_VALUE;
		for(int i =1; i<= n; i++) {
			int d[] = new int[n+1];
			int result = 0;
			boolean check[] = new boolean[n+1];
			Arrays.fill(d, Integer.MAX_VALUE);
			d[i] = 0;
			pq.add(new Pair(0,i));
			
			
			while(!pq.isEmpty()) {
				Pair cur = pq.poll();
				
				if(cur.weight > m) continue;
				if(d[cur.dis] != cur.weight) continue;
				if(check[cur.dis] == true) continue;
				check[cur.dis] = true;
//				System.out.println("cur dis : " + cur.dis + " cur weight : " + cur.weight);
				result += Int_Item_Arr[cur.dis-1];
				for(Pair nxt : adj[cur.dis]) {
					if(check[cur.dis] == true & d[nxt.dis] <= d[cur.dis] + nxt.weight) continue;
					d[nxt.dis] = d[cur.dis] + nxt.weight;
					
					pq.add(new Pair(d[nxt.dis], nxt.dis));
				}
			}
//			System.out.println();
			answer = Math.max(answer, result);

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