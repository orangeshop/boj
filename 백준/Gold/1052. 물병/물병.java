import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,K, answer;
    
    public static void main(String[] args) throws IOException {
        init();
        solution();

        System.out.println(answer);
    }

    private static void solution() {
        while (Integer.bitCount(N) > K){
            answer += N & (-N);
            N += N & (-N);
        }
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
