package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TagChess {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Base[][] board = new Base[4][4];
    static int answer = 0;

    static int[][] P = {
            {0, 0},
            {-1, 0},
            {-1, -1},
            {0, -1},
            {1, -1},
            {1, 0},
            {1, 1},
            {0, 1},
            {-1, 1}
    };

    static class Base {
        int idx;
        int dir;
        int type; // 0 빈칸, 1 술래, 2 도둑

        public Base(int idx, int dir, int type) {
            this.idx = idx;
            this.dir = dir;
            this.type = type;
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 4; k++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                board[i][k] = new Base(a, b, 2);
            }
        }

        int startScore = board[0][0].idx;
        int startDir = board[0][0].dir;
        board[0][0] = new Base(0, startDir, 1);

        dfs(copyBoard(board), startScore);
        System.out.println(answer);
    }

    static void dfs(Base[][] board, int score) {
        answer = Math.max(answer, score);

        Base[][] movedBoard = thiefMove(copyBoard(board));
        List<Pair> moves = taggerMove(movedBoard);

        if (moves.isEmpty()) {
            return;
        }

        Pair tagger = findTagger(movedBoard);
        for (Pair next : moves) {
            Base[][] nextBoard = copyBoard(movedBoard);
            Base eaten = nextBoard[next.x][next.y];

            nextBoard[tagger.x][tagger.y] = new Base(0, 0, 0);
            nextBoard[next.x][next.y] = new Base(0, eaten.dir, 1);

            dfs(nextBoard, score + eaten.idx);
        }
    }

    static Base[][] thiefMove(Base[][] board) {
        for (int j = 1; j <= 16; j++) {
            subThiefMove(j, board);
        }
        return board;
    }

    static void subThiefMove(int target, Base[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                if (board[i][k].type == 2 && board[i][k].idx == target) {
                    Base thief = board[i][k];

                    for (int d = 0; d < 8; d++) {
                        int ndir = thief.dir + d;
                        if (ndir > 8) {
                            ndir -= 8;
                        }

                        int nx = i + P[ndir][0];
                        int ny = k + P[ndir][1];

                        if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                            continue;
                        }
                        if (board[nx][ny].type == 1) {
                            continue;
                        }

                        thief.dir = ndir;
                        Base tmp = board[nx][ny];
                        board[nx][ny] = thief;
                        board[i][k] = tmp;
                        return;
                    }
                }
            }
        }
    }

    static List<Pair> taggerMove(Base[][] board) {
        Pair tagger = findTagger(board);
        if (tagger.x == -1) {
            return new ArrayList<>();
        }
        return subTaggerMove(board, tagger.x, tagger.y);
    }

    static List<Pair> subTaggerMove(Base[][] board, int x, int y) {
        List<Pair> rls = new ArrayList<>();
        int dir = board[x][y].dir;

        for (int dist = 1; dist <= 3; dist++) {
            int nx = x + P[dir][0] * dist;
            int ny = y + P[dir][1] * dist;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                break;
            }
            if (board[nx][ny].type == 2) {
                rls.add(new Pair(nx, ny));
            }
        }

        return rls;
    }

    static Pair findTagger(Base[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                if (board[i][k].type == 1) {
                    return new Pair(i, k);
                }
            }
        }
        return new Pair(-1, -1);
    }

    static Base[][] copyBoard(Base[][] board) {
        Base[][] copied = new Base[4][4];
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                copied[i][k] = new Base(board[i][k].idx, board[i][k].dir, board[i][k].type);
            }
        }
        return copied;
    }
}
