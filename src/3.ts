import { primeFactors } from './core/number-theory';

export function compute(n: number) {
  return Math.max(...primeFactors(n));
}
