
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static void init(long a[], long tree[], int node, int start, int end) {
		if (start == end) {
			tree[node] = a[start];
		}else {
			init(a, tree, node * 2, start, (start + end) / 2);
			init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}
	
	static long query(long tree[], int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		long lsum = query(tree, node * 2, start, (start + end) / 2, left, right);
		long rsum = query(tree, node * 2 + 1, (start + end) / 2 + 1, end , left, right);
		return lsum + rsum;
	}
	
	static void update(long a[], long tree[], int node, int start, int end, int index, long val) {
		if (index < start || index > end) {
			return;
		}
		if (start == end) {
			a[index] = val;
			tree[node] = val;
			return;
		}
		
		update(a, tree, node * 2, start, (start + end) /2 , index, val);
		update(a, tree, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
		tree[node] = tree[node * 2] + tree[node * 2 +1];
	}
	
	
	static int getTreeSize(int n) {
		int h = (int)Math.ceil(Math.log(n)/Math.log(2));
		return (int) Math.pow(2, h+1);
	}
	
	static int N;
	static int Q;
	static long[] element, tree;
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		element = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			element[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = getTreeSize(N);
		
		tree = new long[size];
		init(element, tree,1, 0,N-1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			if (x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}
			
			int idx = Integer.parseInt(st.nextToken())-1;
			int val = Integer.parseInt(st.nextToken());
			
			long pSum = query(tree,1, 0, N-1, x,y);
			sb.append(pSum+"\n");
			
//			long dif = val - element[idx];
			update(element, tree, 1, 0, N-1, idx, val);
//			element[idx] = val;
		}
		
		System.out.println(sb.toString());
		
		
		
		
	}

}
