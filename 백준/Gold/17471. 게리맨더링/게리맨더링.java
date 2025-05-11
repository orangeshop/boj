

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int N;
    public static int[] arr;
    public static List<Integer>[] adj;

    static Integer answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        input();
        solution();

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void solution() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.addLast(i);
            dfs(1, q);
            q.removeLast();
        }
    }

    static HashSet<String> set = new HashSet<>();

    private static void dfs(int depth, ArrayDeque<Integer> tmp) {

        // 정렬해서 걸러야함
        List<Integer> sorted = tmp.stream().sorted().collect(Collectors.toList());;
        if (set.contains(Arrays.toString(sorted.toArray()))) return;
        set.add(Arrays.toString(sorted.toArray()));

        if (tmp.size() == N) {
            return;
        }

        boolean[] vis = new boolean[N + 1];

        tmp.forEach(integer -> {
            vis[integer] = true;
        });

        List<Integer> aList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!vis[i]) {
                aList.add(i);
            }
        }

        List<Integer> sorted2 = aList.stream().sorted().collect(Collectors.toList());
        set.add(Arrays.toString(sorted2.toArray()));


        bfs(tmp.stream().collect(Collectors.toList()), aList);

        for (int i = 1; i <= N; i++) {
            if (tmp.contains(i)) continue;
            tmp.add(i);
            dfs(depth + 1, tmp);
            tmp.removeLast();
        }
    }

    private static void bfs(List<Integer> tmp, List<Integer> aList) {
        // 서로 연결 되어 있는지 체크
//        System.out.println("----------");
//        System.out.println(Arrays.toString(tmp.toArray()));
//        System.out.println(Arrays.toString(aList.toArray()));

//        System.out.println();

        boolean[] vis1 = new boolean[N + 1];
        tmp.stream().forEach(integer -> vis1[integer] = true);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(tmp.get(0));
        vis1[tmp.get(0)] = false;
//        System.out.println(Arrays.toString(vis1));

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();

//            System.out.println(cur);
            for(Integer integer : adj[cur]) {
                if (vis1[integer]) {
                    q.addLast(integer);
                    vis1[integer] = false;
                }
            }
        }

//        System.out.println("result : " + Arrays.toString(vis1));

        boolean[] vis2 = new boolean[N + 1];
        aList.stream().forEach(integer -> vis2[integer] = true);

        q.add(aList.get(0));
        vis2[aList.get(0)] = false;

//        System.out.println(Arrays.toString(vis2));

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();

//            System.out.println(cur);
            for(Integer integer : adj[cur]) {
                if (vis2[integer]) {
                    q.addLast(integer);
                    vis2[integer] = false;
                }
            }
        }

//        System.out.println("result : " + Arrays.toString(vis2));

        for(int i =1; i <= N; i++) {
            if (vis2[i] || vis1[i]) {
                return;
            }
        }

        // 인구 수 계산
        int result1 = tmp.stream()
                 .mapToInt(i -> arr[i])
                 .sum();

        int result2 = aList.stream()
                .mapToInt(i -> arr[i])
                .sum();

        answer = Math.min(answer, Math.abs(result1 - result2));
    }


    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            for (int j = 0; j < a; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

}
