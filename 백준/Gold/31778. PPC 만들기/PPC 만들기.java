

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static String str;

    static int[] arr;
    static int[] pCount = new int[200005];
    static int[] cCount = new int[200005];

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        /*
         * 0 1 2 3 4 5 6 7
         * C C P C P P C P
         *
         *
         * 0 1 2 3 4 5 6 7
         * p p p c p c c c
         *
         * 0 1 3
         * 0 1 5
         * 0 1 6
         * 0 1 7
         *
         * 0 2 3
         * 0 2 5
         * 0 2 6
         * 0 2 7
         *
         * 0 4 5
         * 0 4 6
         * 0 4 7
         *
         * 1 2 3
         * 1 2 5
         * 1 2 6
         * 1 2 7
         *
         * 1 4 5
         * 1 4 6
         * 1 4 7
         *
         * 2 4 5
         * 2 4 6
         * 2 4 7
         */



        int l = 0;
        int r = N-1;
        while (l < r && K != 0) {
            while (l < N && arr[l] != 1) l++;
            while (r >= 0 && arr[r] != 0) r--;

            if (l >= r) break;

            K--;
            arr[l] = 0;
            arr[r] = 1;

        }


        pCount[0] = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] == 0) {
                pCount[i] = pCount[i - 1] + 1;
            } else {
                pCount[i] = pCount[i - 1];
            }
        }


        for (int i = N -1; i >= 0; i--) {
            if (arr[i] == 1) {
                cCount[i] = cCount[i + 1] + 1;
            } else {
                cCount[i] = cCount[i + 1];
            }
        }

        long ans = 0;

        for (int i = 1; i < N; i++) {
            if (arr[i] == 0) {
                ans += (long) pCount[i - 1] * cCount[i];
            }
        }

        System.out.println(ans);

    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        str = st.nextToken();

        arr = new int[str.length()];


        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'P') {
                arr[i] = 0;
            } else if (str.charAt(i) == 'C') {
                arr[i] = 1;
            }

        }

    }
}
