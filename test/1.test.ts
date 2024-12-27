import compute from '../src/1';

describe('multiples of 3 or 5', () => {
  test('problem 1', async () => {
    expect(compute(1000)).toBe(233168);
  });
});
