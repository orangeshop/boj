function solution(a, d, included) {
    var answer = 0;
    
    var num = a;
    for(var i = 0; i < included.length; i++){
        if(included[i] === true){
            answer += num
        }
        num += d;
    }
    
    return answer;
}