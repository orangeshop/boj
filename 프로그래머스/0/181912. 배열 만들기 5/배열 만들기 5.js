function solution(intStrs, k, s, l) {
    var answer = [];
    
    for(var i = 0; i < intStrs.length; i++){
        var result = intStrs[i].substring(s,s+l);
        console.log(result)
        if(result > k){
            answer.push(Number(result))
        }
    }
    
    return answer;
}