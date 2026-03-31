package codetree;

import java.io.*;
import java.util.*;

public class PirateCaptainCody {
    static BufferedReader br;
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();

    static int T;

    public static void main(String[] args) throws Exception {
        input();
    }

    static class Pirate {
        int idx;
        int p;
        int r;


        public Pirate(int idx, int p, int r) {
            this.idx = idx;
            this.p = p;
            this.r = r;
        }
    }

    static List<Pirate> pls = new ArrayList<>();

    // idx, pw
    static Map<Integer, Integer> pwMap = new HashMap<>();

    static Map<Integer, Integer> oStMap = new HashMap<>();
    // idx, reload
    static Map<Integer, Integer> stMap = new HashMap<>();

    static Map<Integer, Boolean> chMap = new HashMap<>();



    static PriorityQueue<Pirate> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.p == o2.p) {
            return o1.idx - o2.idx;
        }
        return o2.p - o1.p;
    });

    private static void input() throws Exception {
        System.setIn(new FileInputStream("src/codetree/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 100) {
                int N = Integer.parseInt(st.nextToken());

                for (int k = 0; k < N; k++) {
                    int idx = Integer.parseInt(st.nextToken());
                    int p = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    Pirate pr = new Pirate(idx, p, r);
                    pls.add(pr);
                    pwMap.put(idx, p);
                    stMap.put(idx, 0);
                    oStMap.put(idx, r);
                    chMap.put(idx, true);

                    pq.add(pr);
                }
            } else if (type == 200) {

                int idx = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                Pirate pr = new Pirate(idx, p, r);
                pls.add(pr);

                pwMap.put(idx, p);
                stMap.put(idx, 0);
                oStMap.put(idx, r);
                chMap.put(idx, true);

                pq.add(pr);

            } else if (type == 300) {

                int idx = Integer.parseInt(st.nextToken());
                int pw = Integer.parseInt(st.nextToken());
                pwMap.put(idx, pw);
//                stMap.put(idx,0);
                pq.add(new Pirate(idx, pw, oStMap.get(idx)));
            } else {
                attack(i);
            }

//            rDiscount();

            // reload discount
        }

        System.out.println(sb.toString());
    }

    private static void rDiscount() {

        for (Integer nxt : stMap.keySet()) {

            Integer cur = stMap.get(nxt);

            cur = Math.max(cur - 1, 0);
//            System.out.println(nxt + " " + cur);
            stMap.put(nxt, cur);

            if (cur == 0 && !chMap.get(nxt)) {
                int p = pwMap.get(nxt);
                pq.add(new Pirate(nxt, p, oStMap.get(nxt)));
                chMap.put(nxt, true);
            }
        }

//        System.out.println("r Discount ps size " + pq.size());
    }

    private static void attack(int time) {
        /*
        공격 명령

        사격 대기 상태인 선박 중 공격력이 가장 높은 선박 최대 5척에 일제 사격을 명령합니다.
        공격력이 같다면 선박 번호 id가 작은 선박을 우선 선택하며, 총 피해가 최대가 되도록 선박을 고릅니다.

        사격에 참여한 선박들의 공격력 합만큼 대형 함선에 피해를 줍니다.

        사격한 선박은 즉시 재장전에 들어가며, 사격 시점을 포함해 r시간이 경과하면 다시 사격 대기 상태로 전환됩니다.
        재장전 중인 선박은 공격할 수 없습니다.

        각 명령은 1시간 단위로 실행됩니다. 즉, i번째 명령이 수행된 뒤 1시간이 지나면 i+1번째 명령이 수행됩니다.
        */

//        System.out.println("attack " + pq.size());

        List<Pirate> ls = new ArrayList<>();

        List<Pirate> rest = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        while (!pq.isEmpty()) {
            if (ls.size() == 5) break;

            Pirate cur = pq.poll();

            if (cur.p != pwMap.get(cur.idx)) continue;

            if (stMap.get(cur.idx) > time) {
                rest.add(cur);
                continue;
            }

//            System.out.println(cur.idx + " " + cur.p);

            if(set.contains(cur.idx)) continue;

            ls.add(cur);
            set.add(cur.idx);
        }

//        System.out.println();

        for (Pirate p : ls) {
//            System.out.println("ls" + p.idx + " " + p.p + " " + p.r);
            stMap.put(p.idx, time + p.r);
            chMap.put(p.idx, false);
        }

        pq.addAll(rest);

        int attackSum = 0;
        int attackSize = ls.size();

        for (Pirate p : ls) {
            attackSum += p.p;
        }

        sb.append(attackSum + " ");
        sb.append(attackSize + " ");

        ls.sort((o1, o2) -> {
            if (o1.p == o2.p) {
                return o1.idx - o2.idx;
            }
            return o2.p - o1.p;
        });

        for (Pirate p : ls) {
            sb.append(p.idx + " ");
        }

        sb.append("\n");

//        System.out.println(sb.toString());

    }
}
