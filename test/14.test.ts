import { compute } from '../src/14';

describe('longest collatz sequence', () => {
  test('problem 14', async () => {
    expect(compute(1_000_000)).toBe(837799);
  });
});
