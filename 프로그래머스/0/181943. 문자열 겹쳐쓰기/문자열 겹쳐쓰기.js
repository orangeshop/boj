function solution(my_string, overwrite_string, s) {
    var answer = '';
    
    for(var i = 0; i < my_string.length; i++){
        if(i === s){
            for(var k = 0; k < overwrite_string.length; k++){
                answer += overwrite_string[k];
                i++;
            }
            i--;
            continue;
        }
        
        answer += my_string[i];
        
    }
    
    return answer;
}