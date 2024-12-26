import _ from 'lodash';

export function compute(k: number, e: number) {
  const s = BigInt(Math.pow(k, e)).toString();
  return s.split('').reduce((a, b) => a + _.toNumber(b), 0);
}
