import { primes } from './core/number-theory';

// See https://projecteuler.net/problem=10
export function compute(limit: number) {
  return primes()
    .filter(p => p < limit)
    .reduce((a, b) => a + b, 0);
}
