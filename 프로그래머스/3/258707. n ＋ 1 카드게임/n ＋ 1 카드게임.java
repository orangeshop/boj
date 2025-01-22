import java.util.*;

class Solution {
    
    static int n, Coin;
    
    static List<Pair> ls = new ArrayList<>();
    static boolean[] vis = new boolean[1001];
    
    public int solution(int coin, int[] cards) {
        int answer = 0;
        n = cards.length;
        Coin = coin;
        
        for(int i = 0; i < n/3; i++){
            ls.add(new Pair(0, cards[i]));
        }
        
        int time = 1;
        boolean check = false;
        for(int i = (n/3); i < n; i+= 2){
            
            ls.add(new Pair(time, cards[i]));
            ls.add(new Pair(time, cards[i+1]));
            ls.sort((o1, o2) -> {
                return o1.v - o2.v;
            });
            
            
            if(false == bn()){
                break;
            }
            if(Coin < 0) break;
            time ++;
        }
        
        answer = time;
        
        return answer;
    }
    
    static boolean bn(){
        
        
        List<Pair> tmp = new ArrayList<>();
        
        for(int i = 0; i < ls.size()-1; i++){
            
                
            int l = i;
            int r = ls.size();
            while(l < r){
                
                
                int mid = (l + r) / 2;
                
                if(ls.get(i).v + ls.get(mid).v == n+1){
                    int tCoin = 0;
                    if(ls.get(i).t != 0){
                        tCoin--;
                    }
                    
                    if(ls.get(mid).t != 0){
                        tCoin--;
                    }
                    
                    tmp.add(new Pair(tCoin,i, mid));
                    break;
                }
                
                if(ls.get(i).v + ls.get(mid).v > n+1){
                    r = mid;
                }else if(ls.get(i).v + ls.get(mid).v < n+1){
                    l = mid+1;
                }
            }
        }
        
        
        tmp.sort((o1,o2) -> {
            return o2.cnt - o1.cnt;
        });
        
        
        if(tmp.size() > 0){
            
            if(ls.get(tmp.get(0).idx1).v > ls.get(tmp.get(0).idx2).v){
                ls.remove(tmp.get(0).idx1);
                ls.remove(tmp.get(0).idx2);
            }else{
                ls.remove(tmp.get(0).idx2);
                ls.remove(tmp.get(0).idx1);
            }
            
            Coin += tmp.get(0).cnt;
            
            return true;
        }
        
        return false;
    }
    
    static class Pair{
        int t, v;
        
        int idx1, idx2, cnt;
        
        Pair(int t, int v){
            this.t = t;
            this.v = v;
        }
        
        Pair(int cnt, int idx1, int idx2){
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.cnt = cnt;
        }
        
    }
}