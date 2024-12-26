import { compute } from '../src/2';

describe('even fibonacci numbers', () => {
  test('problem 2', async () => {
    expect(compute(4_000_000)).toBe(4613732);
  });
});
