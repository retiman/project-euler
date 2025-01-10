import compute from '../src/52';

describe('permuted multiples', () => {
  test('problem 52', async () => {
    expect(compute()).toBe(142857);
  });
});
