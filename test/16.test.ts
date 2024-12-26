import { compute } from '../src/16';

describe('power digit sum', () => {
  test('problem 16', async () => {
    expect(compute(1000)).toBe(1366);
  });
});
