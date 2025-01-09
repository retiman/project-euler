// Compute the largest product of of `window` consecutive digits in the given data.
//
// @remarks
// Can be solved with a sliding window algorithm.  We just have to take care to note the number of zeroes in the window;
// if a window has any zeroes in it, thet product of that window will be zero.  At each step, we only compute the
// product if we have no zeroes in the window.
//
// See {@link https://projecteuler.net/problem=8}.
import _ from 'lodash';
import slurp from './core/slurp';

export default function compute(window: number): number {
  const data = slurp('8.txt').split('\n').join('');

  // Keep a running tally of zeroes encountered in the window.  Every time an incoming digit is a zero, we'll increment
  // the count.  Every time an outgoing digit is a zero, we'll decrement the count.
  let zeroes = 0;
  let max = 0;
  let product = 1;

  // Create the initial window and update the product.
  for (let i = 0; i < window; i++) {
    const digit = _.toNumber(data[i]);
    if (digit === 0) {
      zeroes++;
      continue;
    }

    product *= digit;
  }

  if (zeroes === 0) {
    max = product;
  }

  // Slide the window through the rest of the data.
  for (let i = window; i < data.length; i++) {
    const incoming = _.toNumber(data[i]);
    const outgoing = _.toNumber(data[i - window]);

    // Multiply the product by the incoming digit if it's non-zero.
    if (incoming !== 0) {
      product *= incoming;
    } else {
      zeroes++;
    }

    // Divide the product by the outgoing digit if it's non-zero.
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
