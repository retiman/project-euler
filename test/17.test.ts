import { compute } from '../src/17';

describe('number letter counts', () => {
  test('problem 17', async () => {
    expect(compute(1000)).toBe(1366);
  });
});
