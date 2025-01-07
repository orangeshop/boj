

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static List<Pair> ls = new ArrayList<Pair>();

    static int[] check;
    static int M;
    static int[] idx = new int[10];

    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static TreeMap<Integer, Integer> rmap = new TreeMap<>();


    public static void main(String[] args) throws IOException {
        init();

        System.out.println(solution());
    }

    private static String solution() {


        /*
         * 최대 자릿수를 구하고
         * 그 이후에 하나씩 바꾸기
         *
         *
         *
         * */

        ls.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });

        Pair a = new Pair(Integer.MAX_VALUE, 0);
        Pair b = new Pair(Integer.MAX_VALUE, 0);

        for (Pair l : ls) {
//            System.out.println(l.x + " " + l.y);

            if (l.y != 0) {
                int preA = a.x;
                a.x = Math.min(a.x, l.x);
                if (preA != a.x) {
                    a.y = l.y;
                }
            }

            int preB = b.x;
            b.x = Math.min(b.x, l.x);
            if (preB != b.x) {
                b.y = l.y;
            }

        }

        int maxSize = 0;
        int maxCount = 0;

        int remain = M - a.x;

        if (remain >= 0) {
            maxSize += 1;
            maxCount += a.x;
            maxSize += remain / b.x;
            maxCount += b.x * (maxSize - 1);
        } else {
            return "0";
        }


        check = new int[maxSize];
        check[0] = a.y;

        for (int i = 1; i < maxSize; i++) {
            check[i] = b.y;
        }

//78888888
//99888888

//        System.out.println(Arrays.toString(check));

        for (int i = 0; i < maxSize; i++) {
            for (int k = 0; k < ls.size(); k++) {
//                 if (M - (maxCount - rmap.get(check[i])) >= ls.get(k).x) {
//                    maxCount -= rmap.get(check[i]);
//                    maxCount += ls.get(k).x;
//                    check[i] = ls.get(k).y;
//                }

                if (M - (maxCount - idx[check[i]]) >= ls.get(k).x && check[i] < ls.get(k).y) {
                    maxCount -= idx[check[i]];
                    maxCount += ls.get(k).x;
                    check[i] = ls.get(k).y;
                }

//                System.out.println(Arrays.toString(check));
            }

//            System.out.println();
        }


        /*
         *
         * 6 7 8
         *
         *
         * 7 6 6 -> 2
         *
         * */

        String result = "";

        for (int i : check) {
            result += i + "";
        }

        return result;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            ls.add(new Pair(num, i));
            map.put(num, i);
            rmap.put(i, num);
            idx[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());


    }

    static class Pair {
        int x, y, idx = -1;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}
