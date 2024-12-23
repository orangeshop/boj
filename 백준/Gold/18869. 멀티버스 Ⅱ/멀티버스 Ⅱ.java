import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static List<List<Integer>> ls = new ArrayList<>();
    static List<Set<Integer>> ts = new ArrayList<>();
    static List<List<Integer>> tls = new ArrayList<>();

    static int[][] arr;
    static int answer;


    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void solution() {

        // 좌표 압축
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            ts.add(new HashSet<>());
            tls.add(new ArrayList<>());
            for (Integer ii : ls.get(i)) {
                ts.get(i).add(ii);
            }

            TreeSet<Integer> tts = new TreeSet<>();
            tts.addAll(ts.get(i));
            tls.get(i).addAll(tts);
        }


        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {

                /*
                 * ls 의 1 3 2
                 * tls 1 2 3
                 *
                 * arr 1 3 2
                 *
                 * ls 12 50 31
                 * tls 12 31 50
                 *
                 * 1 3 2
                 *
                 * arr = ls의 12는 tls 인덱스 0 이니까 0
                 * arr = ls의 50은 tls 인덱스 2 이니까 2
                 *
                 *
                 *
                 * */

                arr[i][k] = bn(ls.get(i).get(k), i);
            }
        }

//        for(int i =0; i < N; i++){
//            for(int k =0; k < M; k++){
//                System.out.print(arr[i][k] + " ");
//            }
//            System.out.println();
//        }


        for (int i = 0; i < N-1; i++) {
            for (int k = i+1; k < N; k++) {
//                System.out.println(i + " " +k);
                if(Arrays.equals(arr[i], arr[k])){
                    answer++;
                }
            }
        }
    }

    private static int bn(Integer target, Integer idx) {
        int left = 0;
        int right = M - 1;

        while (left < right) {
            int mid = (left + right) / 2;

//            System.out.println("mid " + tls.get(idx).get(mid));

            if (target <= tls.get(idx).get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }


//        System.out.println(target + " " + idx + " " + left + " " + right);

        return right;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ls.add(new ArrayList<>());
            for (int k = 0; k < M; k++) {
                ls.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
    }
}
