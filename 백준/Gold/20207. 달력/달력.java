import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int T = Integer.parseInt(sc.nextLine());
		int[] board = new int[370];
		for(int i =0; i<T; i++) {
			String tmp = sc.nextLine();
			String[] arr = tmp.split(" ");
			int S = Integer.parseInt(arr[0]);
			int E = Integer.parseInt(arr[1]);
			
			for(int k =S; k <= E; k++) {
				board[k] += 1;
			}
		}
		int hieght= 0;
		int width = 0;
		for(int i = 1; i < 366; i++) {
//			System.out.println(i + " " + board[i]);
			if(board[i] == 0) {
				answer += hieght * width;
				
				hieght= 0;
				width = 0;
			}
			else {
				hieght = Math.max(hieght, board[i]);
				width += 1;
			}
		}
		
		
		System.out.print(answer + (hieght* width));
		
	}
}