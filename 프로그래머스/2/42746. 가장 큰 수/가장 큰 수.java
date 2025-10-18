import java.util.*;

class Solution {
    static String answer = "";
    static ArrayList<String> ls = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public String solution(int[] numbers) {
        
        for(int n : numbers){
            ls.add(n+"");
        }
        
        ls.sort((o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });
        
        for (String str : ls) {
            sb.append(str);
        }
        
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}