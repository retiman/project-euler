import _ from 'lodash';
import { lcm } from './core/number-theory';

// See https://projecteuler.net/problem=5
export function compute(n: number) {
  return _.range(1, n + 1).reduce(lcm, 1);
}
