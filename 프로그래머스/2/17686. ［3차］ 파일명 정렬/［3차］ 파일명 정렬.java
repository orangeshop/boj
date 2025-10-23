import java.util.*;

class Solution {
    
    static String[] answer;
        
    static class Pair{
        
        int idx;
        
        String originHead;
        String head;
        
        String originNumber;
        int number;
        
        String originTail;
        String tail;
        
        Pair(int idx){
            this.idx = idx;
            this.originHead = "";
            this.head = "";

            this.originNumber = "";
            this.number = 0;
            
            this.tail = "";
            this.originTail = "";
            
        }
    }
    
    static List<Pair> ls = new ArrayList<>();
    static int N;
    
    public String[] solution(String[] files) {
        
        N = files.length;
        
        for(int i =0; i < N; i ++){
            ls.add(new Pair(i));
        }
        
        for(int i =0; i < N; i++){
            String[] result = splitString(files[i]);
            
            ls.get(i).originHead = result[0];
            ls.get(i).head = result[0];
            ls.get(i).head = ls.get(i).head.toUpperCase();
            
            ls.get(i).originNumber = result[1];
            ls.get(i).number = Integer.parseInt(result[1]);
            
            ls.get(i).originTail = result[2];
            ls.get(i).tail = result[2];
            ls.get(i).tail = ls.get(i).tail.toUpperCase();
        }
        
        for(int i =0; i < N; i++){
            // System.out.println(ls.get(i).head + " " + ls.get(i).number + " " + ls.get(i).tail);
            // System.out.println(ls.get(i).originHead + " " + ls.get(i).originNumber + " " + ls.get(i).originTail);
            
        }
        
        ls.sort((o1, o2) -> {
            if(o1.head.equals(o2.head)){
                if(o1.number == o2.number){
                    return o1.idx - o2.idx;
                }
                return o1.number - o2.number;
            }
            return o1.head.compareTo(o2.head);
        });
        
        answer = new String[N];
        
        for(int i =0; i < N; i++){
            // System.out.println(ls.get(i).head + " " + ls.get(i).number + " " + ls.get(i).tail);
            // System.out.println(ls.get(i).originHead + " " + ls.get(i).originNumber + " " + ls.get(i).originTail);
            answer[i] = ls.get(i).originHead + ls.get(i).originNumber + ls.get(i).originTail;
        }
        
        
        return answer;
    }
    
    
    static String[] splitString(String str){
        int numst = -1;
        int numed = -1;
        
        for(int i =0; i < str.length(); i++){
            // System.out.println(str.charAt(i));
            
            if(numst == -1 && '0' <= str.charAt(i) && str.charAt(i) <= '9'){
                numst = i;
            }
            
            if(numed == -1 && numst != -1 && (str.charAt(i) < '0' || '9' < str.charAt(i))){
                // System.out.println(str.charAt(i));
                numed = i;
            }
        }
        
        String tail = "";
        String head = str.substring(0,numst);
        String number = "0";
        
        if(numed == -1){
            // System.out.println(numst + " " + str.length());
            number = str.substring(numst, str.length());
        }else{
            number = str.substring(numst, numed);
        }
        
        if(numed != -1){
            tail = str.substring(numed, str.length());
        }
        
        // System.out.println(head + " " + number + " " + tail);
        
        return new String[]{head, number, tail};
    }
    
    
    
    
    
    
}
