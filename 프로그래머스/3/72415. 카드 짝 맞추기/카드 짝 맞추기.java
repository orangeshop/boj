import java.util.*;
import java.math.*;


class Solution {
    
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[] arr = new int[8];
    static boolean[] vis = new boolean[8];
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    static int sx, sy;
    static int[][] tboard = new int[4][4];
    static int[][] ttboard = new int[4][4];
    
    static HashMap<String, String> map = new HashMap<>();

    static class Pair{
        int x, y, cnt;
        int open, openx, openy;
        
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        Pair(int x, int y,int cnt, int open, int openx, int openy){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.open = open;
            this.openx = openx;
            this.openy = openy;
        }
    }
    
    static Pair move(int dir,int x, int y){
        
        Pair cur = new Pair(x,y);
        
        while(true){
            
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];
            
            if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4){
                nx = Math.max(0, Math.min(3, nx));
                ny = Math.max(0, Math.min(3, ny));
                return new Pair(nx,ny);
            }
            
            if(tboard[nx][ny] != 0){
                nx = Math.max(0, Math.min(3, nx));
                ny = Math.max(0, Math.min(3, ny));
                return new Pair(nx,ny);
            }
            
            cur = new Pair(nx,ny);
            
        } 
    }
    
    static void solve(){
        
        System.out.println(Arrays.toString(arr));
        ArrayDeque<Pair> Q = new ArrayDeque<>();
        
        int targetIdx = 0;
        
        int count = 0;
        boolean[][] vis = new boolean[4][4];
        for(int i =0; i < 4; i++){
            for(int k =0; k < 4; k++){
                tboard[i][k] = ttboard[i][k];
            }
        }
        
        // for(int[] bb : tboard){
        //     for(int bbb : bb){
        //         System.out.print(bbb + " ");
        //     }
        //     System.out.println();
        // }
        
        if(arr[targetIdx] == tboard[sx][sy]){
            // System.out.println("***");
            Q.add(new Pair(sx,sy, 1, tboard[sx][sy], sx, sy));
        }else{
            Q.add(new Pair(sx,sy, 0, -1, -1, -1));    
        }
        
        vis[sx][sy] = true;
        
        
        while(!Q.isEmpty()){
            Pair cur = Q.removeFirst();
            
            ArrayDeque<Pair> tq = new ArrayDeque<>();
            
            // if(answer <= cur.cnt) return;
            
            if(count == n){
                System.out.println(cur.x + " " + cur.y + " " + cur.cnt + " " + cur.open + " " + cur.openx + " " + cur.openy);
                
                answer = Math.min(answer, cur.cnt);
                
                return;
            }
            
            for(int dir = 0; dir < 4; dir++){
                
                int nx1 = cur.x + dx[dir];
                int ny1 = cur.y + dy[dir];
                
                if(nx1 < 0 || nx1 >= 4 || ny1 < 0 || ny1 >= 4) continue;
                if(vis[nx1][ny1]) continue;
                tq.add(new Pair(nx1, ny1, cur.cnt+1,cur.open, cur.openx, cur.openy));
                vis[nx1][ny1] = true;
            }
            
            for(int dir = 0; dir < 4; dir++){
                Pair afm = move(dir, cur.x, cur.y);
                int nx2 = afm.x;
                int ny2 = afm.y;
                
                if(nx2 < 0 || nx2 >= 4 || ny2 < 0 || ny2 >= 4) continue;
                if(vis[nx2][ny2]) continue;
                tq.add(new Pair(nx2, ny2, cur.cnt+1, cur.open, cur.openx, cur.openy));
                vis[nx2][ny2] = true;
            }
            
            while(!tq.isEmpty()){
                Pair tcur = tq.removeFirst();
                // System.out.println(tcur.x + " " + tcur.y + " " + tcur.cnt + " " + tcur.open + " " + tcur.openx + " " + tcur.openy);
                
                /*
                dk whssk djfuqsp
                
                만일 open이 -1이 아니라면 내가 타겟하는 카드가 열려있다는 거고 
                이동 했는데 내가 타겟하는 카드랑 동일하다면 해당 카드를 뒤집는다.
                그 후 두 개의 카드를 지워준다.
                
                근데 동일 죄표면 안됨
                
                */
                // System.out.println(tcur.open + " " +  tboard[tcur.x][tcur.y]);
                // System.out.println(tcur.x + " " +  tcur.openx);
                // System.out.println(tcur.y + " " +  tcur.openy);
                
                if(tcur.open == tboard[tcur.x][tcur.y] && (tcur.x != tcur.openx || tcur.y != tcur.openy)){
                    
                    // System.out.println("111111111");
                    count++;
                    tcur.cnt++;
                    tcur.open = -1;
                    tboard[tcur.x][tcur.y] = 0;
                    tboard[tcur.openx][tcur.openy] = 0;
                    tcur.openx = -1;
                    tcur.openy = -1;
                    targetIdx++;
                    
                    // System.out.println(tcur.x + " " + tcur.y + " " + tcur.cnt + " " + tcur.open + " " + tcur.openx + " " + tcur.openy);
                    Q.clear();
                    tq.clear();
                    
                    for(boolean[] nxtVis : vis){
                        Arrays.fill(nxtVis, false);
                    }
                    
                    Q.add(tcur);
                    break;
                }else if(arr[targetIdx] == tboard[tcur.x][tcur.y] && tcur.open == -1){
                    
                    // System.out.println("222222222");
                    
                    tcur.cnt++;
                    tcur.open = arr[targetIdx];
                    tcur.openx = tcur.x;
                    tcur.openy = tcur.y;
                    
                    // System.out.println(tcur.x + " " + tcur.y + " " + tcur.cnt + " " + tcur.open + " " + tcur.openx + " " + tcur.openy);
                    
                    Q.clear();
                    tq.clear();
                    
                    for(boolean[] nxtVis : vis){
                        Arrays.fill(nxtVis, false);
                    }
                    vis[tcur.x][tcur.y] = true;
                    Q.add(tcur);
                    break;
                }
                else{
                    Q.add(tcur);
                }
            }
        }
        
    }
    
    static Pair toPair(String str){
        String[] t = str.split(" ");
        return new Pair(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
    }
    
    
    
    static void dfs(int depth){
        if(depth == n){
            solve();
            return;
        }
        
        for(int i = 1; i <= n; i++){
            if(vis[i]) continue;
            arr[depth] = i;
            vis[i] = true;
            dfs(depth+1);
            arr[depth] = 0;
            vis[i] = false;
        }
    }
    
    public int solution(int[][] board, int r, int c) {
        
        for(int i =0; i < 4; i++){
            for(int k =0; k < 4; k++){
                tboard[i][k] = board[i][k];
                ttboard[i][k] = board[i][k];
                
            }
        }
        
        sx = r;
        sy = c;
        
        for(int i =0; i < 4; i++){
            for(int k =0; k < 4; k++){
                n = Math.max(n, board[i][k]);
            }
        }           
        
        for(int j =1; j <= n; j++){
            
            String f = "";
            String s = "";
            
            for(int i =0; i < 4; i++){
                for(int k =0; k < 4; k++){
                    if(f == "" && board[i][k] == j){
                        f = i + " " + k;
                    }else if (f != "" && board[i][k] == j){
                        s = i + " " + k;
                    }
                }
            }
            
            
            map.put(f,s);
            map.put(s,f);
            
        }
        
        // System.out.println(toPair(map.get("0 0")).x);
        
        dfs(0);
        
        // System.out.println(n);
        
//         arr[0] = 1;
//         arr[1] = 2;
//         arr[2] = 3;
        
//         solve();

        return answer;
    }
}