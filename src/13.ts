import * as fs from 'fs';
import * as path from 'path';

// See https://projecteuler.net/problem=13
export function compute() {
  const data = fs.readFileSync(path.join('data', '13.txt'), 'utf8');
  const numbers = data.split('\n').map(BigInt);

  const sum = numbers.reduce((acc, _) => acc + _, BigInt(0));
  return sum.toString().slice(0, 10);
}
