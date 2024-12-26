import * as fs from 'fs';
import { toNumber } from 'lodash';

export function compute(window: number): number {
  const data = fs.readFileSync('data/8.txt', 'utf-8').split('\n').join('');

  let zeroes = 0;
  let max = 0;
  let product = 1;

  // Create the initial window and update the product.
  for (let i = 0; i < window; i++) {
    const digit = toNumber(data[i]);
    if (digit === 0) {
      zeroes++;
      continue;
    }

    product *= digit;
  }

  if (zeroes === 0) {
    max = product;
  }

  // Slide the window through the rest of the data
  for (let i = window; i < data.length; i++) {
    const incoming = toNumber(data[i]);
    const outgoing = toNumber(data[i - window]);

    // Multiply the product by the incoming digit.
    if (incoming !== 0) {
      product *= incoming;
    } else {
      zeroes++;
    }

    // Divide the product by the outgoing digit.
    if (outgoing !== 0) {
      product /= outgoing;
    } else {
      zeroes--;
    }

    // Update max product only if there are no zeros in the current window.
    if (zeroes === 0) {
      max = Math.max(max, product);
    }
  }

  return max;
}
