import _ from 'lodash';

// See https://projecteuler.net/problem=16
export function compute(k: number, e: number) {
  const s = BigInt(Math.pow(k, e)).toString();
  return s.split('').reduce((a, b) => a + _.toNumber(b), 0);
}
