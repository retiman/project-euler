import compute from '../src/21';

describe('amicable numbers', () => {
  test('problem 21', async () => {
    expect(compute(10_000)).toBe(31626);
  });
});
