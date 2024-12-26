import { compute } from '../src/10';

describe('summation of primes', () => {
  test.skip('problem 10', async () => {
    expect(compute(2_000_000)).toBe(142913828922);
  });
});
