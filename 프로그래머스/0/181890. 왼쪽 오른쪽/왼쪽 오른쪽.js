function solution(str_list) {
    var answer = [];
    
    var flag = true;
    var idx = 0;
    
    for(var i = 0; i < str_list.length; i++){
        if(str_list[i] === "l"){
            flag = true;
            idx = i;
            break;
        }else if(str_list[i] === "r"){
            flag = false;
            idx = i;
            break;
        }
    }
    
    if(flag){
        console.log("flag " + flag + " " + idx)
        for(var i =0; i < idx; i++){
            answer.push(str_list[i]);
        }
    }else{
        console.log("flag " + flag)
        for(var i = idx+1; i < str_list.length; i++){
            answer.push(str_list[i]);
        }
    }
    
    return answer;
}