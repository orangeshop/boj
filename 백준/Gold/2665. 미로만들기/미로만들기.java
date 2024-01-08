import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws Exception{
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair -> Pair.count));
		
		int N = Integer.parseInt(sc.nextLine());
		int[][] board = new int[N][N];
		boolean[][] vis = new boolean[N][N];
		
		for(int i =0; i < N; i++) {
			String str = sc.nextLine();
			for(int k =0; k< N; k++) {
				board[i][k] = Character.getNumericValue(str.charAt(k));
				vis[i][k] = false;
			}
		}
		
//		for(int i =0; i < N; i++) {
//			
//			for(int k =0; k< N; k++) {
//				System.out.print(board[i][k] + " ");
//			}
//			System.out.println();
//		}
//		
		pq.add(new Pair(0,0,0));
		vis[0][0] = true;
		
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
//			System.out.println("cur x : " + cur.x + "cur Y : " + cur.y + "count : " + cur.count);
			if(cur.x == N-1 && cur.y == N-1) {
				answer = cur.count;
				break;
			}
			
			for(int dir =0; dir<4; dir++) {
				
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(vis[nx][ny] == true) continue;
//				System.out.println("in 1");
				if(board[nx][ny] == 1) {
//					System.out.println("in 1");
					pq.add(new Pair(nx,ny, cur.count));
					vis[nx][ny] = true;
				}
				else if(board[nx][ny] == 0){
//					System.out.println("in 0");
					pq.add(new Pair(nx,ny, cur.count+1));
					vis[nx][ny] = true;
				}
				
			}
		}
		
		System.out.println(answer);
		
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