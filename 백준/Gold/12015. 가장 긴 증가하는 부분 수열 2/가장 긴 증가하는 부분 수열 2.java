import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;

    static List<Integer> ls = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if(ls.isEmpty()){
                ls.add(arr[i]);
                continue;
            }

            if(ls.get(ls.size()-1) < arr[i]){
                ls.add(arr[i]);
            }else{
                int s = 0;
                int e = ls.size()-1;

                while (s < e){
                    int mid = (s + e) / 2;

                    if(arr[i] > ls.get(mid)){
                        s = mid + 1;
                    }else{
                        e = mid;
                    }
                }

                ls.set(s, arr[i]);
            }
        }

//        for (int i = 0; i < ls.size(); i++) {
//            System.out.print(ls.get(i) + " ");
//        }

        System.out.println(ls.size());

    }
}
