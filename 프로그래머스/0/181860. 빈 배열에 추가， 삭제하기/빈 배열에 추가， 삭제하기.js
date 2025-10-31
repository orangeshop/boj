function solution(arr, flag) {
    var answer = [];
    for(var i = 0; i < arr.length; i++){
        if(flag[i] === true){
            for(var k = 0; k < arr[i] * 2; k++){
                answer.push(arr[i]);
            }
        }else{
            for(var k = 0; k < arr[i]; k++){
                answer.pop();
            }
        }
    }
    
    return answer;
}