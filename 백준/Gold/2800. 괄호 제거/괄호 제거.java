

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String str;

    static Stack<Integer> st1 = new Stack<>();
    static Queue<Integer> st2 = new ArrayDeque<>();
    static List<Pair> ls = new ArrayList<>();

    static Set<String> answer = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    static void init() throws IOException {
        str = br.readLine();
    }

    static void dfs(int depth, boolean[] arr) {
        if (depth == arr.length) {

            boolean[] check = new boolean[str.length()];

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == true) {
                    check[ls.get(i).x] = true;
                    check[ls.get(i).y] = true;
                }
            }

            String ans = "";

            for (int i = 0; i < str.length(); i++) {
                if (check[i] == true) continue;
                ans += str.charAt(i);
            }

            answer.add(ans);
            return;
        }


        dfs(depth + 1, arr);

        arr[depth] = true;
        dfs(depth + 1, arr);
        arr[depth] = false;


    }

    static void print() {
        boolean check = false;
        Iterator<String> iter = answer.iterator();
        while (iter.hasNext()) {
            if (check == false) {
                check = true;
                iter.next();
                continue;
            }
            System.out.println(iter.next());
        }
    }

    static void solution() {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                st1.add(i);
            } else if (str.charAt(i) == ')') {
                st2.add(i);
            }

            if (!st1.empty() && !st2.isEmpty()) {
                int x = st1.peek();
                st1.pop();

                int y = st2.peek();
                st2.poll();
                ls.add(new Pair(x, y));
            }

        }
        
        boolean[] arr = new boolean[ls.size()];
        dfs(0, arr);

    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
