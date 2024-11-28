import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayDeque<Pair> Q = new ArrayDeque<>();

	static int N;
	static int M;

	static char[][] board;
	static int[][] cnt;
	static boolean[][] vis;

	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		vis = new boolean[N][M];
		cnt = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int k = 0; k < M; k++) {
				board[i][k] = line.charAt(k);
			}
		}
		
		
		Q.add(new Pair(0,0));
		vis[0][0] = true;
		
		while(!Q.isEmpty()) {
			Pair cur = Q.removeFirst();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(vis[nx][ny] == true || board[nx][ny] == '0') continue;
				
				cnt[nx][ny] = cnt[cur.x][cur.y] + 1;
				vis[nx][ny] = true;
				Q.add(new Pair(nx, ny));
			}
		}
		
		System.out.print(cnt[N-1][M-1] + 1);
		

	}

	static void See() {
		System.out.println(N + " " + M);

		for (int i = 0; i < N; i++) {
			for (int k = 0; k < M; k++) {
				System.out.print(board[i][k] + " ");
			}
			System.out.println();
		}
	}

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
