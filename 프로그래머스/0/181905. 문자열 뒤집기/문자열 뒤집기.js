function solution(my_string, s, e) {
    var answer = '';
    var k = 0;
    for(var i = 0; i < my_string.length; i++){
        if(s <= i && i <= e){
            answer += my_string[e-k];
            k++;
        }
        else{
            answer += my_string[i]
        }
        
    }
    
    return answer;
}