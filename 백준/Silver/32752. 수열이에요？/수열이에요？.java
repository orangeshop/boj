

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, L, R;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        int ans = (solution()? 1 : 0);
        System.out.println(ans);
    }

    private static boolean solution() {
        ArrayList<Integer> ls = new ArrayList<>();
        
        for(int i = L; i <= R; i++){
            ls.add(arr[i]);
        }

        ls.sort((o1, o2) -> {
            return o1 - o2;
        });

        int idx = 0;
        for(int i = L; i <= R; i++){
            arr[i] = ls.get(idx);
            idx++;
        }

        for(int i =1; i< N; i++){
            if(arr[i-1] > arr[i]) return false;
        }


        return true;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()) - 1;
        R = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
