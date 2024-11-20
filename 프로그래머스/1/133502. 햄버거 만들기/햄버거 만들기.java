import java.util.*;

class Solution {
    static int answer = 0;
    Stack<Integer> S = new Stack<Integer>();
    List<Integer> ls = new ArrayList<>();
    
    int[] arr = {1,3,2,1};
    
    public int solution(int[] ingredient) {
        
        for(int item : ingredient){
            
            S.push(item);
            
            if(S.size() >= 4){
                
                if(S.get(S.size()-1) == 1 && 
                   S.get(S.size()-2) == 3 && 
                   S.get(S.size()-3) == 2 && 
                   S.get(S.size()-4) == 1
                  ){
                    
                    answer += 1;
                    S.pop();
                    S.pop();
                    S.pop();
                    S.pop();
                }
                
                
            }
        }
        
        return answer;
    }
}