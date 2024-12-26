import _ from 'lodash';
import { primes } from '../src/primes';

// See https://projecteuler.net/problem=10
describe('summation of primes', () => {
  function compute(limit: number) {
    return primes()
      .filter(p => p < limit)
      .reduce((sum, p) => sum + p, 0);
  }

  test('problem 10', async () => {
    expect(compute(2_000_000)).toBe(142913828922);
  });
});
