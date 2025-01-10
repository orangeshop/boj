

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, answer = Integer.MAX_VALUE;
    static int[] arr = new int[4];
    static boolean[][][] vis = new boolean[66][66][66];

    static int[][] three = {{1,3,9},
                            {1,9,3},
                            {3,1,9},
                            {3,9,1},
                            {9,1,3},
                            {9,3,1}};


    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void solution() {
        dfs(0, arr[0], arr[1], arr[2]);
    }

    private static void dfs(int depth, int a, int b, int c) {

        a = Math.max(a, 0);
        b = Math.max(b, 0);
        c = Math.max(c, 0);

        if(a == 0 && b == 0 && c == 0){
            answer = Math.min(answer, depth);
            return;
        }

        int[] sort = {a,b,c};
        Arrays.sort(sort);

        a = sort[0];
        b = sort[1];
        c = sort[2];

        if(vis[a][b][c]){
            return;
        }else {
            vis[a][b][c] = true;
        }
        if(answer <= depth){
            return;
        }

        for(int i =0; i < 6; i++){
            dfs(depth + 1,a - three[i][0], b - three[i][1], c - three[i][2]);
        }


    }

    /*
    * 첫번째 공격 타겟 설정
    * 두번째 공격 타겟 설정
    * 세번째 공격 타겟 설정
    * [이거 한세트]
    *
    * [1,2,3]
    * [1,3,2]
    * [2,1,3]
    * [2,3,1]
    * [3,2,1]
    * [3,1,2]
    *
    * [1,2]
    * [2,1]
    *
    * [1]
    *
    * */


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
