import java.util.*;


class Solution {
    static int[] answer;
    
    static Map<String, ArrayList<Integer>> m = new HashMap<>();
    
    static Set<String> r = new HashSet<>();
        
    static void dfs(String[] arr, String str, int depth){
        
        if(depth == 4){
            
            ArrayList<Integer> t = m.getOrDefault(str, new ArrayList<>());
            t.add(Integer.parseInt(arr[4]));
            m.put(str, t);
            
            
            r.add(str);
            
            return;
        }
        
        dfs(arr, str + "-", depth + 1);
        dfs(arr, str + arr[depth], depth + 1);
    }
    
    static int binary(ArrayList<Integer> ls, int target){
        
        int s = 0;
        int e = ls.size();
        
        while(s < e){
            int mid = (s + e) / 2;
            
            if(ls.get(mid) < target){
                s = mid + 1;
            }else{
                e = mid;
            }
        }
        // System.out.println(target);
        // System.out.println(s + " " + e);
        // System.out.println(Arrays.toString(ls.toArray()));
        return ls.size() - s;
    }
    
    public int[] solution(String[] info, String[] query) {
        
        answer = new int[query.length];
        
        for(int i =0; i < info.length; i++){
            String[] cur = info[i].split(" ");
            dfs(cur, "", 0);
        }
        
        // for(int i =0; i < r.size(); i++){
        //     m.get(r.get(i)).sort((o1, o2) -> {
        //         return o1 - o2;
        //     });
        // }
        
        for(String s : r){
            m.get(s).sort((o1, o2) -> {
                return o1 - o2;
            });
        }
        
        for(int i =0; i < query.length; i++){
            String[] arr = query[i].split(" ");
            String ss = arr[0] + arr[2] + arr[4] + arr[6];
            
            ArrayList<Integer> ls = m.getOrDefault(ss, new ArrayList<>());
            
            if(ls.isEmpty()){
                answer[i] = 0;
            }else{
                int target = Integer.parseInt(arr[7]);
                answer[i] = binary(m.get(ss), target);
            }
            
        }
        
        return answer;
    }
    
}