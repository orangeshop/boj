import java.util.*;

class Solution {
    static int[] answer = {};
        
    static Map<String, String> p = new HashMap<>();
    static Map<String, Integer> s = new HashMap<>();
    
    static int N;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        N = enroll.length;
        answer = new int[N];
        
        for (int i = 0; i < N; i++) {
            p.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            calc(seller[i], amount[i] * 100);
        }
        
        for (int i = 0; i < N; i++) {
            answer[i] = s.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
    static void calc(String str, int num){
        int nxt = num / 10;
        s.put(str, s.getOrDefault(str, 0) + num - nxt);
        
        if (nxt > 0 && p.containsKey(str)) {
            calc(p.get(str), nxt);
        }
    }
}