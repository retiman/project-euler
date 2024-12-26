import _ from 'lodash';

// https://projecteuler.net/problem=40
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
