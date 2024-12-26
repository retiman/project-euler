import _ from 'lodash';

// Computes the product of the digits of the 1st, 10th, 100th, 1000th, 10000th, 100000th, and 1000000th digits of the
// Champernowne constant.
//
// See {@link https://en.wikipedia.org/wiki/Champernowne_constant}.
// See {@link https://projecteuler.net/problem=40}.
export function compute(): number {
  const s = generateChampernowneConstant();

  let result = 1;
  for (let i = 1; i <= 1_000_000; i *= 10) {
    const c = s.charAt(i - 1);
    const j = _.toNumber(c);
    result *= j;
  }

  return result;
}

function generateChampernowneConstant(): string {
  let s = '';
  let num = 1;

  while (s.length < 1_000_000) {
    s += num.toString();
    num++;
  }

  return s;
}
