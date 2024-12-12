

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, S;

    static int[] arr;

    static Map<Long, Long> mp = new HashMap<>();

    static long answer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    static void leftDfs(long sum, int s, int e) {

        if (s == e) {
            mp.put(sum, mp.getOrDefault(sum, 0L) + 1);
            return;
        }

        leftDfs(sum + arr[s], s + 1, e);
        leftDfs(sum, s + 1, e);

    }

    static void rightDfs(long sum, int s, int e) {

        if (s == e) {
            if (mp.getOrDefault(S - sum, 0L) > 0) {
                answer += mp.getOrDefault(S - sum, 0L);
            } else if (sum == S) {
                answer++;
            }

            return;
        }

        rightDfs(sum + arr[s], s + 1, e);
        rightDfs(sum, s + 1, e);
    }

    static long solution() {


        leftDfs(0, 0, N / 2);
        rightDfs(0, N / 2, N);

        if (S == 0) answer--;
        return answer;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
