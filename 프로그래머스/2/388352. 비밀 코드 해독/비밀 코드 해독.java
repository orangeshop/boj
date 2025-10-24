import java.util.*;

class Solution {
    static int answer = 0;
    static int N, A;
    
    static int[][] gQ;
    static int[] gAns;
    
    static boolean check(int[] arr){
        
        
        for(int i =0; i < gQ.length; i++){
            int cnt = 0;
            
            for(int k =0; k < 5; k++){
                for(int j =0; j < 5; j++){
                    if(arr[k] == gQ[i][j]){
                        // System.out.println(arr[k] + " " + gQ[i][j]);
                        cnt++;
                        break;
                    }
                }
            }
            
            if(gAns[i] != cnt){
                return false;
            }
        }
        
        // System.out.println(Arrays.toString(ans));
        // System.out.println(Arrays.toString(arr));
        
        
        return true;
    }
    
    static void dfs(int depth, int idx, ArrayDeque<Integer> q){
        if(q.size() == 5){
            int[] t = new int[5];
            ArrayList<Integer> ls = new ArrayList<>(q);
            
            for(int i = 0; i < 5; i++){
                t[i] = ls.get(i);
            }
            
            if(check(t)){
                answer++;
            }
            
            return;
        }
        
        for(int i = idx; i <= N; i++){
            q.add(i);
            dfs(depth+1,i+1, q);
            q.removeLast();
        }
        
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        A = ans.length;
        gQ = q.clone();
        gAns = ans.clone();
        
        ArrayDeque<Integer> qq = new ArrayDeque<>();
        dfs(0,1, qq);
        
        return answer;
    }
}