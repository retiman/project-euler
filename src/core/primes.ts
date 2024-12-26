import _ from 'lodash';
import slurp from './slurp';

// Returns the list of prime numbers.
//
// @remarks
// Cheats.  Uses a precomputed list of primes from {@link script/primes.mjs}.
export default function primes(): number[] {
  return slurp('primes.txt').split('\n').map(_.toNumber);
}
