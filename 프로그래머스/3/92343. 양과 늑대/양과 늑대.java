import java.util.*;
class Solution {
    int[] left = new int[20];
    int[] right = new int[20];
    int[] value = new int[20];
    int n, answer = 0;
    int[] vis = new int[1<<17];
    
    void solve(int state){
        if(vis[state] == 1) return;
        vis[state] = 1;
        
        int wolf = 0, num = 0;
        for(int i =0; i < n; i++){
            if((state & (1 << i)) != 0){
                num++;
                wolf+=value[i];
            }
        }
        
        if(2*wolf >= num) return;
        
        answer = Math.max(answer, num - wolf);
        
        for(int i =0; i < n; i++){
            if((state & (1<<i)) == 0) continue;
            if(left[i] != -1){
                solve(state | (1<<left[i]));
            }
            if(right[i] != -1){
                solve(state | (1<<right[i]));
            }
        }
    }
    
    
    public int solution(int[] info, int[][] edges) {
        n = info.length;
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for(int i = 0; i < n; i++) value[i] = info[i];
        for(int i = 0; i < n-1; i++){
            int a = edges[i][0]; // 부모
            int b = edges[i][1]; // 자식
            if(left[a] == -1) left[a] = b;
            else right[a] = b;
        }
        solve(1); // 0번 노드만 포함된 상태에서 dfs 시작
        return answer;
    }
}