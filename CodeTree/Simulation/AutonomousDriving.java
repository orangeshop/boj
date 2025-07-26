package codetree;

import java.util.*;
import java.io.*;


public class AutonomousDriving {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, C;
    static int[][] board;

    static int answer = -1;

    static Car car;
    static Person person;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    /*
    board에는 일단 시작 점을 표시해야 함
    거리 값을 같이 가지고 있는게 좋은 듯 함

    map -> 1_2 -> 3_3_거리
    
    특정 위치를 뽑기 위해서는 현재의 차 좌표에서 거리가 가장 가까운 곳을 찾아야 함
    확인하는 함수 만들어야함 (거리 리스트가 1개 이상일 경우)
    -> 그 후 지도에서 시작점 지우기 

    0,1,2 -> 시작점
    
    나머지는 자동차 함수에 연료 계산 함수 넣기

    모든 손님을 태울 수 없으면 -1

    */

    static class Car {
        int x;
        int y;
        int charge;

        Car(int x, int y, int charge) {
            this.x = x;
            this.y = y;
            this.charge = charge;
        }

        void setCar(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair bfs() {
            ArrayDeque<Pair> q = new ArrayDeque<>();
            boolean[][] vis = new boolean[N][N];

            q.add(new Pair(this.x, this.y, 0));
            vis[this.x][this.y] = true;

            List<Pair> result = new ArrayList<>();

            int lastCnt = -1;

            while (!q.isEmpty()) {
                Pair cur = q.removeFirst();

                if (board[cur.x][cur.y] == 2) {
                    result.add(new Pair(cur.x, cur.y, cur.count));
                    lastCnt = cur.count;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (board[nx][ny] == 1 || vis[nx][ny]) continue;

                    q.add(new Pair(nx, ny, cur.count + 1));
                    vis[nx][ny] = true;
                }
            }

            result.sort((o1, o2) -> {
                if (o1.count == o2.count) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }

                return o1.count - o2.count;
            });

            if (result.size() > 0) {
                return result.get(0);
            }

            return new Pair(-1, -1);
        }
    }

    static class Pair {
        int x;
        int y;

        int count;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static class Person {
        int remainPersonCount = 0;
        Map<String, String> map = new HashMap<>();

        Person() {
        }
    }

    static void removePerson(int x, int y, int num) {
        board[x][y] = num;
    }

    static int calcDis(int x1, int y1, int x2, int y2) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][N];
        int result = Integer.MAX_VALUE;

        q.add(new Pair(x1, y1, 0));
        vis[x1][y1] = true;

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();

            if (cur.x == x2 && cur.y == y2) {
                result = cur.count;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (board[nx][ny] == 1 || vis[nx][ny]) continue;

                q.add(new Pair(nx, ny, cur.count + 1));
                vis[nx][ny] = true;
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        input();

        while (person.remainPersonCount > 0) {
            if (car.charge == 0) {
                break;
            }
            Pair p = car.bfs();
            if (p == new Pair(-1, -1)) {
                System.out.println(-1);
                return;
            }

            String r = person.map.getOrDefault(p.x + "_" + p.y, "-1_-1_2000000000");
            int rX = Integer.parseInt(r.split("_")[0]);
            int rY = Integer.parseInt(r.split("_")[1]);
            int rDis = Integer.parseInt(r.split("_")[2]);

            if (car.charge - p.count >= rDis) {
                car.charge -= p.count;
                car.charge += rDis;
                removePerson(p.x, p.y, 0);
                person.remainPersonCount--;
                car.setCar(rX, rY);
            } else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(car.charge);
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        person = new Person();
        person.remainPersonCount = M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        car = new Car(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, C);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            if (board[x1][y1] == 1 || board[x2][y2] == 1) continue;

            removePerson(x1, y1, 2);

            int dis = calcDis(x1, y1, x2, y2);

            person.map.put(x1 + "_" + y1, x2 + "_" + y2 + "_" + dis);
        }
    }
}