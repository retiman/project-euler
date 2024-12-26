import { range } from 'lodash';
import { lcm } from './core/number-theory';

export function compute(n: number) {
  return range(1, 20 + 1).reduce(lcm);
}
