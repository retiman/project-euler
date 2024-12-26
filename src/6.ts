import { range } from 'lodash';

export function compute(limit: number) {
  const a = range(limit + 1)
    .map(_ => _ ** 2)
    .reduce((acc, _) => acc + _, 0);
  const b = range(limit + 1).reduce((acc, _) => acc + _, 0) ** 2;
  return b - a;
}
