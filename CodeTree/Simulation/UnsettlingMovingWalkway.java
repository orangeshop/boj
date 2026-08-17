package CodeTree_new;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UnsettlingMovingWalkway {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;

    static ArrayList<Integer> ls = new ArrayList<>();

    static ArrayList<Integer> humans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        boolean flag = true;

        int answer = 0;

        while (flag) {
            int cnt = 0;
            for(int i =0; i < ls.size(); i++){
                if(ls.get(i) <= 0) cnt++;
            }

            if(cnt >= K) break;

            cycle();

            move();

            ride();

            answer++;
        }


        System.out.println(answer);


//        for (int i = 0; i < N * 2; i++) {
//            System.out.print(ls.get(i) + " ");
//        }
//
//        System.out.println();
//
//        for (int i = 0; i < N * 2; i++) {
//            System.out.print(humans.get(i) + " ");
//        }
    }

    public static void cycle() {
        ArrayDeque<Integer> tmp = new ArrayDeque<>(ls);

        Integer v = tmp.removeLast();
        tmp.addFirst(v);

        ls.clear();
        ls.addAll(tmp);


        ArrayDeque<Integer> tmpH = new ArrayDeque<>(humans);
        Integer h = tmpH.removeLast();
        tmpH.addFirst(h);

        humans.clear();
        humans.addAll(tmpH);

        for (int i = N - 1; i < humans.size(); i++) {
            humans.set(i, -1);
        }
    }

    public static void move() {
        // 먼저 올라간 사람부터 이동을 한다.


        for (int k = humans.size() - 2; k >= 0; k--) {

            if (humans.get(k) == -1) continue;
            if (humans.get(k + 1) != -1) continue;
            if (ls.get(k + 1) == 0) continue;

//            System.out.println(k);
//
            int num = humans.get(k + 1);
            humans.set(k + 1, humans.get(k));
            humans.set(k, num);

            ls.set(k + 1, Math.max(ls.get(k + 1) - 1, 0));

        }

        for (int i = N - 1; i < humans.size(); i++) {
            humans.set(i, -1);
        }

    }

    public static void ride() {
        if (ls.get(0) != 0) {
            humans.set(0, 1);
            ls.set(0, Math.max(ls.get(0) - 1, 0));
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N * 2; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
            humans.add(-1);
        }
    }
}

/*
 * 무빙워크 회전
 *
 * 올라간 사람 부터 한칸 이동 가능하면 이동
 * 앞에 사람이 있거나 안정성이 0이면 이동 x
 *
 * 사람이 없고 안정성이 0이 아니면 올림
 *
 *
 * */
