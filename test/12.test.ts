import compute from '../src/12';

describe('highly divisible triangular number', () => {
  test('problem 12', async () => {
    expect(compute(500)).toBe(76576500);
  });
});
