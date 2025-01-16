

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, answer;

    static Pair[] arr;


    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void solution() {
        dfs(0);
    }

    private static void dfs(int depth) {


        if (depth >= N) {

            int result = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i].x <= 0) result++;
            }
            answer = Math.max(answer, result);

            return;
        }

        if(arr[depth].x <= 0){
            dfs(depth+1);
            return;
        }
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (arr[i].x <= 0 || i == depth) continue;

            arr[i].x -= arr[depth].y;
            arr[depth].x -= arr[i].y;
            flag = true;
            dfs(depth + 1);
            arr[depth].x += arr[i].y;
            arr[i].x += arr[depth].y;

        }

        if(!flag){
            dfs(depth+1);
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new Pair[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Pair(0, 0);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i].x = Integer.parseInt(st.nextToken());
            arr[i].y = Integer.parseInt(st.nextToken());
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }
}
