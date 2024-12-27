import { compute } from '../src/7';

describe('10001st prime', () => {
  test('problem 7', async () => {
    expect(compute(10001)).toBe(104743);
  });
});
