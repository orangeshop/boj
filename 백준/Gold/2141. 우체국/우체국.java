
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
    
    static int N;
    static long answer = Integer.MAX_VALUE;

    static List<Pair> ls = new ArrayList<>();
    static long[] value;

    static class Pair{
        long x, y;

        Pair(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void solution() {

        ls.sort((o1, o2) ->{
            return (int) o1.x - (int) o2.x;
        });

        value[0] = ls.get(0).y;

        for(int i =1; i < N; i++){
            value[i] = value[i-1] + ls.get(i).y;
        }



        int left = 0;
        int right = N-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            long l = value[mid];
            long r = value[N-1] - value[mid];

            if(l < r){
                left = mid + 1;
            }else{
                right = mid - 1;
                answer = Math.min(answer, ls.get(mid).x);
            }

        }


    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        value = new long[N];

        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ls.add(new Pair(a,b));
        }
    }
}
