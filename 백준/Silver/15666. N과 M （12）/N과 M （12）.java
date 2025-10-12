import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] arr;

    static Set<String> s = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] array = new int[N];
        dfs(0, array, 0);
    }

    private static void dfs(int depth, int[] array, int k) {
        if (depth == M) {
            String str = "";
            for (int i = 0; i < M; i++) {
                str += array[i] + " ";
            }
            String aa = str.trim();

            if(s.contains(aa)){
                return;
            }
            s.add(aa);

            System.out.println(aa);

            return;
        }

        for (int i = k; i < N; i++) {
            array[depth] = arr[i];
            dfs(depth + 1, array, i);
            array[depth] = 0;
        }
    }
}
