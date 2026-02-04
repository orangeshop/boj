import * as fs from "fs";

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const N = Number(input[0]);

const sides: { dir: number, dist: number }[] = [];
const count = new Array(5).fill(0);


for (let i = 1; i <= 6; i++) {
    const [d, dist] = input[i].trim().split(/\s+/).map(Number);
    sides.push({ dir: d, dist: dist });
    count[d]++;
}

let totalArea = 1;
let smallArea = 1;

for (let i = 0; i < 6; i++) {
    if (count[sides[i].dir] === 1) {
        totalArea *= sides[i].dist;
    }
    
    if (sides[i].dir === sides[(i + 2) % 6].dir) {
        smallArea *= sides[(i + 1) % 6].dist;
    }
}

console.log((totalArea - smallArea) * N);
