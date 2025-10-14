import java.util.*;
import java.math.*;


class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int[] arr = new int[15];
    
    static int mineralsSize = 0;
    
    static int[] picksGlobal;
    static String[] mineralsGlobal;
    
    static Map<String, Integer> m = new HashMap<>();


    static int[][] mineBoard = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    public int solution(int[] picks, String[] minerals) {

        mineralsSize = minerals.length;

        picksGlobal = picks.clone();
        mineralsGlobal = minerals.clone();

        Arrays.fill(arr, -1);

        m.put("diamond", 0);
        m.put("iron", 1);
        m.put("stone", 2);

        dfs(0, 0, 0, 0);

        return answer;
    }

    public static void dfs(int depth, int stone, int iron, int dia) {

        if ((stone == picksGlobal[2] && iron == picksGlobal[1] && dia == picksGlobal[0]) || depth * 5 >= mineralsSize) {

            int result = 0;
            int idx = 0;

            for (int i = 0; i < mineralsSize; i++) {
                if (i > 0 && i % 5 == 0) {
                    idx++;
                    if (arr[idx] == -1) break;
                }
                result += mineBoard[arr[idx]][m.get(mineralsGlobal[i])];
            }
            answer = Math.min(result, answer);

            return;
        }

        if (stone < picksGlobal[2]) {
            arr[depth] = 2;
            dfs(depth + 1, stone + 1, iron, dia);
            arr[depth] = -1;
        }

        if (iron < picksGlobal[1]) {
            arr[depth] = 1;
            dfs(depth + 1, stone, iron + 1, dia);
            arr[depth] = -1;
        }

        if (dia < picksGlobal[0]) {
            arr[depth] = 0;
            dfs(depth + 1, stone, iron, dia + 1);
            arr[depth] = -1;
        }
    }
}