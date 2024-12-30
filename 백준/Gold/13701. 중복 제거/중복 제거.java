
import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] arr = new int[1 << 25];

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());

            int idx = n / 32;
            int shift = n % 32;

            if((arr[idx] & (1 << shift)) != 0){
                continue;
            }
            arr[idx] |= (1 << shift);
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}
