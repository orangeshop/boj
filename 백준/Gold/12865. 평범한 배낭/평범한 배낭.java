import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;
import java.math.*;


public class Main {
	
	static int N;
	static int M;
	
	static int[] dp = new int[1000001]; 
	
	static int[] w = new int[1000001]; 
	static int[] v = new int[1000001]; 
	
	
//	public int go(int idx, int val) {
//		
//	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		
		for (int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
			
			for (int j = M; j >= w[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
			}
		}
		
		int ans = 0;
		
		for (int i =0; i <= M; i++) {
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
		
	}
}

