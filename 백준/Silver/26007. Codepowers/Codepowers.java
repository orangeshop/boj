

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M,K,X;
    
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());    
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        

        for (int i = 0; i < N; i++) {
            X += Integer.parseInt(st.nextToken());

            if(X < K){
                arr[i+1] = arr[i] + 1;
            }else {
                arr[i+1] = arr[i];
            }
        }

        for(int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

//            System.out.println(arr[b] - arr[a]);

            bw.append(arr[b]-arr[a]+"");
            bw.append("\n");
        }

        bw.flush();
    }
}
