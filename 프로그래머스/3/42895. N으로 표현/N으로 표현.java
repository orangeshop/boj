import java.util.*;

class Solution {
    static Set<Integer>[] set = new HashSet[10];
    static int answer = 0;
    
    
    public int solution(int N, int number) {
        
        for(int i =0; i < 10; i++){
            set[i] = new HashSet<>();
        }
        
        set[1].add(N);
        
        for(int i =2; i < 9; i++){
            for(int k = 1; k < i; k++){
                Set<Integer> s1 = set[i-k];
                Set<Integer> s2 = set[k];
                
                for(int ss1 : s1){
                    for(int ss2 : s2){
                        set[i].add(ss1 + ss2);
                        set[i].add(ss1 - ss2);
                        set[i].add(ss1 * ss2);
                        if(ss1 == 0 || ss2 == 0) continue;
                        set[i].add(ss1 / ss2);
                    }
                }
            }
            
            set[i].add(calc(N, i));

            System.out.println();
        }
        
        for(int i = 1; i < 9; i++){
            for(int s : set[i]){
                if(s == number){
                    return i;
                }
            }
        }
        
        
        return -1;
    }
    
    static int calc(int s, int s2){
        
        String num = "";
        
        for(int i =0; i < s2;i++){
            num += s;
        }
        
        return Integer.parseInt(num);
    }
}