import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws Exception{
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		List<Integer> result = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			int cnt = 1;
			int answer = 0;
			
			int N = Integer.parseInt(sc.nextLine());
			int[][] board = new int[N][N];
			int[][] vis = new int[N][N];
			if(N == 0) {
				break;
			}
			
			for(int i =0; i< N; i++) {
				String num = sc.nextLine();
				String[] num_arr = num.split(" ");
				for(int k =0; k<N; k++) {
					board[i][k] = Integer.parseInt(num_arr[k]);
					vis[i][k] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<Pair> Q = new PriorityQueue<>(Comparator.comparing(Pair -> Pair.count));
			Q.add(new Pair(0,0,board[0][0]));
			vis[0][0] = 0;
			
			while(!Q.isEmpty()) {
				Pair cur = Q.poll();
				if(cur.x == N-1 && cur.y == N-1) {
					break;
				}
//				System.out.println("cur x : " + cur.x + "cur.y : " + cur.y + "count : " + cur.count);
				for(int dir =0; dir<4; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

					if(vis[nx][ny] > cur.count + board[nx][ny]) {
						Q.add(new Pair(nx,ny, cur.count + board[nx][ny]));
						vis[nx][ny] = cur.count + board[nx][ny];
					}
				}
			}
			result.add((vis[N-1][N-1]));
		}
		
		for(int i =0; i<result.size(); i++) {
			System.out.println("Problem " + (i+1) + ": " + result.get(i) );
		}
	}
	
	static class Pair{
		int x =0;
		int y =0;
		int count = 0;
		Pair(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
		
	}
	
}