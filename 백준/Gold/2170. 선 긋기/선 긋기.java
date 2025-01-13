
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static long answer;
    static List<Pair> ls = new ArrayList<>();

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void solution() {
        /*
        * 1 -> 2 -> 3 -> 5
        * 6 -> 7
        *
        *
        *
        * */

        ls.sort((o1, o2) -> {
            if(o1.x == o2.x){
                return o2.y - o1.y;
            }
            return o1.x - o2.x;
        });

        Pair start = ls.get(0);

        for (int i = 1; i < ls.size(); i++) {



            if(ls.get(i).x >= start.y){
//                System.out.println("*");
                answer += Math.abs(start.y - start.x);
                start = ls.get(i);
                continue;
            }

            if(ls.get(i).x < start.y){
//                System.out.println("**");
                start.y = Math.max( start.y ,ls.get(i).y);
                continue;
            }

            /*
            *
            *
            *
            * */

        }

//        System.out.println(start.x + " " + start.y);
        answer += Math.abs(start.y - start.x);

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ls.add(new Pair(a, b));
        }
    }
}
