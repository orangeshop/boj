function solution(order) {
    var answer = 0;
    
    for(var i = 0; i < order.length; i++){
        if(order[i] === "hotcafelatte" 
           || order[i] === "cafelattehot" 
           || order[i] === "cafelatte"
           || order[i] === "icecafelatte"
           || order[i] === "cafelatteice"
          ){
            
            answer += 5000;
        }else{
            answer += 4500;
        }
    }
    
    return answer;
}

