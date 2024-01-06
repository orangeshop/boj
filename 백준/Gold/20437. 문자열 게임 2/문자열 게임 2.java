import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int i =0; i<T; i++) {
			String str = sc.nextLine();
			int K = Integer.parseInt(sc.nextLine());
			if(K == 1) {
				System.out.println(1 + " " + 1);
				continue;
			}
			int answer1 = 0;
			int answer2 = 0;
//			int[] tmp = clac1(str, K);
			answer1 = clac(str,K);
			answer2 = clac1(str,K);
			if(answer1 == -1 && answer2 == -1) {
				System.out.println(-1);
			}
			else {
				System.out.println(answer1 + " " + answer2);
			}
			
			
		}
	}
	
	static int clac1(String str, int K) {
		int answer = -1;
		
		int[] alphabet = new int[30];
		
		for(int i=0; i < str.length(); i++) {
			alphabet[str.charAt(i)-97] += 1;
		}
		
		for(int i =0; i< str.length(); i++) {
			if(alphabet[str.charAt(i) - 'a'] < K) continue;
			int cnt = 1;
			for(int k = i+1; k< str.length(); k++) {
				if(str.charAt(i) == str.charAt(k)) cnt++;
				if(cnt == K) {
					answer = Math.max(answer, k - i + 1);
					break;
				}
			}
		}
		
		
		return answer;
	}
	
	static int clac(String str, int K) {
		int answer = 9999999;
		int[] alphabet = new int[30];
		
		for(int i=0; i < str.length(); i++) {
			alphabet[str.charAt(i)-97] += 1;
		}
		
		
		for(int i=0; i< str.length(); i++) {
			if(alphabet[str.charAt(i) - 'a'] < K) continue;
			int cnt = 1;
			for(int k =i+1; k< str.length(); k++) {
				if(str.charAt(i) == str.charAt(k)) cnt++;
				
				if(cnt == K) {
					answer = Math.min(answer, k - i);
				}
			}
		}
		
		
		if(answer == 9999999) {
			answer = -2;
		}
//		System.out.println(answer+1);
		return answer+1;
	}
	
	
	
}