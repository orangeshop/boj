class Solution {
    
    public void dfs(int depth, String st, String target, int pre){
        System.out.println(st);
        
        if(depth == target.length()){
            if (st.equals(target)){
                answer += 1;
            }
            return;    
        }
        
        for(int i =0; i < 4; i++){
            if(pre == i) continue;
            
            int stSize = st.length();
            int arrSize = arr[i].length();
            
            // System.out.println(st + arr[i]);
            
            if (stSize + arrSize > target.length()) continue;
            
            if ((st + arr[i]).equals(target.substring(0, stSize+arrSize))){
                dfs(depth + arr[i].length(), st + arr[i], target, i);
            }
            
        }
        
        
        return;
    } 
    
    static String arr[] = {"aya", "ye", "woo", "ma"};
    static int answer = 0;
    
    public int solution(String[] babbling) {
        
        
        
        for(int i =0; i < babbling.length; i++){
            dfs(0,"", babbling[i], -1);
        }
        
        
        return answer;
    }
}