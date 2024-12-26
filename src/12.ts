import { tau } from './core/number-theory';

// See https://projecteuler.net/problem=12
export function compute(limit: number): number {
  let n = 0;
  let i = 1;

  while (tau(n) <= limit) {
    n += i;
    i += 1;
  }

  return n;
}
