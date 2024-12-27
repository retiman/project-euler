import compute from '../src/9';

describe('special pythagorean triplet', () => {
  test('problem 9', async () => {
    expect(compute(1000)).toBe(31875000);
  });
});
