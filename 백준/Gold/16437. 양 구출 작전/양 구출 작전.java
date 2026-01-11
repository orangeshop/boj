

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static long[] amounts;
    static int[] parent;
    static int[] degree;;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        amounts = new long[N + 1];
        parent = new int[N + 1];
        degree = new int[N + 1];


        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t.equals("W")) {
                a *= -1;
            }
            amounts[i] = a;
            parent[i] = b;
            degree[b]++;

        }

        ArrayDeque<Integer> q = new ArrayDeque();

        for (int i = 2; i <= N; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();

            if(cur == 1) continue;

            int p = parent[cur];

            if(amounts[cur] > 0){
                amounts[p] += amounts[cur];
            }

            degree[p]--;
            if(degree[p] == 0){
                q.add(p);
            }


        }

        System.out.println(amounts[1]);
    }
}
