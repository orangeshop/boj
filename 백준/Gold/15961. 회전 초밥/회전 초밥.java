import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static int N, d, k, c;
    public static int[] arr;
    public static int answer;
    public static int[] vis;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(answer);
    }

    private static void solution() {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int cnt = 1;
        vis[c]++;
        for (int i = 0; i < N * 2; i++) {


            q.add(arr[i]);
            if (vis[arr[i]] == 0) {
                cnt++;
            }
            vis[arr[i]]++;



            if (q.size() < k) {
                continue;
            }

            if (q.size() > k) {
                int num = q.removeFirst();
                if (num != c) {

                    vis[num]--;
                    if(vis[num] == 0){
                        cnt--;
                    }
                }
            }

            if (q.size() == k) {
                answer = Math.max(answer, cnt);
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N * 2];
        vis = new int[d + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i + N] = arr[i];
        }
    }
}
