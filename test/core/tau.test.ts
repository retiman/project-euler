import tau from '../../src/core/tau';

describe('number of divisors', () => {
  test('tau', async () => {
    expect(tau(1)).toBe(1);
    expect(tau(2)).toBe(2);
    expect(tau(15)).toBe(4);
    expect(tau(2015)).toBe(8);
  });
});
