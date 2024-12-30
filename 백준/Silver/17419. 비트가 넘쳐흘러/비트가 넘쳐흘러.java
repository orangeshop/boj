import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int answer;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void solution() {
        while (true) {
//            System.out.println(K);
            if (K == 0) break;


            K = K - (K & ((~K) + 1));
            answer++;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String tmp = st.nextToken();

        int cnt = 0;
        for (int i = tmp.length()-1; i >= 0; i--) {
            if (tmp.charAt(i) == '1') {
                K += Math.pow(2, cnt);
            }
            cnt++;
        }

//        System.out.println(K);
    }

}
