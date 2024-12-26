import { compute } from '../src/8';

describe('largest product in a series', () => {
  test('problem 8', async () => {
    expect(compute(13)).toBe(23514624000);
  });
});
