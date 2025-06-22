function solution(X, Y) {
    var answer = '';
    
    var xArr = new Array(10).fill(0)
    var yArr = new Array(10).fill(0)
    
    for(var i =0; i < X.length; i++){
        xArr[X[i]]++;
    }
    
    for(var i =0; i < Y.length; i++){
        yArr[Y[i]]++;
    }
    
    for(var i = 9; i >= 0 ; i--){
        
        if (xArr[i] && yArr[i]){
            answer += String(i).repeat(Math.min(xArr[i], yArr[i]));
        }
    }
    
    if (answer === '') return "-1";
    if (answer[0] === '0') return "0";
    
    return answer;
}