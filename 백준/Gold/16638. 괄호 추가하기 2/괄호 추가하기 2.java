import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    static int N;
    static List<Object> ls = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) ls.add(str.charAt(i) - '0'); // 숫자는 Integer로 저장
            else ls.add(str.charAt(i)); // 연산자는 Character로 저장
        }
        dfs(1, new boolean[N]);
        System.out.println(answer);
    }

    static void dfs(int depth, boolean[] vis) {
        if (depth >= N) {
//            System.out.println(Arrays.toString(vis));
            answer = Math.max(calc(vis), answer);
            return;
        }

        vis[depth - 1] = true;
        vis[depth] = true;
        vis[depth + 1] = true;
        dfs(depth + 4, vis);
        vis[depth - 1] = false;
        vis[depth] = false;
        vis[depth + 1] = false;


        dfs(depth + 2, vis);
    }

    static int calc(boolean[] vis) {
        List<Object> firstLS = new ArrayList<>();

        // 괄호 처리
        for (int i = 0; i < N; i++) {
            if (vis[i]) {
                firstLS.add(
                        subCalc(Integer.parseInt(ls.get(i)+""), (Character) ls.get(i + 1), Integer.parseInt(ls.get(i+2)+""))
                );
                i += 2;
            } else {
                // 숫자인지 연산자인지 구분해서 넣어야 나중에 (int) 캐스팅 시 에러 안 남
                Object obj = ls.get(i);
                if (i % 2 == 0) firstLS.add(obj); // 숫자 위치면 Integer로 변환
                else firstLS.add(obj); // 연산자 위치면 Character 그대로
            }
        }

        // 곱셈 처리
        for (int i = 1; i < firstLS.size(); i += 2) {
            if (firstLS.get(i) instanceof Character && (char) firstLS.get(i) == '*') {
                int r = subCalc((int)firstLS.get(i - 1), (char)firstLS.get(i), (int)firstLS.get(i + 1));
                firstLS.add(i + 2, r);
                firstLS.remove(i + 1);
                firstLS.remove(i);
                firstLS.remove(i - 1);
                i = -1;
            }
        }

        // 덧, 빼기 처리 (괄호로 논리 연산 우선순위 고정)
        for (int i = 1; i < firstLS.size(); i += 2) {
            if (firstLS.size() == 1) break;
            Object opObj = firstLS.get(i);
            if (opObj instanceof Character && ((char) opObj == '+' || (char) opObj == '-')) {
                int r = subCalc((int)firstLS.get(i - 1), (char)opObj, (int)firstLS.get(i + 1));
                firstLS.add(i + 2, r);
                firstLS.remove(i + 1);
                firstLS.remove(i);
                firstLS.remove(i - 1);
                i = -1;
            }
        }

        // 이제 모든 요소가 Integer이거나 계산된 결과이므로 (int) 캐스팅 가능
        return (int) firstLS.get(0);
    }

    static int subCalc(int num1, char type, int num2) {
        if (type == '*') {
            return num1 * num2;
        } else if (type == '+') {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }


}
