

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] ls;
    static long answer;

    public static void main(String[] args) throws IOException {
        init();
//        see();
        solution();

        System.out.println(answer);
    }

    static int binary(int target, int left, int t) {
        int right = N;
        int mid = 0;


        while (right > left) {
            mid = (left + right) / 2;

            if(t == 0 && ls[mid] + target >= 0){
                right = mid;
            }else if(t == 1 && ls[mid] + target > 0){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }


    static void solution() {
        Arrays.sort(ls);

        for (int i = 0; i < N-2; i++) {
            for (int k = i + 1; k < N-1; k++) {

                int lower = binary(ls[i] + ls[k], k+1, 0);
                int upper = binary(ls[i] + ls[k], k+1, 1);

                answer += upper - lower;
            }
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        ls = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls[i] = Integer.parseInt(st.nextToken());
//            System.out.println(st.nextToken());
        }
    }

    static void see() {
        System.out.println(N);

        for (int i = 0; i < N; i++) {
            System.out.println("ls[i] = " + ls[i]);
        }
    }
}
