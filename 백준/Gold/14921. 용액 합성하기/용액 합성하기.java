

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N;
    
    static long[] arr;

    static long ans = Long.MAX_VALUE;
    static long answer = 0;

    
    public static void main(String[] args) throws IOException {
        init();
        solution();

        System.out.println(answer);
    }

    private static void solution() {

        for(int i =0; i < N-1; i++){

            int left = i+1;
            int right = N -1;

            while (left <= right) {
                int mid = (left + right) / 2;
                long val = arr[i] + arr[mid];
                if (ans > Math.abs(val)) {
                    ans = Math.abs(val);
                    answer = val;
                }

                if (val < 0){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }



        }

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
