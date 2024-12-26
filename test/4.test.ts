import { compute } from '../src/4';

describe('largest palindrome product', () => {
  test('problem 4', async () => {
    expect(compute()).toBe(906609);
  });
});
