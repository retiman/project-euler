import { primes } from './core/number-theory';

export function compute(n: number) {
  return primes()[n - 1];
}
