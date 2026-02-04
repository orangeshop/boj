import * as fs from 'fs';

const arr = fs.readFileSync('/dev/stdin').toString().split('\n');

// const arr = fs.readFileSync("./input.txt").toString().split('\n');
let answer: number[] = [];

function dfs(depth: number, tmp: number[]) {
    // console.log(tmp);
    if (depth > 9) return;
    if (tmp.length == 7) {

        const result = [...tmp].sort((a, b) => {
            return a - b
        });


        const sum = result.reduce((acc, value) => acc + value, 0);
        // console.log(result)
        if (sum == 100) {
            // console.log(result)
            answer = result;
        }
        return;
    }

    tmp.push(Number(arr[depth]));
    dfs(depth + 1, tmp);
    tmp.pop()

    dfs(depth + 1, tmp);
}

dfs(0, []);

answer.forEach(value => {
    console.log(value);
});

