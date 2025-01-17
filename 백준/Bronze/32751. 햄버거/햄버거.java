

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, size;
    static int[] count = new int[4];
    static String str;
    static char[] hamburger;

    public static void main(String[] args) throws IOException {
        init();
        String answer = (solution() ? "Yes" : "No");
        System.out.println(answer);
    }

    private static boolean solution() {
        // 재료의 개수를 초가하는가
        int[] cnt = new int[4];

        for(int i =0; i < size; i++){
            cnt[hamburger[i]-'a']++;
        }

        for(int i =0; i < 4; i++){
            if(cnt[i] > count[i]) return false;
        }

        //  처음과 끝이 a 인가

        if(hamburger[0] != 'a' || hamburger[size-1] != 'a') return false;

        // 인접한 값이 동일한가

        for(int i =1; i < size; i++){
            if(hamburger[i-1] == hamburger[i]) return false;
        }


        return true;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i =0; i < 4; i++){
            count[i] = Integer.parseInt(st.nextToken());
        }

        str = br.readLine();
        size = str.length();

        hamburger = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            hamburger[i] = str.charAt(i);
        }
    }
}
