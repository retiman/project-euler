import { compute } from '../src/19';

describe('counting sundays', () => {
  test('problem 19', async () => {
    expect(compute(1000)).toBe(1366);
  });
});
