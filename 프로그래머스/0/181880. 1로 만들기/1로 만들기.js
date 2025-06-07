function solution(num_list) {
    var answer = 0;
    
    for(var i = 0; i < num_list.length; i++){
        var num = num_list[i];
        while(true){
            if(num === 1) break;
            
            if(num % 2 === 0){
                num /= 2;
            }else{
                num--;
                num /= 2;
            }
            answer++;
        }
        
        
    }
    
    return answer;
}