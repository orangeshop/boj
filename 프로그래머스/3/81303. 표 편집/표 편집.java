import java.util.*;

class Solution {
    
    static class Node{
        Node head;
        Node tail;
        boolean state;
        
        Node(){
            
            this.head = null;
            this.tail = null;
            this.state = true;
        }
    }
    
    static void delete(){
        cur.state = false;
        Node prev = cur.head;
        Node next = cur.tail;
        
        if(prev != null){
            prev.tail = next;
        }
        
        if(next != null){
            next.head = prev;
            cur = next;
        } else{
            cur = prev;
        }
        
        
    }

    static void reStore(){
        Node curr = removeLs.removeLast();
        curr.state = true;
        Node prev = curr.head;
        Node next = curr.tail;
        
        if(prev != null){
            prev.tail = curr;
        }
        
        if(next != null){
            next.head = curr;
        }
        

    }
    
    static int N, K;
    static String answer = "";
    static Node[] ls;
    
    static ArrayDeque<Node> removeLs = new ArrayDeque<>();
    static Node cur;
    
    static StringBuilder sb = new StringBuilder();
    
    public String solution(int n, int k, String[] cmd) {
        N = n;
        K = k;
        ls = new Node[N];
        
        for(int i =0; i < N; i++){
            ls[i] = new Node();
        }
        
        for(int i =1; i < N; i++){
            ls[i-1].tail = ls[i];
            ls[i].head = ls[i-1];
        }
        
        cur = ls[k];
        
        
        for(int i =0; i < cmd.length; i++){
            String[] str = cmd[i].split(" ");
            
            if(str[0].equals("D")){
                int num = Integer.parseInt(str[1]);
                for(int j =0; j< num;j++){
                    cur = cur.tail;
                }
            }else if(str[0].equals("U")){
                int num = Integer.parseInt(str[1]);
                for(int j =0; j < num; j++){
                    cur = cur.head;
                }
            }else if(str[0].equals("C")){
                removeLs.add(cur);
                delete();
            }else if(str[0].equals("Z")){
                
                reStore();
            }
        }
        
        for(int i =0; i < N; i++){
            // System.out.println(i + " " + ls[i].head + " " + ls[i].tail + " " + ls[i].state);
            if(ls[i].state){
                // answer += "O";
                sb.append("O");
            }else{
                // answer += "X";
                sb.append("X");
            }
        }
        
        return sb.toString();
    }
}