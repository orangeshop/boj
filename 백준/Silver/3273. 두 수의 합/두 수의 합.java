import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int N,X;

    public static List<Integer> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());

        ls.sort((o1, o2) -> o1 - o2);

        int answer = 0;

        int l = 0;
        int r = N-1;

        while (l < r){

//            System.out.println(ls.get(l) + " " + ls.get(r) + " " + answer);

            if(ls.get(l) + ls.get(r) < X){
                l++;
            }else if(ls.get(l) + ls.get(r) > X){
                r--;
            }else{
                answer++;
                l++;
            }

        }

        System.out.println(answer);
    }
}
