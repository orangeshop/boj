import java.math.*;
import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int left = 0;
        int right = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int a = arrayA[0];
        int b = arrayB[0];
        
        
        for(int i =1; i < arrayA.length; i++){
            a = gcd(arrayA[i],a);
            b = gcd(arrayB[i],b);
        }
        
        if(!div(arrayB, a)){
            answer = Math.max(answer, a);
        }
        
        if(!div(arrayA, b)){
            answer = Math.max(answer, b);
        }
        
        return answer;
    }
    
    static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
    
    static boolean div(int[] arr, int a){
        for(Integer num : arr){
            if (num % a == 0){
                return true;
            }
        }
        
        return false;
    }
}