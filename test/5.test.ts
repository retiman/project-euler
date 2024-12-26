import { compute } from '../src/5';

describe('smallest multiple', () => {
  test('problem 5', async () => {
    expect(compute(20)).toBe(232792560);
  });
});
