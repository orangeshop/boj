import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> arr = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int l = 0;
        int ans = 0;


        for(int i = 0; i < arr.size(); i++) {
            int sum = 0;

            for (int k = i; k < arr.size(); k++) {
                sum += arr.get(k);

                if(sum > 4000000){
                    break;
                }
                
                if(sum == N){
                    ans++;
                }

            }
        }

        System.out.println(ans);
    }

    static {
        boolean[] c = new boolean[4_000_005];

        for (int i = 2; i < 4_000_005; i++) {
            for (int j = i + i; j < 4_000_005; j = j + i) {
                c[j] = true;
            }
        }

        for (int i = 2; i < 4_000_005; i++) {
            if (c[i]) continue;
            arr.add(i);
        }

    }
}
