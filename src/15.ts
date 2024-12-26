import { factorial } from './core/number-theory';

// Computes the number of routes from the upper left to the bottom right of a lattice grid.
//
// @remarks
// It's not necessary to actually generate the routes; we can count them directly. Starting at the upper left, one must
// move down exactly 20 times, and right exactly 20 times in order to reach the bottom right. Represent the downward
// movement as a 'D' and the rightward movement as an 'R', then the number of routes to the bottom right is equal to the
// number of permutations of a 'word' with 20 D's and 20 R's.
//
// This can be viewed as a multiset permutation whose cardinality is the
// multinomial coefficient.
//
// See {@link https://en.wikipedia.org/wiki/Permutation#Permutations_of_multisets}.
// See {@link https://projecteuler.net/problem=15}
export default function compute() {
  const k = factorial(20);
  const n = factorial(20 + 20);
  const d = k * k;

  return n / d;
}
