import java.util.*;

class Solution {
    
    static ArrayDeque<Pair> q = new ArrayDeque<>();
    static boolean[] vis;
    static int N;
    static String[][] T;
    
    static Map<String, List<String>> adj = new HashMap<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        N = tickets.length;
        T = tickets;
        
        for(int i =0; i < N; i++){
            if(tickets[i][0].equals("ICN")){
                System.out.println(i);
            }
        }
        
        return answer;
    }
    
    public static void Solution(int idx){
       
        
    }
    
    static class Pair{
        String a;
        String b;
        
        Pair(String a, String b){
            this.a = a;
            this.b = b;
        }
    }
}