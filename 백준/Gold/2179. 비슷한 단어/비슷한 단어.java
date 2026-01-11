

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;

    static List<String> ls = new ArrayList<>();
    
    static int r = 0;
    static String ans1 = "";
    static String ans2 = "";
    
    static int calc(String str1, String str2){
        int result = 0;
        
        for(int i = 0; i < str1.length(); i++){
            if(i >= str2.length()) break;
            if(str1.charAt(i) == str2.charAt(i)){
                result++;
            }else{
                break;
            }
        }
        
        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            ls.add(str);
        }

        for (int i = 0; i < ls.size() - 1; i++) {
            for (int k = i + 1; k < ls.size(); k++) {
                int rr = calc(ls.get(i), ls.get(k));
                if(rr > r){
                    r = rr;
                    ans1 = ls.get(i);
                    ans2 = ls.get(k);
                }
                
            }
        }


        System.out.println(ans1);
        System.out.println(ans2);

    }
}


