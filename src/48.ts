import _ from 'lodash';
import mexpt from './core/modular-exponentiation-bigint';

// Computes the last ten digits of the series 1^1 + 2^2 + 3^3 + ... + 1000^1000.
//
// See {@link https://projecteuler.net/problem=48}.
export default function compute(): bigint {
  // This modulus will give use the last 10 digits.
  const mod = BigInt(10 ** 10);
  return _.range(1, 1001)
    .map(BigInt)
    .map(b => mexpt(b, b, mod))
    .reduce((a, b) => (a + b) % mod, 0n);
}
