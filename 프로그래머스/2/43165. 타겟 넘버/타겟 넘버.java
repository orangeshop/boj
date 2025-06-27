class Solution {
    
    static int T;
    static int N;
    static int answer = 0;
    static int[] arr;
    
    
    static void dfs(int depth, int sum){
        if(depth == N){
            if(sum == T){
                answer++;
            }
            return;
        }
        
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum - arr[depth]);
        
    }
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        T = target;
        arr = numbers;
        
        dfs(0, 0);
        
        return answer;
    }
}