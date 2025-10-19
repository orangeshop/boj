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

    static int N;
    static int answer;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayDeque<Pair> s = new ArrayDeque<>();
    static ArrayList<Pair> ls = new ArrayList<>();

    static Pair highNum = new Pair(0, 0);

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        int maxX = 0, maxY = 0;
        int[] arr = new int[1005];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x] = y;

            if (maxY < y) { // 높이가 가장 높은 기둥의 위치를 찾아주기
                maxX = x;
                maxY = y;
            }
        }

        answer = maxY;

        for (int i = 0; i <= maxX; i++) {
            if(arr[i] == 0) continue;

            if (s.isEmpty()) {
                s.addFirst(new Pair(i, arr[i]));

            } else if (s.peekFirst().y <= arr[i]) {
                int dx = i - s.peekFirst().x;
                int dy = s.peekFirst().y;

                answer += dx * dy;
                s.addFirst(new Pair(i, arr[i]));
            }
        }

        s.clear();

        for (int i = 1000; i >= maxX; i--) {
            if(arr[i] == 0) continue;

            if (s.isEmpty()) {
                s.addFirst(new Pair(i, arr[i]));

            } else if (s.peekFirst().y <= arr[i]) {
                int dx = s.peekFirst().x - i;
                int dy = s.peekFirst().y;

                answer += dx * dy;
                s.addFirst(new Pair(i, arr[i]));
            }
        }


        System.out.println(answer + highNum.y);

    }
}


/*
4
1 6
3 6
5 6
7 7


4
1 6
3 6
5 6
7 5

 */