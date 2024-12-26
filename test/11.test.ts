import { compute } from '../src/11';

describe('summation of primes', () => {
  test('problem 11', async () => {
    expect(compute()).toBe(70600674);
  });
});
