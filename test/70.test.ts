import compute from '../src/70';

describe('totient permutation', () => {
  test('problem 70', async () => {
    expect(compute(1e7)).toBe(8319823);
  });
});
