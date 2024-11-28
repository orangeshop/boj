import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] board1 = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };

	static char[][] board2 = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

	static char[][] board;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int answer = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		
		for(int i =0; i < N; i++) {
			String line = br.readLine();
			for(int k =0; k < M; k++) {
				board[i][k] = line.charAt(k);
			}
		}
		
		
		for(int i =0; i < N-7; i++) {
			for(int k =0; k < M-7; k++) {
				
				int chOne = 0;
				int chTwo = 0;	
				for(int ii =0; ii < 8; ii++) {
					for(int kk =0; kk < 8; kk++) {
						
//						System.out.println(board[is][ks] + " " + board1[ii][kk]);
						
						if(board[i + ii][k + kk] != board1[ii][kk]) chOne++;
						if(board[i + ii][k + kk] != board2[ii][kk]) chTwo++;
						
						
					}
					
				}
				
				answer = Math.min(answer, Math.min(chOne, chTwo));
				
			}
		}
		
		System.out.println(answer);
		
	}

}
