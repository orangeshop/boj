import java.util.*;
import java.math.*;


class Solution {
    static int N = 1_000_005;

    public int[] solution(int[][] edges) {
        int[] answer = {0,0,0,0};
        // for(int[] nxt : edges){
        //     N = Math.max(N, nxt[0]);
        //     N = Math.max(N, nxt[0]);
        // }
        // N++;
        
        int[] in = new int[N];
        int[] out = new int[N];
        
        for(int[] nxt : edges){
            out[nxt[0]]++;
            in[nxt[1]]++;
        }

        for(int i = 1; i < N; i++){
            if(in[i] == 0 && out[i] >= 2){
                answer[0] = i;
            }
            else if(in[i] >= 1 && out[i] == 0){
                answer[2] ++;
            }
            else if(in[i] >= 2 && out[i] == 2){
                answer[3] ++;
            }
        }
        

        answer[1] = out[answer[0]] - (answer[2] + answer[3]);

        return answer;
    }
}