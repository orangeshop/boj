import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static List<Integer>[] adj;
    static int[] count;

    static ArrayDeque<Integer> Q = new ArrayDeque<>();

    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {


        while (!Q.isEmpty()) {
            Integer cur = Q.poll();
//            System.out.println("cur " + cur);
            ans.add(cur);

            for (int nxt : adj[cur]) {
                count[nxt]--;

                if (count[nxt] == 0) {
                    Q.add(nxt);
                }
            }
        }

        /*
         * 1 :
         * 2 : 6
         * 3 : 4 2
         * 4 : 1 5
         * 5 : 2
         * 6 :
         * --------
         * 1 : 4
         * 2 : 5 3
         * 3 :
         * 4 : 3
         * 5 : 4
         * 6 : 2
         * --------
         * */

//        System.out.println("------");

        if(ans.size() != N){
            System.out.println(0);
        }
        else{
            for (Integer an : ans) {
                System.out.println(an);
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new List[N + 1];
        count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int preNum = Integer.parseInt(st.nextToken());

            for (int k = 0; k < a - 1; k++) {
                int nowNum = Integer.parseInt(st.nextToken());

                adj[preNum].add(nowNum);
                count[nowNum]++;
                preNum = nowNum;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
//                System.out.println(i);
                Q.add(i);
            }

//            System.out.println();
//            System.out.println(i);
//
//            for(int item : adj[i]){
//                System.out.println("item = " + item);
//            }
//
//            System.out.println();
//            System.out.println();
            
            
        }

//        System.out.println("-----");
    }
}
