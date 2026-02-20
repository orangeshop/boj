import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static long answer = 0;
    static long[] count = new long[M]; // 나머지의 빈도를 저장할 배열
    static long sum = 0;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new long[M];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            int remainder = (int) (sum % M);
            count[remainder]++;
        }


        answer += count[0];


        for (int i = 0; i < M; i++) {
            if (count[i] > 1) {
                answer += (count[i] * (count[i] - 1)) / 2;
            }
        }

        System.out.println(answer);
    }
}
