import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static Long N;

    public static void main(String[] args)  throws IOException {
//        System.setIn(new FileInputStream("src/boj/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        for(int i =0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            Long M = Long.parseLong(st.nextToken());

            Map<Long, Long> map = new HashMap<>();
            Set<Long> set = new HashSet<>();

            for(int j =0; j < M; j++) {
                Long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, 0L) + 1);
                set.add(num);
            }
            boolean flag = false;
            for(Long num : set) {
                if(map.get(num) > M/2) {
                    System.out.println(num);
                    flag = true;
                }
            }

            if(!flag){
                System.out.println("SYJKGW");
            }
        }
    }
}
