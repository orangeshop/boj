class Solution {
    static int[] answer;
    public int[] solution(int n, int s) {
        
        if(n > s) {
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[n];
            
            int t = s / n;
            int r = s % n;
            
            // System.out.println(t + " " + r);
            for(int i =0; i < n; i++){
                answer[i] = t;
            }
            
            int cnt = 0;
            for(int i = n-1; i >= 0; i--){
                if(cnt == r) break;
                answer[i] ++;
                cnt++;
            }
        }
        
        
        
        
        return answer;
    }
}