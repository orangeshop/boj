import java.util.*;

class Solution {
    static int[] answer;
    static ArrayList<Integer> ls = new ArrayList<>();
    public int[] solution(long begin, long end) {
        
        int iBegin = (int) begin;
        int iEnd = (int) end;
        
        answer = new int[iEnd - iBegin + 1];
        
        Arrays.fill(answer, -1);
        
        for(int i = iBegin; i <= iEnd; i++){
            answer[i - iBegin] = calc(i);
        }
        
        if(iBegin == 1){
            answer[0] = 0;
        }
        
        return answer;
    }
    
    static int calc(int num){
        int maxNum = 1;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                maxNum = i;
                if(num/i <= 10000000) return num/i;
            }
        }
        
        return maxNum;
    }
}