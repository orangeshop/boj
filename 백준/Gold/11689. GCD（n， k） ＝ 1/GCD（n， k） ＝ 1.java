import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long N;

    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        long pi = N;

        for(long p = 2; p *p <= N; p++){
            if(N % p == 0){
                pi -= (pi / p);
                while (N % p == 0) {
                    N /= p;
                }
            }
        }

        if (N > 1) {
            pi = pi - (pi / N);
        }

        System.out.println(pi);

    }
}
