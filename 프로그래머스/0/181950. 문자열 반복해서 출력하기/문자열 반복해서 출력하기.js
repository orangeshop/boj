const fs = require('fs')

const [a,b] = fs.readFileSync('/dev/stdin').toString().trim().split(' ')

var answer = ""

for(var i = 0; i < b; i++){
    answer += a;
}

console.log(answer)