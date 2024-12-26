import { fibs } from './core/number-theory';

// See https://projecteuler.net/problem=2
export function compute(limit: number) {
  return fibs(limit)
    .filter(n => n % 2 === 0)
    .reduce((a, b) => a + b, 0);
}
