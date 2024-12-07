

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static long[] ls;
    static long min = Long.MAX_VALUE;
    static long answerF = Long.MAX_VALUE;
    static long answerS = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        solution();

        System.out.println(answerF + " " + answerS);
    }

    static void solution() {
        Arrays.sort(ls);

        for (int i = 0; i < N-1; i++) {

            int left = i+1;
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                long sum = Math.abs(ls[i] + ls[mid]);

                if(sum < min){
                    min = sum;
                    answerF = ls[i];
                    answerS = ls[mid];
                }

                if(ls[i] + ls[mid] < 0){
                    left = mid + 1;
                }else{
                    right = mid - 1 ;
                }
            }
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        ls = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls[i] = Integer.parseInt(st.nextToken());
        }
    }
}
