

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;

    static int answer = Integer.MAX_VALUE;

    static int[] dx = {1, -1, 2};

    static boolean[][] vis = new boolean[2][500005];
    static ArrayDeque<Integer> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        answer = solution();
        System.out.println(answer);
    }

    static int solution() {
        if(N == M) return 0;

        Q.add(N);
        vis[0][N] = true;

        int time = 0;
        int size = 0;
        int flag = 0;

        while (!Q.isEmpty()) {
            size = Q.size();
            time++;

            flag = time % 2;

            M += time;
            if(M >= 500001) return -1;

            for(int i =0; i < size; i++) {
                int cur = Q.poll();

                for(int dir = 0; dir < 3; dir++){
                    int nx;
                    if(dir == 2){
                        nx = cur * dx[dir];
                    }else{
                        nx = cur + dx[dir];
                    }

                    if(nx < 0 || nx >= 500001) continue;
                    if(vis[flag][nx] == true) continue;

                    Q.add(nx);
                    vis[flag][nx] = true;

                }
            }

            if(vis[flag][M] == true) return time;
        }

        return -1;

    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }
}
