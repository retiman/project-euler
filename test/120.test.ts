import compute from '../src/120';

describe('square remainders', () => {
  test('problem 120', async () => {
    expect(compute()).toBe(333082500);
  });
});
