class Solution {
    
    
    
    static int answer = 0;
    
    public int solution(int[] wallet, int[] bill) {
        int roop = 0;
        int x = bill[0];
        int y = bill[1];
        
        while(true){
            
            System.out.println(x + " " + y);
            
            if(x <= wallet[0] && y <= wallet[1] || x <= wallet[1] && y <= wallet[0]){
                answer = roop;
                break;
            }
            
            if(x > y){
                x /= 2;
            }
            else{
                y /= 2;
            }
            
            roop += 1;
            
            
        }
        
        return answer;
    }
}