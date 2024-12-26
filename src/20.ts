import _ from 'lodash';
import { factorial } from './core/number-theory';

export function compute(limit: number) {
  const text = _.toString(factorial(limit));

  let sum = 0;
  for (let i = 0; i < text.length; i++) {
    sum += _.toNumber(text[i]);
  }

  return sum;
}
