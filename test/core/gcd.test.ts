import gcd from '../../src/core/gcd';

describe('greatest common divisor', () => {
  test('gcd', async () => {
    expect(gcd(48, 18)).toBe(6);
    expect(gcd(101, 103)).toBe(1);
    expect(gcd(56, 98)).toBe(14);
    expect(gcd(270, 192)).toBe(6);
    expect(gcd(0, 5)).toBe(5);
    expect(gcd(5, 0)).toBe(5);
    expect(gcd(0, 0)).toBe(0);
    expect(gcd(3, 20)).toBe(1);
    expect(gcd(3, 345)).toBe(3);
    expect(gcd(3, 115)).toBe(1);
  });
});
