import compute from '../src/3';

describe('largest prime factor', () => {
  test('problem 3', async () => {
    expect(compute(600851475143)).toBe(6857);
  });
});
