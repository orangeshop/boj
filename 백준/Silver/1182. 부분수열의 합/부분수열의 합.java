import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, S;

    static int[] arr;

    static int answer;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    static void dfs(int depth, int val){
        if(depth == N){
            return;
        }

        if (val + arr[depth] == S){
            answer++;
        }

        dfs(depth+1, val + arr[depth]);
        dfs(depth+1, val);
    }

    static int solution(){
        dfs(0, 0);
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
