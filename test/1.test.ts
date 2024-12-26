import _ from 'lodash';

// See https://projecteuler.net/problem=1
describe('multiples of 3 or 5', () => {
  function compute(limit: number) {
    return _.range(limit)
      .filter(n => n % 3 === 0 || n % 5 === 0)
      .reduce((sum, n) => sum + n, 0);
  }

  test('problem 1', async () => {
    expect(compute(1000)).toBe(233168);
  });
});
