import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

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
        dfs(0, arrays, -1);
    }

    private static void dfs(int depth, int[] arrays, int v) {
        if(depth == M) {
//            System.out.println(Arrays.toString(arrays));
            for(int i = 0; i < M; i++) {
                System.out.print(arrays[i]);
                if(i != M-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(v >= arr[i]) continue;
            arrays[depth] = arr[i];
            dfs(depth + 1, arrays, arr[i]);
            arrays[depth] = 0;
        }
    }
}
