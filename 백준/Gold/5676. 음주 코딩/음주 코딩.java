import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, K;
    static long[] Tree;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
    }

    static void init(int node, int s, int e) {
        if (s == e) {
            Tree[node] = arr[s];
            return;
        }

        int mid = (s + e) / 2;
        init(node * 2, s, mid);
        init(node * 2 + 1, mid + 1, e);
        Tree[node] = Tree[node * 2] * Tree[node * 2 + 1];
    }

    static long query(int node, int s, int e, int l, int r) {
        if (e < l || s > r) {
            return 1;
        }

        if (l <= s && e <= r) {
            return Tree[node];
        }

        int mid = (s + e) / 2;
        long x = query(node * 2, s, mid, l, r);
        long y = query(node * 2 + 1, mid + 1, e, l, r);
        return x * y;
    }

    static void update(int node, int s, int e, int idx, int val) {
        if (idx < s || e < idx) {
            return;
        }

        if (s == e) {
            Tree[node] = val;
            return;
        }

        int mid = (s + e) / 2;
        update(node * 2, s, mid, idx, val);
        update(node * 2 + 1, mid + 1, e, idx, val);
        Tree[node] = Tree[node * 2] * Tree[node * 2 + 1];
    }

    private static void input() throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            while ((line = br.readLine()) != null) {
                st = new StringTokenizer(line);

                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());

                arr = new long[N * 4];
                Tree = new long[N * 4];

                st = new StringTokenizer(br.readLine());

                for (int i = 1; i <= N; i++) {
                    int t = Integer.parseInt(st.nextToken());
                    arr[i] = (t == 0) ? 0 : (t > 0) ? 1 : -1;
                }

                init(1, 1, N);

                for (int k = 0; k < K; k++) {

//                    System.out.println(Arrays.toString(Tree));

                    st = new StringTokenizer(br.readLine());
                    String a = st.nextToken();
                    int b = Integer.parseInt(st.nextToken());

                    if (a.equals("C")) {
                        int c = Integer.parseInt(st.nextToken());
                        c = (c == 0) ? 0 : (c > 0) ? 1 : -1;

                        update(1, 1, N, b, c);
                    } else if(a.equals("P")) {
                        int c = Integer.parseInt(st.nextToken());
                        long num = query(1, 1, N, b, c);
                        if (num == 0) {
                            sb.append("0");
                        } else if (num > 0) {
                            sb.append("+");
                        } else {
                            sb.append("-");
                        }
                    }
                }
                sb.append('\n');
//                System.out.println();
            }
        } catch (Exception e) {

        } finally {
            bw.write(sb.toString());
            bw.flush();
            bw.close();

        }


    }
}
