import java.util.*;

class Solution {
    
    static int answer = -1;
    static int[] findMax;
    
    public int solution(int[] a) {
        findMax = new int[a.length + 1];
        for(int i =0; i < a.length; i++){
            findMax[a[i]]++;
        }
        
        for(int i =0; i < findMax.length; i++){
            if(findMax[i] <= answer) continue;
            
            int result = 0;
            for(int k =0; k < a.length -1; k++){
                if(a[k] != a[k+1] && (i == a[k] || i == a[k+1])){
                    result++;
                    k++;
                }
            }
            
            answer = Math.max(answer, result);
        }
        
        return answer * 2;
    }
}