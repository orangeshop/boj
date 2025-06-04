const fs = require('fs')

const str = fs.readFileSync('/dev/stdin').toString()

var answer = ""

for(var i = 0; i < str.length; i++){
    if(str[i] === str[i].toLowerCase()){
        answer += str[i].toUpperCase();
    }else{
        answer += str[i].toLowerCase();
    }
}

console.log(answer)