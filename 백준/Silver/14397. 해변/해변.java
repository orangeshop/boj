import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine();
        }

        int[] dr = {-1, -1, 0, 0, 1, 1};
        int[] dc0 = {-1, 0, -1, 1, -1, 0};
        int[] dc1 = {0, 1, -1, 1, 0, 1};

        int answer = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r].charAt(c) == '#') {
                    int[] dc = (r % 2 == 0) ? dc0 : dc1;

                    for (int dir = 0; dir < 6; dir++) {
                        int nr = r + dr[dir];
                        int nc = c + dc[dir];

                        if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                            if (board[nr].charAt(nc) == '.') {
                                answer++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
        sc.close();
    }
}