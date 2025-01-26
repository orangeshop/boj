import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static ArrayList<Long> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        long sum = ls.stream().reduce(0L, Long::sum);
        long max = ls.stream().max(Long::compare).get().longValue();
        long restValue = sum - max;

        if(N == 1){
            System.out.println(max);
            return;
        }

        if (max > restValue) {
            System.out.println(max - restValue);
        } else {
            if(sum % 2 == 0){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            ls.add(Long.parseLong(br.readLine()));
        }
    }
}
