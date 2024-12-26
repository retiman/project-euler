import compute from '../src/53';

describe('combinatoric selections', () => {
  test('problem 53', async () => {
    expect(compute(100)).toBe(4075);
  });
});
