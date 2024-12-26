import fs from 'fs';
import path from 'path';
import _ from 'lodash';

// See https://projecteuler.net/problem=13
export function compute() {
  const data = fs.readFileSync(path.join('data', '13.txt'), 'utf8');
  const numbers = data.split('\n').map(BigInt);

  const sum = numbers.reduce((a, b) => a + b, BigInt(0));
  const text = sum.toString().slice(0, 10);
  return _.toNumber(text);
}
