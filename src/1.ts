import { range } from 'lodash';

// See https://projecteuler.net/problem=1
export function compute(limit: number) {
  return range(limit)
    .filter(_ => _ % 3 === 0 || _ % 5 === 0)
    .reduce((acc, _) => acc + _, 0);
}
