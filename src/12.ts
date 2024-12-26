import { tau } from './core/number-theory';

export function compute(limit: number): number {
  let n = 0;
  let i = 1;

  while (tau(n) <= limit) {
    n += i;
    i += 1;
  }

  return n;
}
