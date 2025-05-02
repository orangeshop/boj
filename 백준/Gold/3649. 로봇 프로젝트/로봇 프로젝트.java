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

    static int t, n;
    static ArrayList<Integer> list = new ArrayList<>();

    static int x1, x2;

    public static void main(String[] args) throws IOException {


        String line;
        // readLine()이 더 이상 읽을 게 없으면 null을 반환
        while ((line = br.readLine()) != null) {
            // 처리 로직 예:
            st = new StringTokenizer(line);
            t = Integer.parseInt(st.nextToken());

            t *= 10_000_000;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }

            solution();

            if (x1 != 0 && x2 != 0) {
                List<Integer> ans = new ArrayList<>();
                ans.add(x1);
                ans.add(x2);

                ans.sort((o1, o2) -> o1 - o2);

                System.out.println("yes " + ans.get(0) + " " + ans.get(1));
            } else {
                System.out.println("danger");
            }

            line = null;
            list.clear();
            x1 = 0;
            x2 = 0;

        }
        br.close();


    }

    private static void solution() {

        list.sort((o1, o2) -> o1 - o2);

        for (int i = 0; i < n; i++) {

            int l = i + 1;
            int r = n;

            while (l < r) {

                int mid = (l + r) / 2;

                if (list.get(i) + list.get(mid) == t) {
//                    System.out.println(i + " " + mid);
//                    System.out.println(list.get(i) + " "+ list.get(mid));
                    int num1 = Math.abs(list.get(i) - list.get(mid));
                    int num2 = Math.abs(x1 - x2);
//                    System.out.println(num1 + " " + num2);



                    if (num1 >= num2) {
                        x1 = list.get(mid);
                        x2 = list.get(i);
                    }
                }

                if (list.get(i) + list.get(mid) < t) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

        }
    }

    private static void input() throws IOException {


    }
}
