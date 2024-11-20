import java.util.*;
import java.math.*;


class Solution {
    static int answer = -1;
    static int n = 0;
    static int m = 0;
    
    public int solution(int[] mats, String[][] park) {
        
        m = park[0].length;
        n = park.length;
        
        int tmp = -1;
        
        for(int i =0; i < n; i++){
            for(int k =0; k < m; k++){
                System.out.println(i + " " + k + " " + park[i][k]);
                // 여기까지 순회
                
                /* 여기서 부터 체크
                만일 -1이 아니라면 넘김
                
                -1이면 한칸씩 확장
                근데 해당 위치에 뭐가 있으면 이전 값이 해당 위치 정해
                
                00 01
                10 11
                
                */
                
                if(!park[i][k].equals("-1")) continue;
                
                for (int j =0; j < 50; j++){
                    
                    boolean check = false;
                    
                    for(int l = i; l < i+j; l++){
                        
                        if(l >= n){
                            check = true;
                            break;
                        }
                        
                        for(int ll = k; ll<k+j; ll++){
                            
                            if(ll >= m) {
                                check = true;
                                break;
                            }
                            
                            if(!park[l][ll].equals("-1")){
                                System.out.println("l " + l + " ll " + ll + " j " + j);
                                check = true;
                                break;
                            }
                        }
                        if(check == true){
                            break;
                        }
                    }
                    
                    if(check == false){
                        tmp = Math.max(tmp, j);
                    }else{
                        break;
                    }
                }
                
            }
        }
        
        System.out.println(tmp);        
                
        
        
        for (int i =0; i < mats.length; i++){
            if (tmp >= mats[i]){
                answer = Math.max(answer, mats[i]);
            }
        }
        
        
        return answer;
    }
}