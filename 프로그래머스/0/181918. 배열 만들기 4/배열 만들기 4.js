function solution(arr) {
    var stk = [];
    var idx = 0;
    
    
    while(idx < arr.length){
        // console.log(stk)
        if(stk.length === 0){
            stk.push(arr[idx]);
            idx += 1;
            continue;
        }
        
        if(stk[stk.length - 1] >= arr[idx]){
            stk.pop();
        }else{
            stk.push(arr[idx]);
            idx += 1;
        }
    }
    
    return stk;
}