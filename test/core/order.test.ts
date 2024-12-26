import ord from '../../src/core/order';

describe('multiplicative order', () => {
  test('order modulo m', async () => {
    expect(ord(4, 7)).toBe(3);
    expect(ord(10, 7)).toBe(6);
    expect(ord(5, 3)).toBe(2);
    expect(ord(13, 7)).toBe(2);
    expect(ord(3, 20)).toBe(4);
    expect(ord(3, 115)).toBe(44);
  });
});
