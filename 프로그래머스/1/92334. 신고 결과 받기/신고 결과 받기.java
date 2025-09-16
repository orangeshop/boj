import java.util.*;

class Solution {
    
    public static Map<String, Integer> m = new HashMap<>();
    public static Map<String, Integer> m2 = new HashMap<>();
    
    
    
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> s = new HashSet<String>();
        
        for(int i =0; i < report.length; i++){
            s.add(report[i]);
        }
        
        ArrayList<String> r = new ArrayList<>(s);
        
        // for(int i =0; i < r.size(); i++){
        //     System.out.println(r.get(i));
        // }
        
        int[] answer = new int[id_list.length];
        
        for(int i =0; i < id_list.length; i++){
            m.put(id_list[i], 0);    
            m2.put(id_list[i], 0);    
        }
        
        for(int i =0; i < r.size(); i++){
            String first = r.get(i).split(" ")[0];
            String second = r.get(i).split(" ")[1];
            
            // System.out.println(first + " " + second);
            int num = m.get(second);
            m.put(second, num+1);
        }
        
        for(int i =0; i < r.size(); i++){
            String first = r.get(i).split(" ")[0];
            String second = r.get(i).split(" ")[1];
            
            if(m.get(second) >= k){
                int num = m2.get(first);
                m2.put(first, num+1);
            }
        }
        
        for(int i =0; i < id_list.length; i++){
            answer[i] = m2.get(id_list[i]);
        }
        
        return answer;
    }
}