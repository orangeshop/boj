import java.util.*;

class Solution {
    
    public static Map<String, Integer> m = new HashMap<>();
    
    private static void init(){
        for(int i = 0; i < 27; i++){
            String s = (char) ('A' + i) + "";
            // System.out.println(s);
            m.put(s, i + 1);
        }
    }
    
    private static String[] board = new String[1006];
    private static String msgG;
    
    public int[] solution(String msg) {
        List<Integer> ans = new ArrayList<>();
        int[] answer;
        msgG = msg;
        init();
        
        int cnt = 27;
        
        
        for(int i = 0; i <  msg.length(); i++){
            // 이미 압축된 값이 있으면 다음 값까지 비교
            // System.out.println(i);
            int idx = i+1;
            int result = 0;
            int loop = 0;
            while(true){
                if(idx > msg.length()) break;
                String str = msg.substring(i, idx);
                // System.out.println(str);
                int t = m.getOrDefault(str, -1);
                
                if(t == -1){
                    m.put(str, cnt);
                    cnt++;
                    
                    break;
                }else{
                    
                    result = t;
                }
                idx++;
                loop++;
            }
            i += loop-1;
            ans.add(result);
            
        }
        
        
        answer = new int[ans.size()];
        
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    private class Pair{
        int idx;
        String str;
        
        Pair(int idx, String str){
            this.idx = idx;
            this.str = str;
        }
    }
}