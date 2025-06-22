class Solution {
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int N = board.length;
        
        for(int dir = 0; dir < 4; dir++){
            int nx = h + dx[dir];
            int ny = w + dy[dir];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            
            if(board[h][w].equals(board[nx][ny])){
                answer++;
            }
            
        }
        
        
        
        
        return answer;
    }
}