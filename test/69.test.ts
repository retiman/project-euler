import compute from '../src/69';

describe('totient maximum', () => {
  test('problem 69', async () => {
    expect(compute(1_000_000)).toBe(510510);
  });
});
