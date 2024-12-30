import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    
    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(sb);
    }

    private static void solution() {
        int cnt = 0;

        for(int i =0; i < 7; i++){
            if((N & (1 << i)) > 0) cnt++;
        }

        sb.append(cnt);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }
}
