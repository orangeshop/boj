function solution(str1, str2) {
    var answer = '';
    var size = str1.length;
    var a = 0, b = 0;
    for(var i = 0; i < (str1.length + str2.length); i++){
        if(i % 2 == 0){
            answer += str1[a];
            a++;
        }else{
            answer += str2[b];
            b++;
        }
    }
    
    console.log(answer)
    return answer;
}