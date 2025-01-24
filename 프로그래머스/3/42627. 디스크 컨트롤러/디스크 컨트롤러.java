import java.util.*;
import java.math.*;


class Solution {
    
    /*
    a = idx
    입력값 〉 [[5, 10], [6, 8], [14, 2], [11, 5], [100, 7]]
    기댓값 〉 11

    2
    입력값 〉 [[0, 1], [2, 2], [2, 3]]
    기댓값 〉 2

    3
    입력값 〉 [[0, 3], [4, 4], [5, 3], [7, 1]]
    기댓값 〉 4
    
    */
    
    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
        if(o1.t == o2.t){
            if(o1.s == o2.s){
                return o1.idx - o2.idx;
            }
            return o1.s - o2.s;
        }
        return o1.t - o2.t;
    });
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // for(int i =0; i < jobs.length; i++){
        //     pq.add(new Pair(i, jobs[i][0], jobs[i][1]));
        // }
        
        boolean check = false;
        Pair cnt = new Pair(0,0,0);
        
        for(int i =0; i < 500005; i++){
            for(int k = 0; k < jobs.length; k++){
                if(i == jobs[k][0]){
                    pq.add(new Pair(i, jobs[k][0], jobs[k][1]));
                }
            }
            
            if(!check && !pq.isEmpty()){
                check = true;
                cnt = pq.poll();
                
            }
            
            cnt.t--;
            if(cnt.t == 0){
                System.out.println(i);
                answer += i - cnt.s; 
                check = false;
            }
        }
        
       
        return (answer / jobs.length) + 1;
    }
    
    static class Pair{
        int idx, s, t;
        
        Pair(int a, int b, int c){
            this.idx = a;
            this.s = b;
            this.t = c;
        }
    }
}