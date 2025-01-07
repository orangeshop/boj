import java.util.*;
import java.math.*;

class Solution {
    /*
    
    격자의 바깥으로는 나갈 수 없습니다.
    
    (x, y)에서 (r, c)까지 이동하는 거리가 총 k여야 합니다. 
    이때, (x, y)와 (r, c)격자를 포함해, 같은 격자를 두 번 이상 방문해도 됩니다.
    
    즉 q를 돌리는데 k 번 미만이면 어디든 가능
    가지치기를 해줘야 할듯 함
    
    

    미로에서 탈출한 경로를 문자열로 나타냈을 때, 문자열이 사전 순으로 가장 빠른 경로로 탈출해야 합니다.
    
    00 01 02
    10 11 12
    20 21 22
    
    d < l < r < u
    */
    
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static String[] rou = {"d","l","r","u"};
    static int[][] cnt;
    static int K, N, M;
    
    
    static Pair start;
    static Pair end;
    
    static ArrayDeque<Pair> Q = new ArrayDeque<>();
    static ArrayList<String> result = new ArrayList<>();
    
    static String answer;
    
    static int calc(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static boolean check = false;
    
    static void dfs(int depth, int x, int y, String str){
        // System.out.println(depth + " " + x +" "+ y +" " + str);
        
        
        if(check == true) return;
        if(depth + calc(x,y,end.x,end.y) > K) return;
        
        
        if(depth == K && x == end.x && y == end.y){
            // System.out.println(str);
            answer = str;
            check = true;
            return;
        }
        
        for(int dir =0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
                
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            dfs(depth + 1, nx, ny, str + rou[dir]);
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";
        
        cnt = new int[n][m];
        
        x -= 1;
        y -= 1;
        r -= 1;
        c -= 1;
        K = k;
        N = n;
        M = m;
        
        start = new Pair(x,y);
        end = new Pair(r,c);
        
        int dis = calc(x,y,r,c);
        if((k - dis) % 2 == 1 || k < dis) return "impossible";
        
        dfs(0,x,y,"");
        
        
        return answer;
    }
    
    static class Pair{
        int x, y, count;
        String route;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        Pair(int x, int y, int count, String route){
            this.x = x;
            this.y = y;
            this.count = count;
            this.route = route;
        }
    }
}