import java.util.*;
import java.math.*;

/*
상하좌우 인접한 칸으로 옮겨야함

보드 밖으로 이동 금지 및 캐릭터는 발판이 있는곳으로만 이동 가능
다른 발판을 밞는 동시에 사라짐


움직일 차례인데 캐릭터의 상하좌우 주변 4칸이 모두 발판이 없거나 보드 밖이라서 이동할 수 없는 경우, 해당 차례 플레이어는 패배합니다.

두 캐릭터가 같은 발판 위에 있을 때, 상대 플레이어의 캐릭터가 다른 발판으로 이동하여 자신의 캐릭터가 서있던 발판이 사라지게 되면 패배합니다.

a가 먼저 시작


*/


class Solution {
    
    static int[][] gBoard;
    static int N, M;
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    static int Move(int cx, int cy, int ox, int oy, boolean[][] vis){
        if(vis[cx][cy]) return 0;
        
        int ret = 0;
        
        for(int dir = 0; dir < 4; dir++){
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(vis[nx][ny] || gBoard[nx][ny] == 0) continue;
            vis[cx][cy] = true;
            
            int val = Move(ox, oy, nx, ny, vis) + 1;
            
            vis[cx][cy] = false;
            
            if(ret % 2 == 0 && val % 2 == 1) ret = val;
            else if(ret % 2 == 0 && val % 2 == 0) ret = Math.max(ret, val);
            else if(ret % 2 == 1 && val % 2 ==1) ret = Math.min(ret, val);
            
        }
        
        return ret;
        
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        gBoard = board;
        N = board.length;
        M = board[0].length;
        boolean[][] vis = new boolean[N][M];
            
        return Move(aloc[0], aloc[1], bloc[0], bloc[1], vis);
    
    }
}