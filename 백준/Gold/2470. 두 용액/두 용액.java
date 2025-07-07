import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int N;
    public static List<Integer> ls = new ArrayList<Integer>();



    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        ls.sort((o1, o2) -> o1 - o2);

        int l = 0;
        int r = N-1;

        int x1 = 0, x2 = 0, x3 = Integer.MAX_VALUE;

        while(l < r) {

            int num = ls.get(l) + ls.get(r);

//            System.out.println(ls.get(l) +" " + ls.get(r) + " " + num + " " + x3);

            if (0 <= Math.abs(num) && Math.abs(num) < x3){
                x1 = ls.get(l);
                x2 = ls.get(r);
                x3 = Math.abs(num);
            }

            if(num < 0){
                l++;
            }else if(num > 0){
                r--;
            }else{
                l++;
            }
        }

        System.out.println(x1 + " " + x2);

    }
}
