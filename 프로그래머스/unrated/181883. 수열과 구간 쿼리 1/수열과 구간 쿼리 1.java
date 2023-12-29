class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        for(int i = 0; i< queries.length; i++){
            for(int k = queries[i][0]; k <= queries[i][1]; k++){
                arr[k] += 1;
            }
        }
        
        for(int i =0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        
        return arr;
    }
}