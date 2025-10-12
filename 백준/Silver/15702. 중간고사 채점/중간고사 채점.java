import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int N, M;
    static int[] s;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Pair> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream(""));
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        s = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());

            int r = 0;

            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("O")) {
                    r += s[j];
                }
            }
            ls.add(new Pair(t, r));
        }

        ls.sort((o1, o2) -> {
            if(o1.y == o2.y){
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        });

        for(Pair x : ls){
            System.out.println(x.x + " " + x.y);
            break;
        }

    }


}
