import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

         if(N < 10){
             System.out.println(N);
         }else {
            for(int i =0; i < 10; i++) dfs(i, 1);
            if(N >= arr.size()) System.out.println(-1);
            else{
                Collections.sort(arr);
                System.out.println(arr.get(N));
            }
         }


    }

    static void dfs(long num, int v) {
        if(v > 10) return;
        arr.add(num);
        for(int i =0; i < num % 10; i++){
            dfs((num * 10) + i, v + 1);
        }
    }
}
