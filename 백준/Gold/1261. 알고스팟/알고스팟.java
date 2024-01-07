import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		String N_M = sc.nextLine();
		String[] N_M_arr = N_M.split(" ");
		int M = Integer.parseInt(N_M_arr[0]);
		int N = Integer.parseInt(N_M_arr[1]);
		int[][] board = new int[N][M];
		
		for(int i =0; i<N; i++) {
			String line = sc.nextLine();
			for(int k =0; k < M; k++) {
				board[i][k] = Character.getNumericValue(line.charAt(k));
			}
		}
		if(N-1 == 0 && M-1 == 0) {
			System.out.print(0);
			return;
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		PriorityQueue<Pair> Q = new PriorityQueue<>(Comparator.comparing(pair -> pair.count));
		boolean[][] vis = new boolean[N][M];
		
		vis[0][0] = true;
		Q.add(new Pair(0,0,0));
		int answer = 0;
		while(!Q.isEmpty()) {
			Pair cur = Q.poll();
			//System.out.println("x : " + cur.x + " y : " + cur.y + " cnt : " + cur.count);
			for(int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cur.x;
				int ny = dy[dir] + cur.y;
				//System.out.println("nx : " + nx + " ny : " + ny);
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
//				System.out.println("hi1");
				
				if(nx == N-1 && ny == M-1 ) {
					answer = cur.count;
					System.out.print(answer);
					return;
				}
				
				if(vis[nx][ny] == true) continue;
				
				
				
				if(board[nx][ny] == 0) {
					vis[nx][ny] = true;
					Q.add(new Pair(nx,ny, cur.count));
				}
				
				if(board[nx][ny] == 1){
//					System.out.println("hi");
					vis[nx][ny] = true;
					Q.add(new Pair(nx,ny, cur.count+1));
				}
				
			}
		}
		
//		for(int i =0; i<N; i++) {
//			
//			for(int k =0; k < M; k++) {
//				System.out.print(cnt[i][k] + " ");
//			}
//			System.out.println();
//		}
		

	}
	
	static class Pair{
		int x = 0;
		int y = 0;
		int count = 0;
		Pair(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
}