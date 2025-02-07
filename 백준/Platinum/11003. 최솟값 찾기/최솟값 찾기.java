import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, L;

    static ArrayDeque<Pair> deque = new ArrayDeque<>();
    static int[] arr;

    static ArrayList<Integer> answer = new ArrayList<>();

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();

        bw.flush();
        bw.close();

    }

    private static void solution() throws IOException {


        for (int i = 0; i < N; i++) {

            if (!deque.isEmpty() && deque.getFirst().y <= i - L) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.getLast().x > arr[i]) {
                deque.removeLast();
            }

            deque.addLast(new Pair(arr[i], i));

            bw.write(deque.getFirst().x + " ");

//            ArrayList<Pair> tmp = new ArrayList();
//            tmp.addAll(deque);
//            for (int j = 0; j < tmp.size(); j++) {
//                System.out.print(tmp.get(j).x + " " + tmp.get(j).y + ", ");
//            }
//            System.out.println();


            /* 가장 작은 숫자를 뽑아내야함?
            어떻게?

            새로 들어올 값보다 큰 값이 있으면 전부다 뺴준다.

            밤위에 벗어난 값은 빼줌
            */
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
