import { range } from 'lodash';

// See https://projecteuler.net/problem=1
describe('multiples of 3 or 5', () => {
  function compute(limit: number) {
    return range(limit)
      .filter(_ => _ % 3 === 0 || _ % 5 === 0)
      .reduce((acc, _) => acc + _, 0);
  }

  test('problem 1', async () => {
    expect(compute(1000)).toBe(233168);
  });
});
