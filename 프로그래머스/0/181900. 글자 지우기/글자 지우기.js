function solution(my_string, indices) {
    var answer = '';
    var check = new Array(my_string.length);
    
    for(var i = 0 ; i < indices.length; i++){
        check[indices[i]] = true;
    }
    
    for(var i = 0; i < my_string.length; i++){
        if(check[i] === true) continue
        answer += my_string[i]
    }
    
    console.log(check)
    
    return answer;
}