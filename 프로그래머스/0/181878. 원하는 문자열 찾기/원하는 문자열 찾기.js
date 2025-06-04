function solution(myString, pat) {
    var answer = 0;
    var mSize = myString.length;
    var size = pat.length;
    

    
    for(var i =0; i < mSize - size+1; i++){
        var str = myString.substring(i, i + size);
        var uStr = str.toUpperCase();
        var pStr = pat.toUpperCase();
        // console.log(uStr + " " +  pStr)
        if(uStr === pStr){
            return 1;
        }
        
    }
    
    return answer;
}