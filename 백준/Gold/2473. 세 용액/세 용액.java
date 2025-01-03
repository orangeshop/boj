

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

    static Long N;

    static List<Integer> ls = new ArrayList<>();

    static Long minAns = Long.MAX_VALUE;

    static Long[] minArr = new Long[3];

    public static void main(String[] args) throws IOException {
        init();
        solution();

    }

    private static void solution() {

        for (int i = 0; i < N - 2; i++) {
            for (int k = i + 1; k < N - 1; k++) {

                bn(k + 1, ls.get(i), ls.get(k));

            }
        }

        Arrays.sort(minArr);

        System.out.println(minArr[0] + " " + minArr[1] + " " + minArr[2]);

    }

    private static void bn(long k, long num1, long num2) {
        long left = k;
        long right = N - 1;

        while (left <= right) {
            int mid =(int) (left + right) / 2;
            long val = num1 + num2 + ls.get(mid);
//            System.out.println("****** " + left + " " + right + " " + mid);
//            System.out.println("****** " +num1 + " " + num2 + " " + ls.get(mid));
            /*
             * 0에 가장 가까워야 함
             *
             *
             * */
            if (minAns > Math.abs(val)) {
                minAns = Math.abs(val);
                minArr[0] = num1;
                minArr[1] = num2;
                minArr[2] = (long) ls.get(mid);
            }


            if (val < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

//        System.out.println(minArr[0] + " " + minArr[1] + " " + minArr[2]);


    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        ls.sort((o1, o2) -> o1 - o2);

//        System.out.println(ls.toString());
    }

}
