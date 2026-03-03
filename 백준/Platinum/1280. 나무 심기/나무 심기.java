import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int MAX = 200000;          // 좌표 범위: 0..200000
    static final long MOD = 1_000_000_007L;

    static long[] countTree = new long[(MAX + 1) * 4]; // 좌표별 개수
    static long[] sumTree = new long[(MAX + 1) * 4];
    static int N;

    static void update(long[] tree, int node, int start, int end, int idx, int delta) {
        if (idx < start || idx > end) return;
        tree[node] += delta;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(tree, node * 2, start, mid, idx, delta);
        update(tree, node * 2 + 1, mid + 1, end, idx, delta);
    }

    static long query(long[] tree, int node, int start, int end, int l, int r){
        if(r < start || end < l) return 0;
        if(l <= start && end <=r) return tree[node];
        int mid = (start + end) / 2;
        return query(tree, node * 2, start, mid, l,r) + query(tree, node * 2 + 1, mid+1, end, l, r);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        long answer = 1L;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine().trim());

            if (i == 0) {
                update(countTree, 1, 0, MAX, x, 1);
                update(sumTree,   1, 0, MAX, x, x);
                continue;
            }

            long leftCount = (x > 0) ? query(countTree, 1, 0, MAX, 0, x - 1) : 0;
            long leftSum   = (x > 0) ? query(sumTree,   1, 0, MAX, 0, x - 1) : 0;

            long rightCount = (x < MAX) ? query(countTree, 1, 0, MAX, x + 1, MAX) : 0;
            long rightSum   = (x < MAX) ? query(sumTree,   1, 0, MAX, x + 1, MAX) : 0;

            // 비용 = (왼쪽: x*개수 - 합) + (오른쪽: 합 - x*개수)
            long cost = (leftCount * x - leftSum) + (rightSum - rightCount * x);

            cost %= MOD;
            if (cost < 0) cost += MOD; // 음수 모듈러 보정(중요)

            answer = (answer * cost) % MOD;

            update(countTree, 1, 0, MAX, x, 1);
            update(sumTree,   1, 0, MAX, x, x);
        }

        System.out.println(answer);


    }
}

/*
5
18
27

* */
