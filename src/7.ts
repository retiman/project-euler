import { primes } from './core/number-theory';

// See https://projecteuler.net/problem=7
export function compute(n: number) {
  return primes()[n - 1];
}
