import java.util.*;

class Solution {
    static int answer = 0;
    
    static Map<String, Integer> m = new HashMap<>();
    static List<Integer> ls = new ArrayList<>();
    static int[] arr;
    
    static int max = 0;
    
    static void dfs(int depth){
        
        if(depth == arr.length){
            // System.out.println(Arrays.toString(arr));
            answer += 1;
            return;
        }
        
        
        for(int i = 0; i < arr[depth]; i++){
            arr[depth] -= 1;
            dfs(depth + 1);
            arr[depth] += 1;
        }

        dfs(depth + 1);
            
        // }
    }
    
    public int solution(String[][] clothes) {
        
        for(int i = 0; i < clothes.length; i++){
            int v = m.getOrDefault(clothes[i][1], 0);
            m.put(clothes[i][1], ++v);
        }
        
        for(Integer num : m.values()){
            // System.out.println(num);
            ls.add(num);
        }
        
        arr = new int[ls.size()];
        
        for(int i = 0; i < ls.size(); i++){
            arr[i] = ls.get(i);
            max += ls.get(i);
        }
        
        dfs(0);
        
        
        return answer -1;
    }
}