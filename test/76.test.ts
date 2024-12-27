import compute from '../src/76';

describe('counting summations', () => {
  test('problem 76', async () => {
    expect(compute(100)).toBe(190569291);
  });
});
