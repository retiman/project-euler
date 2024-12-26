import primeFactors from '../../src/core/prime-factors';

describe('prime factors', () => {
  test('primeFactors', async () => {
    expect(primeFactors(1)).toStrictEqual([]);
    expect(primeFactors(2)).toStrictEqual([2]);
    expect(primeFactors(27)).toStrictEqual([3]);
    expect(primeFactors(103243)).toStrictEqual([7, 43]);
  });
});
