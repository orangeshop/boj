

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            int[] lis = new int[N];
            int[] lds = new int[N];
            int lisLen = 0;
            int ldsLen = 0;
            for (int k = i + 1; k < N; k++) {
                if (arr[i] < arr[k]) {
                    int l = 0;
                    int r = lisLen-1;

                    while (l <= r) {
                        int mid = (l + r) / 2;
                        if (lis[mid] < arr[k]) {
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }

                    lis[l] = arr[k];
                    if (l == lisLen) lisLen++;
                }

                if (arr[i] > arr[k]) {
                    int l = 0;
                    int r = ldsLen-1;

                    while (l <= r) {
                        int mid = (l + r) / 2;
                        if (lds[mid] < -arr[k]) {
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }

                    lds[l] = -arr[k];
                    if (l == ldsLen) ldsLen++;
                }
            }
            maxLen = Math.max(maxLen, lisLen + ldsLen + 1);
        }

        System.out.println(maxLen);
    }
}
