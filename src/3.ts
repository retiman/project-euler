import { primeFactors } from './core/number-theory';

// See https://projecteuler.net/problem=3
export function compute(n: number) {
  return Math.max(...primeFactors(n));
}
