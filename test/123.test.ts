import compute from '../src/123';

describe('prime square remainders', () => {
  test('problem 123', async () => {
    expect(compute(1e10)).toBe(21035);
  });
});
