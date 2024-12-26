import { countDigits, isPrime, mexpt, mtetration, ord } from '../../src/core/number-theory';

describe('number theory', () => {
  test('count digits', async () => {
    expect(countDigits(-10)).toBe(2);
    expect(countDigits(-1)).toBe(1);
    expect(countDigits(0)).toBe(1);
    expect(countDigits(1)).toBe(1);
    expect(countDigits(72)).toBe(2);
    expect(countDigits(234)).toBe(3);
  });

  test('is prime', async () => {
    expect(isPrime(0)).toBe(false);
    expect(isPrime(1)).toBe(false);
    expect(isPrime(2)).toBe(true);
    expect(isPrime(4)).toBe(false);
    expect(isPrime(71)).toBe(true);
  });

  test('modular tetration', async () => {
    expect(mtetration(3, 1, 2)).toBe(3 ** 1 % 2);
    expect(mtetration(3, 2, 20)).toBe(3 ** 3 % 20);
    expect(mtetration(3, 3, 345)).toBe(312);
    expect(mtetration(5, 2, 7)).toBe(5 ** 5 % 7);
    expect(mtetration(7, 4, 13)).toBe(6);
    expect(mtetration(10, 2, 6)).toBe(10 ** 10 % 6);
  });

  test('order modulo m', async () => {
    expect(ord(4, 7)).toBe(3);
    expect(ord(10, 7)).toBe(6);
    expect(ord(5, 3)).toBe(2);
    expect(ord(13, 7)).toBe(2);
    expect(ord(3, 20)).toBe(4);
    expect(ord(3, 115)).toBe(44);
  });
});
