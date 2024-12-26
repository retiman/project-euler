import { compute } from '../src/20';

describe('factorial digit sum', () => {
  test('problem 20', async () => {
    expect(compute(1000)).toBe(1366);
  });
});
