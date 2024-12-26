import java.util.*;
import java.math.*;


class Solution {
    static int[] answer;
    
    static int[] arr = {0,0,0,0,0,0,0,0,0,0,0};
    static int N;
    static int[] gInfo = new int[11];
    
    
    static int result = -1;
    static int[] resultArr = {0,0,0,0,0,0,0,0,0,0,0};
    
    static List<Integer> ls = new ArrayList<>();
    static List<String> sls = new ArrayList<>();
    
    public int[] solution(int n, int[] info) {
        
        N = n;
        
        for(int i =0; i < 11; i++){
            gInfo[i] = info[i];
        }
        
        dfs(0, 0);
        
        for(int i =0; i < 11; i++){
            System.out.print(resultArr[i] + " ");
        }
        
        // for(int i =0; i < 10; i++){
        //     System.out.println(ls.get(i));
        // }
        
        if(result == -1){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[11];
            for(int i =0; i < 11; i++){
                answer[i] = resultArr[i];
            }
        }
        
        return answer;
    }
    
    public void dfs(int depth, int sum){
        
        if(depth == 11){
            if(sum == N){
                int[] score = {10,9,8,7,6,5,4,3,2,1,0};
                
                int a = 0;
                int l = 0;
                
                for(int i =0; i < 11; i++){
                    if(arr[i] == 0 && gInfo[i] == 0) continue;
                    if(arr[i] <= gInfo[i]){
                        a += score[i];
                    }
                    else{
                        l += score[i];
                    }
                }
                
//                 int pre = result;
                
//                 result = Math.max(result, l - a);
                if(l > a){
                    
                    int cnt = l - a;
                    
                    if(cnt > result){
                        // for(int i = 0; i < 11; i++){
                        //     resultArr[i] = arr[i];
                        // }
                        
                        result = cnt;
                        resultArr = arr.clone();
                    }
                    else if(cnt == result){
                        for(int i = 10; i >= 0; i--){
                            if(arr[i] > resultArr[i]){
                                resultArr = arr.clone();
                            }
                            else if(arr[i] < resultArr[i]) return;
                        }
                    }
                }
                
                
            }
            
            
            return;
        }
        
        arr[depth] = gInfo[depth] + 1;
        dfs(depth + 1, sum + gInfo[depth] + 1);
        arr[depth] = 0;
        
        if(gInfo[depth] != 0){
            for(int i =0; i <= gInfo[depth]; i++){
                arr[depth] = i;
                dfs(depth + 1, sum + i);
                arr[depth] = 0;
            }
        }
        
        dfs(depth + 1, sum);
        
    }
    
}