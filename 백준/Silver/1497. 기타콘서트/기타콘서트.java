import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int maxSongCount = 0;
    static int minGuitarCount = -1;


    static long[] arr;


    static void dfs(int depth, int cnt, long result) {

        int nowCnt = Long.bitCount(result);

        if(nowCnt > maxSongCount) {
            maxSongCount = nowCnt;
            minGuitarCount = cnt;
        }else if(nowCnt == maxSongCount) {
            if(minGuitarCount > cnt){
                minGuitarCount = cnt;
            }
        }

        if(depth == N) return;


        for(int i = depth; i < N; i++) {
            dfs(i + 1, cnt+1, result | arr[i]);
        }
    }


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String t = st.nextToken();

            arr[i] = calc(t);
        }



        dfs(0, 0, 0L);

        System.out.println(minGuitarCount);

    }

    private static long calc(String t) {
        long r = 0L;

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == 'Y') {
                r |= (1L << i);
            }
        }

        return r;
    }
}
