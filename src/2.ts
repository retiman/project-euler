import { fibs } from './core/number-theory';

export function compute(limit: number) {
  return fibs(limit)
    .filter(_ => _ % 2 === 0)
    .reduce((acc, _) => acc + _, 0);
}
