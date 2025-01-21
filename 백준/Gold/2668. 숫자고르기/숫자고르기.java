import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static TreeSet<Integer> set = new TreeSet<>();
    static ArrayList<Integer> ls = new ArrayList<>();
    static ArrayList<Integer>[] adj = new ArrayList[101];


    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        for(int i =1; i < N; i++){
            int[] vis = new int[N+1];
            ArrayDeque<Integer> Q = new ArrayDeque<>();
            Q.add(i);
            vis[i] = 1;

            while(!Q.isEmpty()){
                int cur = Q.poll();

                if(vis[cur] >= 5) break;

                for(int nxt : adj[cur]){
                    Q.add(nxt);
                    vis[nxt]++;
                }
            }

//            System.out.println(Arrays.toString(vis));
            for(int k =0; k < vis.length; k++){
                if(vis[k] > 1){
                    set.add(k);
                }
            }
        }


        ls.addAll(set);

        ls.sort((o1, o2) -> {
            return o1 - o2;
        });
        System.out.println(ls.size());
        for (Integer l : ls) {
            System.out.println(l);
        }


    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i =0; i < 101; i++){
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            adj[i].add(a);
        }


    }


}
