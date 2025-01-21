import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
//        System.out.println(Arrays.toString(arr));
    }

    private static void solution() {
        for(int i = 1; i < N; i++){

            while(arr[i-1] > arr[i]){
                arr[i]  = arr[i] * 2;
                answer++;

            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}
