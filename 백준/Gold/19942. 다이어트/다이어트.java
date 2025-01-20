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

    static int[] val = new int[4];
    static int[][] board;

    static int answer = Integer.MAX_VALUE;
    static boolean[] vis;
    static List<Integer> ls = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        init();
        solution();
        
        if(answer == Integer.MAX_VALUE) {
            System.out.println("-1");
            return;
        }
        
        System.out.println(answer);
        ls.sort((o1, o2) -> {
            return o1 - o2;
        });

        for (Integer l : ls) {
            System.out.print(l + " ");
        }
    }

    private static void solution() {
        dfs(0, 0,0,0,0,0);
    }

    private static void dfs(int depth, int ans, int val1, int val2, int val3, int val4) {

//        System.out.println(depth + " " + ans + " " + val1 + " " + val2 + " " + val3 + " " + val4);

        if(answer <= ans) return;

        if(val[0] <= val1 && val[1] <= val2 && val[2] <= val3 && val[3] <= val4) {
            int pre = answer;
            answer = Math.min(ans, answer);

            if(pre != answer){
                ls.clear();

                for(int i =0; i < N; i++){
                    if(vis[i]){
                        ls.add(i+1);
                    }
                }
            }else if(pre == answer){
                ArrayList<Integer> tmp = new ArrayList<>();

                for(int i =0; i < N; i++){
                    if(vis[i]){
                        tmp.add(i+1);
                    }
                }

                tmp.sort((o1, o2) -> o1 - o2);

                if(tmp.get(0) < ls.get(0)){
                    ls.clear();
                    ls.addAll(tmp);
                }
            }

        }

        if(depth == N) return;

        vis[depth] = true;
        dfs(depth+1, ans + board[depth][4], val1 + board[depth][0], val2  + board[depth][1], val3  + board[depth][2], val4 + board[depth][3]);
        vis[depth] = false;

        dfs(depth+1, ans, val1, val2, val3, val4);

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][5];
        vis = new boolean[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


//        System.out.println(Arrays.toString(val));

//        System.out.println(Arrays.deepToString(board));

    }
}
