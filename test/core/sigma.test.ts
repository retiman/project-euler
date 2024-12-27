import sigma from '../../src/core/sigma';

describe('sum of divisors', () => {
  test('sigma', async () => {
    expect(sigma(1)).toBe(1);
    expect(sigma(2)).toBe(3);
    expect(sigma(15)).toBe(24);
    expect(sigma(2015)).toBe(2688);
  });
});
