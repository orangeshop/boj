

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static int[] A = new int[4004];
    static int[] B = new int[4004];
    static int[] C = new int[4004];
    static int[] D = new int[4004];

    static long[] AB;
    static long[] CD;
    private static long answer;


    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void solution() {
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                AB[idx] = ((long) (A[i] + B[k]));
                CD[idx] = ((long) (C[i] + D[k]));
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        for (Long l : AB) {
            answer += upper(-l) - lower(-l);
        }

    }

    static int lower(long target) {
        int l = 0;
        int r = CD.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (CD[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    static int upper(long target) {
        int l = 0;
        int r = CD.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (CD[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        AB = new long[N * N];
        CD = new long[N * N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            A[i] = a;
            B[i] = b;
            C[i] = c;
            D[i] = d;
        }

    }
}
