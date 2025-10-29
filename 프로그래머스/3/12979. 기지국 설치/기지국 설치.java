import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int size = (w * 2) + 1;
            
        int st = 0;
        int en = 0;
        
        for(int i =0; i < stations.length; i++){
            en = (stations[i]-w)-1;
            
            int result = en - st;
            // System.out.println(st + " " + en);
            
            answer += (result / size);
            
            if(result % size > 0){
                answer++;
            }
            
            st = stations[i]+w;
            if(st >= n) break;
        }
        
        // System.out.println(st + " " + en);
        
        if(st < n){
            int result = n - st;
            answer += (result / size);
            
            if(result % size > 0){
                answer++;
            }
        }

        return answer;
    }
}

/*
station이 오름차순이다.

(W * 2) + 1



*/