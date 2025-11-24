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

    static int T;
    static int N;
    static int[] A;
    static int M;
    static int[] B;
    static long answer;

    static List<Integer> listA = new ArrayList<>();
    static List<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                listA.add(sum);
            }
        }

        // [수정 2] B의 모든 부배열의 합 구하기 & listB 생성
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                listB.add(sum);
            }
        }

        listB.sort((o1, o2) -> o1 - o2);

        for (int i = 0; i < listA.size(); i++) {
            int find = T - listA.get(i);

            int cnt = UpperBound(0, listB.size(), find) - LowerBound(0, listB.size(), find);
//            System.out.println(find + " " + cnt);
            answer += cnt;
        }

        System.out.println(answer);


    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int UpperBound(int start, int end, int target) {
        int st = start;
        int ed = end;

        while (st < ed) {
            int mid = (st + ed) / 2;

            if (listB.get(mid) <= target) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }
//        System.out.println(st + " " + ed);
        return ed;
    }

    static int LowerBound(int start, int end, int target) {
        int st = start;
        int ed = end;

        while (st < ed) {
            int mid = (st + ed) / 2;

            if (listB.get(mid) < target) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }
        return ed;
    }
}
