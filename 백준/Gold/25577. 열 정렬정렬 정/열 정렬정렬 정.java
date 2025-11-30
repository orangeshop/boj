import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int[] tarr;

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tarr = arr.clone();
        Arrays.sort(tarr);

        for (int i = 0; i < N; i++) {
            map.put(tarr[i], i);
        }

        boolean[] vis = new boolean[N];
        int cnt = 0;

        for(int i =0; i < N; i++) {
            if(vis[i]) continue;
            cnt++;

            int cur = i;

            while (!vis[cur]) {
                vis[cur] = true;
                cur = map.get(arr[cur]);
            }
        }

        System.out.println(N-cnt);

    }
}
