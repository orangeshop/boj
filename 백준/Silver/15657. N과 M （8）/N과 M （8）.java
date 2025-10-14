import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] arrays = new int[M];
        boolean[] vis = new boolean[N];
        dfs(0, arrays, -1);

        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int[] arrays, int v) {
        if(depth == M) {
            String str = "";
            for(int i = 0; i < M; i++) {
                str += arrays[i] + " ";
            }
            sb.append(str.trim());
            sb.append("\n");
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < v) continue;
            arrays[depth] = arr[i];
            dfs(depth + 1, arrays, arr[i]);
            arrays[depth] = 0;

        }
    }
}
