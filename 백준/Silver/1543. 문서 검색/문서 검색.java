import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int answer = 0;
		for(int i =0; i<str1.length() - str2.length()+1; i++) {
			String tmp = str1.substring(i, i+str2.length());
			if(tmp.equals(str2)) {
				i += str2.length()-1;
				answer += 1;
			}
		}
		
		System.out.println(answer);
	}
}