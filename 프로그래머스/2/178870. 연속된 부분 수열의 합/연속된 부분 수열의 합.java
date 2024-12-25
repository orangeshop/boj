import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,0};
        ArrayDeque<Integer> ls = new ArrayDeque<>();
        int sum = 0;
        int left = 0;
        int right = 0;
        
        
        List<Pair> ans = new ArrayList<>();
        
        for(int i =0; i < sequence.length; i++){
            
            
            sum += sequence[i];
            ls.add(sequence[i]);
            
            if(sum > k){
                // System.out.print("check");
                while(sum > k){
                    // System.out.println("in " + sum);
                    sum -= ls.removeFirst();
                    left++;
                }
            }
            
            // for(Integer a : ls){
            //     System.out.print(a + " ");
            // }
            // System.out.println("----");
            
            if(sum == k){
                ans.add(new Pair(right-left,left, right));
                // System.out.println("answer "+left + " " + right);
                
            }
            
            right++;
            
        }
        
        ans.sort(Comparator.comparingInt(p -> p.minus));
        
        // for(Pair p : ans){
        //     System.out.println(p.x + " " + p.y);
        // }
        
        
        answer[0] = ans.get(0).x;
        answer[1] = ans.get(0).y;
        
        return answer;
    }
    
    static class Pair{
        int minus, x,y;
        
        Pair(int minus, int x, int y){
            this.minus = minus;
            this.x = x;
            this.y = y;
        }
    }
    
}