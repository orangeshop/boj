

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    static String[] answer = {"koosaga", "cubelover"};

    static boolean[] dp = new boolean[1000001];

    static void Solution(){
        dp[1] = true;
        dp[2] = false;

        for(int i =1; i * i <= 1000000; i++){
            dp[i * i] = true;
        }

        for(int i = 2; i <= 1000000; i++){
            if(dp[i] == false){
                for(int j = 1; j * j + i <= 1000000; j++){
                    dp[j * j + i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{

        T = Integer.parseInt(br.readLine());

        Solution();

        for(int loop = 0; loop < T; loop++){
            int n = Integer.parseInt(br.readLine());
            if(dp[n]){
                System.out.println(answer[0]);
            }else{
                System.out.println(answer[1]);
            }
        }
    }
}
