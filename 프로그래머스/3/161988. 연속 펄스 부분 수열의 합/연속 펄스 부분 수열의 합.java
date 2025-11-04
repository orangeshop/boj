import java.util.*;

class Solution {
    /*
    [2, 3, -6, 1, 3, -1, 2, 4]
    [1,-1,  1,-1, 1, -1, 1,-1]
    
    2, -3, -6, -1, 3, 1, 2, -4
    
    
    [ 2, 3, -6, 1, 3, -1, 2, 4]
    [-1, 1, -1, 1, -1, 1,-1, 1]
    
    -2, 3, 6, 1, -3, -1, -2, 4
    
    */
    
    static long[] arr1;
    static long[] arr2;
    static long answer = 0;
        
    public long solution(int[] sequence) {
        
        arr1 = new long[sequence.length];
        arr2 = new long[sequence.length];
        
        for(int i =0; i < sequence.length; i++){
            if(i % 2 == 0){
                arr1[i] = sequence[i] * 1;
            }else{
                arr1[i] = sequence[i] * -1;
            }
        }
        
        for(int i =0; i < sequence.length; i++){
            if(i % 2 != 0){
                arr2[i] = sequence[i] * 1;
            }else{
                arr2[i] = sequence[i] * -1;
            }
        }
        
        // System.out.println(calc(arr1));
        // System.out.println(calc(arr2));
        
        return Math.max(calc(arr1), calc(arr2));
    }
    
    static long calc(long[] arr){
        long curMax = arr[0];
        long globalMax = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            curMax = Math.max(arr[i], curMax + arr[i]);
            
            if(curMax > globalMax){
                globalMax = curMax;
            }
        }
        
        return globalMax;
    }
}