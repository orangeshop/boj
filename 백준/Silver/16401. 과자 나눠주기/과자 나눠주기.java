

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N;
	
	static int[] arr = new int[1000005];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for (int i =0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
		
		int left = 1;
		int right = Integer.MAX_VALUE-1;
		
//		for (int i =0; i < N; i++) {
////			left = Math.min(left, arr[i]);
//			right = Math.max(right, arr[i]);
//		}
		
		int answer = 0;
		while(left <= right) {
//			System.out.println(left + " " + right);
			
			int mid = (left + right) / 2;
			
			int value = 0;
			
			for (int i = 0; i < N; i++) {
//				if (arr[i] < mid) continue;
				
				value += arr[i]/mid;
				
			}
			
			if(value >= M) {
				answer = Math.max(answer, mid);
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
}

