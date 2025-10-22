import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] stones, int k) {
        
        ArrayDeque<Integer> w = new ArrayDeque<>();
        ArrayList<Integer> ls = new ArrayList<>();
        
        for(int i = 0; i < stones.length; i++){
            
            // System.out.println(w.size());
            
            if(!w.isEmpty() && w.getFirst() == i - k){
                w.removeFirst();
            }
            
            while(!w.isEmpty() && stones[w.getLast()] < stones[i]){
                w.removeLast();
            }
            
            w.addLast(i);
            
            if(i >= k -1){
                ls.add(stones[w.getFirst()]);
            }
        }
        
        // System.out.println();
        // for(int n : ls){
        //     System.out.println(n);
        // }
        
        ls.sort((o1, o2) -> {
            return o1 - o2;
        });
        
        return ls.get(0);
    }
    
}

/*

k 길이의 이상 구간을 구하면 된다.
슬라이딩 윈도우로 해당 구간의 맥스값이 가장 작은 값이 답이다.

구간의 최대값인데 그들 중 가장 작은 최댓값

*/