import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = Arrays.stream(arr).max().getAsInt();
        int r = Arrays.stream(arr).sum();

        while (l <= r){
            int mid = (l+r)/2;
            if(calc(mid)){
                 r = mid - 1;
                answer = Math.min(answer, mid);
            }else{
                l = mid + 1;
            }
        }

        System.out.println(answer);

    }

    private static boolean calc(int target) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + arr[i] > target) {
                count++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }

        return count <= M;
    }
}
