import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static ArrayList<Pair>[] ls;

    static ArrayList<Pair>[] rls;
    static int[] indegree;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        /*
        * 기본 부품인 얘들을 찾아야함
        * 1
        * 2
        * 3
        * 4
        *
        * 는 인디그리가 0일 것임
        *
        * 그리고
        *
        * 각 부품의 리스트가 따로 필요할 듯 함
        *
        * 2차원 리스트로
        *   1 2 3 4 5 6 7
        * 1
        * 2
        * 3
        * 4
        * 5 2 2
        * 6 4 4 3 4
        * 7 16 16 9 17
        *
        * 그냥 완제품부터 돌리면 될 것 같은디
        *
        * */
        
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                Q.add(i);
                ans.add(i);
                arr[i][i] = 1;
            }
        }

        while (!Q.isEmpty()) {
            Integer cur = Q.poll();

//            System.out.println(cur);

            for(Pair nxt : ls[cur]){

//                arr[nxt.y][cur] += nxt.x;

                for(int k : ans){
                    arr[nxt.y][k] += arr[cur][k] * nxt.x;
                }

                indegree[nxt.y]--;

                if(indegree[nxt.y] == 0) {
                     Q.add(nxt.y);
                }
            }
        }

        ans.sort((o1, o2) -> {
            return o1 - o2;
        });

//        for(int i =1; i <= N ; i++){
//            for(int j =1; j <= N; j++){
//
//                if(arr[i][j] == 0) continue;
//
//                for(int k =1; k <= N; k++){
//                    arr[i][k] += arr[j][k] * arr[i][j];
//                }
//            }
//        }

//        for (int[] ints : arr) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }

        for (Integer an : ans) {
            System.out.println(an + " " + arr[N][an]);
        }

    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        ls = new ArrayList[N+1];
        indegree = new int[N+1];
        arr = new int[N+1][N+1];

        for(int i=0;i<=N;i++) {
            ls[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ls[b].add(new Pair(c,a));
            indegree[a]++;
        }
    }

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
