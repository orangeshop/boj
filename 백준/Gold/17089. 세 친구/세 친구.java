

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static List<Integer>[] adj;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(0, 1, new int[3]);


        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }

    static void dfs(int depth, int cnt, int[] arr) {

//        if(depth == 1){
//            if(adj[arr[0]].size() < 2){
//                return;
//            }
//        }

        if (depth == 2) {
            if (!adj[arr[0]].contains(arr[1])) {
                return;
            }
        }

        if (depth == 3) {
//            System.out.println(Arrays.toString(arr));

            if (!adj[arr[0]].contains(arr[2]) || !adj[arr[1]].contains(arr[2])) {
                return;
            }

            ans = Math.min(calc(arr), ans);

//            System.out.println(ans);
            return;
        }

        for (int i = cnt; i <= N; i++) {
            if(adj[i].size() < 2) continue;
            arr[depth] = i;
            dfs(depth + 1, i + 1, arr);
            arr[depth] = 0;
        }
    }

    static int calc(int[] arr) {

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

//        if (!adj[a].contains(b) || !adj[a].contains(c)) {
//            return Integer.MAX_VALUE;
//        }
//
//        if (!adj[b].contains(a) || !adj[b].contains(c)) {
//            return Integer.MAX_VALUE;
//        }
//
//        if (!adj[c].contains(a) || !adj[c].contains(b)) {
//            return Integer.MAX_VALUE;
//        }

        int aCnt = adj[a].size();
        int bCnt = adj[b].size();
        int cCnt = adj[c].size();

//        for (int i = 0; i < adj[a].size(); i++) {
//            if (adj[a].get(i) == b || adj[a].get(i) == c) {
//                continue;
//            } else {
//                aCnt++;
//            }
//        }

        if(adj[a].contains(b)) {
            aCnt--;
        }
        if(adj[a].contains(c)) {
            aCnt--;
        }

        if(adj[b].contains(a)) {
            bCnt--;
        }
        if(adj[b].contains(c)) {
            bCnt--;
        }

        if(adj[c].contains(a)) {
            cCnt--;
        }
        if(adj[c].contains(b)) {
            cCnt--;
        }


//        for (int i = 0; i < adj[b].size(); i++) {
//            if (adj[b].get(i) == a || adj[b].get(i) == c) {
//                continue;
//            } else {
//                bCnt++;
//            }
//        }

//        for (int i = 0; i < adj[c].size(); i++) {
//            if (adj[c].get(i) == b || adj[c].get(i) == a) {
//                continue;
//            } else {
//                cCnt++;
//            }
//        }

//        System.out.println(aCnt + " " + bCnt + " " + cCnt);
//        System.out.println(aCnt + bCnt + cCnt);

        return aCnt + bCnt + cCnt;
    }
}
