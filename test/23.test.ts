import compute from '../src/23';

describe('non-abundant sums', () => {
  test('problem 23', async () => {
    expect(compute(28123)).toBe(4179871);
  });
});
