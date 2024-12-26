import divisors from '../../src/core/divisors';

describe('divisors', () => {
  test('divisors', async () => {
    expect(divisors(1)).toStrictEqual([1]);
    expect(divisors(2)).toStrictEqual([1, 2]);
    expect(divisors(15)).toStrictEqual([1, 3, 5, 15]);
    expect(divisors(2015)).toStrictEqual([1, 5, 13, 31, 65, 155, 403, 2015]);
  });
});
