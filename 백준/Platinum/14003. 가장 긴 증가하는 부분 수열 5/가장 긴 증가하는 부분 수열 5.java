
import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int[] lis;

    static int answer = 0;
    static List<Integer> ansLs1 = new ArrayList<>();
    static int[] ansLs2;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void binarySearch() {
        ansLs2 = new int[N];
        ansLs1.add(lis[0]);
        for (int i = 1; i < N; i++) {

            if (ansLs1.get(ansLs1.size() - 1) < lis[i]) {
                ansLs1.add(lis[i]);
                ansLs2[i] = ansLs1.size() - 1;
            } else {

                int left = 0;
                int right = ansLs1.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (ansLs1.get(mid) < lis[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                ansLs1.set(right, lis[i]);
                ansLs2[i] = right;
            }
        }

    }

    static void solution() {
         binarySearch();

        System.out.println(ansLs1.size());
        int index = ansLs1.size() - 1;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = N-1 ; i >= 0; i--) {

            if (ansLs2[i] == index) {
                index--;
                stack.push(lis[i]);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        lis = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lis[i] = Integer.parseInt(st.nextToken());
        }
    }
}
