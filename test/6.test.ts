import { compute } from '../src/6';

describe('sum square difference', () => {
  test('problem 6', async () => {
    expect(compute(100)).toBe(25164150);
  });
});
