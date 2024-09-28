
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pair{
		int x,y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static int L;
	static int P;
	
	
	static int[] a = new int[1000005];
	static int[] b = new int[1000005];
	
	
	static PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p1, p2) -> p2.y - p1.y);
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			int ta = 0;
			int tb = 0;
			st = new StringTokenizer(br.readLine());
			ta = Integer.parseInt(st.nextToken());
			tb = Integer.parseInt(st.nextToken());
			a[ta] = ta;
			b[ta] = tb;
		}
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
//		System.out.println("L " + L + " P " + P);
		
		int start = 0;
		int ans = 0;
		
		for (int i =1; i <= L; i++) {
//			System.out.println("p " + P);
//			System.out.println("a " + a[i] + "b " + b[i]);
			
			if (P == L) {
				break;
			}
			
			
			if (P >= i) {
				if (a[i] != 0) {
//					System.out.println("!!!!! " + a[i] + b[i]);
					pq.add(new Pair(a[i], b[i]));
				}
			}
			
			if (P <= i) {
				if (pq.isEmpty()) break;
				Pair cur = pq.poll();
//				System.out.println("cur " + cur.x + "cur y " + cur.y);
				P += cur.y;
				ans++;
			}
		}
		
		if (P < L) {
			ans = -1;
		}
		
		System.out.println(ans);
		
		
	}
}



