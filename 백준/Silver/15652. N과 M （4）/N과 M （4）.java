

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        arr[0] = 1;
        dfs(1);
    }

    private static void dfs(int depth) {
        if(depth == M+1) {
            for(int i =1; i <= M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = arr[depth-1]; i<=N; i++) {
            arr[depth] = i;
            dfs(depth+1);
            arr[depth] = 0;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }
}

