import java.util.*;
import java.math.*;


class Solution {
    
    static List<String> ls = new ArrayList<>();
    static List<String> result = new ArrayList<>();
    static String[] answer;
    
    static String[] arr = new String[3000];
    static int[] p = new int[3000];
    
    static int find(int x){
        if(p[x] == x){
            return p[x];
        }
        
        return p[x] = find(p[x]);
    }
    
    static void union(int x, int y){
        int a = find(x);
        int b = find(y);
        
        if(a == b) return;
        
        
        
        p[b] = a;
        arr[b] = arr[a];
    }
    
    
    
    
    public String[] solution(String[] commands) {
        
        for(int i = 0; i < 2505; i++){
            p[i] = i;
        }
        
        for(String nxt : commands){
            String[] input = nxt.split(" ");
            
            // System.out.println(nxt);
            
            if(input[0].equals("UPDATE")){
                if(input.length == 3){
                    
                    for(int i =0; i < 51; i++){
                        for(int k =0; k < 51; k++){
                            if(arr[calc(i,k)] != null && arr[calc(i,k)].equals(input[1])){
                                arr[calc(i,k)] = input[2];    
                            }
                        }
                    }
                    
                }else{
                    int a = Integer.parseInt(input[1]) -1;
                    int b = Integer.parseInt(input[2]) -1;
                    
                    arr[calc(a,b)] = input[3];
                    int j = find(calc(a,b));
                    
                    for(int i =0; i < 2505; i++){
                        if(j == p[i]){
                            arr[i] = input[3];
                        }
                    }
                    
                }
                
            }
            else if(input[0].equals("MERGE")){
                int a = Integer.parseInt(input[1]) -1;
                int b = Integer.parseInt(input[2]) -1;
                int c = Integer.parseInt(input[3]) -1;
                int d = Integer.parseInt(input[4]) -1;
                
                int x = calc(a,b);
                int y = calc(c,d);
                
                if(arr[x] != null && arr[y] != null){
                    union(x,y);
                }
                else if (arr[x] == null){
                    union(y,x);    
                }
                
                union(x,y);
                
            }
            else if(input[0].equals("UNMERGE")){
                int a = Integer.parseInt(input[1]) -1;
                int b = Integer.parseInt(input[2]) -1;
                
                int g = find(calc(a,b));
                String v = arr[g];
                
                for(int i =0; i < 2500; i++){
                    find(i);
                }
                
                for(int i =0; i < 2500; i++){
                    if(p[i] == g){
                        
                        p[i] = i;
                        
                        if(i == calc(a,b)){
                            arr[i] = v;
                        }else{
                            arr[i] = null;
                        }
                    }
                }
                
            }else{
                
                int a = Integer.parseInt(input[1]) -1;
                int b = Integer.parseInt(input[2]) -1;
                
                
                
                // System.out.println(arr[find(calc(a,b))] == null ? "EMPTY" : arr[find(calc(a,b))]);
                
                if(arr[find(calc(a,b))] == null){
                    result.add("EMPTY");
                }else{
                    result.add( arr[find(calc(a,b))]);
                }
                
            }
            
            // for(int i =0; i < 10; i++){
            //     for(int k =0; k < 10; k++){
            //         if(arr[calc(i,k)] == null) {
            //             System.out.print("0 ");
            //         }else{
            //             System.out.print(arr[calc(i,k)] + " ");
            //         }
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
        
        answer = new String[result.size()];
        
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
    
    static int calc(int x, int y){
        return (x * 50) + y;
    }
}