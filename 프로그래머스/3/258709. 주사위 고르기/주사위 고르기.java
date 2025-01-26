import java.util.*;
class Solution {
    
    static int n;
    static boolean[] vis;
    static int[][] gDice;
    static int gAns = 0;
    static int[] answer = {};
    
    static void solve(int[] arr){
        int[] A = new int[n/2];
        int[] B = new int[n/2];
        
        int aidx = 0;
        int bidx = 0;
        
        for(int i =0; i < n; i++){
            if(vis[i] == true){
                A[aidx] = i;
                aidx++;
            }else{
                B[bidx] = i;
                bidx++;
            }
        }
        
//         System.out.println(Arrays.toString(A));
//         System.out.println(Arrays.toString(B));
//         System.out.println();
        
       
        ArrayList<Integer> Als = new ArrayList<>();
        ArrayList<Integer> Bls = new ArrayList<>();
    
        
        int[] s = new int[n];
        calc(0, s ,A, Als);
        // System.out.println(Arrays.toString(Als.toArray()));
        
        
        Arrays.fill(s, 0);
        calc(0, s ,B, Bls);
        
        Bls.sort((o1, o2) -> {
            return o1 - o2;
        });
        // System.out.println(Arrays.toString(Bls.toArray()));
        
        int count = 0;
        
        for(int i =0; i < Als.size(); i++){
            int target= Als.get(i);
            int l = 0;
            int r = Bls.size();
            
            int idx = Integer.MIN_VALUE;
            
            while(l < r){
                int mid = (l+r) /2;
                
                if(Bls.get(mid) < target){
                    idx = Math.max(idx, mid);
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
            
            if(idx != Integer.MIN_VALUE){
                count += idx + 1;
            }
            
        }
        
        int tmpAns = gAns;
        
        gAns = Math.max(gAns, count);
        if(gAns != tmpAns){
            answer = A;
            for(int i =0; i < answer.length; i++){
                answer[i]++;
            }
        }
        
        
        // System.out.println(count);
        // System.out.println();
    }

    
    static void calc(int depth, int[] sum, int[] x, ArrayList<Integer> tmp){
        if(depth == x.length){
            int total = 0;
            for(int t: sum){
                total += t;
            }
            
            tmp.add(total);
            return;
        }
        
        for(int k =0; k < 6; k++){
            sum[depth] = gDice[x[depth]][k];
            calc(depth + 1, sum, x, tmp);
            sum[depth] = 0;
        }
        
    }
    
    
    static void dfs(int depth, int[] arr, int cnt){
        
        // if(arr[0] != 0) return;
        
        if(depth == n/2){
            // System.out.println(Arrays.toString(arr));
            solve(arr);
            return;
        }
        
        
        
        for(int i = cnt; i < n; i++){
            if(vis[i]) continue;
            vis[i] = true;
            arr[depth] = i;
            dfs(depth+1, arr, i);
            arr[depth] = -1;
            vis[i] = false;
        }
    }
    
    
    public int[] solution(int[][] dice) {
        
        n = dice.length;
        int[] arr = new int[n];
        vis = new boolean[n];
        
        gDice = dice;
        
        // Arrays.fill(arr, 0);
        
        dfs(0, arr,0);
        
        return answer;
    }
}