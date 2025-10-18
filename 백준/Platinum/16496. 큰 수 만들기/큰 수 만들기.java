import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    static ArrayList<String> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            ls.add(st.nextToken());
        }

        ls.sort((o1, o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });

        for (String str : ls) {
//            System.out.println(str);
            sb.append(str);
        }
        
        
        
        System.out.println(sb.toString().charAt(0) == '0' ? 0 : sb.toString());
    }
}
