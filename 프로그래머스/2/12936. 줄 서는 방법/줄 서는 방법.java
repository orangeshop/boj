import java.util.*;

class Solution {
    
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long f = 1;
        ArrayList<Integer> ls = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            f *= i;
            ls.add(i);
        }
        k -= 1;
        int idx = 0;
        while(idx < n){
            f /= n - idx;
            answer[idx++] = ls.remove((int) (k/f));
            k %= f;
        }
        
        return answer;
    }
}