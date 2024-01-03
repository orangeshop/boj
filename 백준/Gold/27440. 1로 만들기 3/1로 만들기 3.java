import java.util.*;
import java.math.*;


public class Main {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		
		long num = Long.parseLong(tmp);
		
		ArrayList<Long> vis = new ArrayList();
		

		
		Queue<Pair> Q = new LinkedList<>();
		
		Pair pair = new Pair(num, 0);
		
		Q.add(pair);
		
		HashMap<Long, Integer> map = new HashMap<>();
		
		while(!Q.isEmpty()) {
			Pair cur = Q.poll();
//			System.out.println(cur.num + " " + vis.size());
			if(cur.num == 1) {
//				System.out.println("out");
				System.out.println(cur.cnt);
				break;
			}
			
			
			
			
			
			if(map.containsKey(cur.num) == false) {
				if(cur.num % 3 == 0) {
//					System.out.println("%3");
					long div = (cur.num / 3);
					Pair pair1 = new Pair(div, cur.cnt+1);
					Q.add(pair1);
//					vis.add(div);
				}
				
				if(cur.num % 2 == 0) {
//					System.out.println("%2");
					long div = (cur.num / 2);
					Pair pair1 = new Pair(div, cur.cnt+1);
					Q.add(pair1);
//					vis.add(div);
				}
				
				long miuse = (cur.num - 1);
				Pair pair1 = new Pair(miuse, cur.cnt+1);
				Q.add(pair1);
				
				map.put(cur.num, 0);
			}
		}
		
		
//		System.out.println("end");
		
	}	
	
	static class Pair{
		
		long num;
		long cnt;
		
		Pair(long num, long cnt){
			this.num = num;
			this.cnt = cnt;
		}
		
	}
	
}