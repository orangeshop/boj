import java.util.*;

class Solution {
    
    static int[] discount = {10,20,30,40};
    
    static int[] arr;
    static int[] answer = new int[2];
    static int[] emo;
    
    
    static ArrayList<Pair> userls = new ArrayList<>();
    static ArrayList<Pair> result = new ArrayList<>();
    
    static class Pair{
        int x, y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static void solve(){
        // System.out.println(Arrays.toString(arr));
        
        
        int[] disEmo = new int[emo.length];
        
        for(int i =0; i < disEmo.length; i++){
            disEmo[i] =(int) emo[i] - ((emo[i]* arr[i]) / 100);
        }
        
        
        // System.out.println(Arrays.toString(disEmo));
        
        /*
        유저의 할인 기준 이상의 할인율은 모두 구매를 한다.
        구매 비용이 유저가 가진 돈 보다 많아 지면 구독을 한다.
        
        */
        
        int goodock = 0;
        int money = 0;
        int[] val = new int[userls.size()];
        
        for(int i =0; i < userls.size(); i++){
            
            
            
            for(int k = 0; k < emo.length; k++){
                if(arr[k] >= userls.get(i).x){
                    val[i] += disEmo[k];
                }else{
                    // val[i] += emo[k];
                }
            }
            
            if(val[i] > userls.get(i).y){
                val[i] = userls.get(i).y + 1;
            }
        }
        
        for(int i =0; i < val.length; i++){
            if(val[i] >= userls.get(i).y){
                goodock ++;
            }else{
                money += val[i];
            }    
        }
        
//         System.out.println("val "+Arrays.toString(val));
        
//         System.out.println(goodock + " " + money);
        
//         System.out.println();
        
        result.add(new Pair(goodock, money));
        
    }
    
    static void dfs(int depth){
        
        if(depth == emo.length){
            solve();
            return;
        }
        
        for(int i =0; i < 4; i++){
            arr[depth] = discount[i];
            dfs(depth+1);
            arr[depth] = 0;   
        }
    }
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        for(int i =0; i < users.length; i++){
            userls.add(new Pair(users[i][0], users[i][1]));
        }
        
        emo = emoticons;
        
        arr = new int[emo.length];
        
//         System.out.println(Arrays.toString(emo));
        
        dfs(0);
        
        result.sort((o1, o2) -> {
            if(o1.x == o2.x){
                return o2.y - o1.y; 
            }
            return o2.x - o1.x; 
        });
        
//         for(Pair nxt : result){
//             System.out.println(nxt.x + " " + nxt.y);
//         }
        
        answer[0] = result.get(0).x;
        answer[1] = result.get(0).y;
               
        return answer;
    }
}