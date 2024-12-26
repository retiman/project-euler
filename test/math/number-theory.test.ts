import { countDigits, divisors, factorial, factorion, isCoprime, isDivides, mexpt } from '../../src/math/number-theory';

describe('number theory', () => {
  test('coprime', async () => {
    expect(isCoprime(1, 1)).toBe(true);
    expect(isCoprime(2, 1)).toBe(true);
    expect(isCoprime(5, 7)).toBe(true);
    expect(isCoprime(15, 3)).toBe(false);
    expect(isCoprime(4, 2)).toBe(false);
  });

  test('count digits', async () => {
    expect(countDigits(-10)).toBe(2);
    expect(countDigits(-1)).toBe(1);
    expect(countDigits(0)).toBe(1);
    expect(countDigits(1)).toBe(1);
    expect(countDigits(72)).toBe(2);
    expect(countDigits(234)).toBe(3);
  });

  test('divides', async () => {
    expect(isDivides(2, 1)).toBe(false);
    expect(isDivides(1, 2)).toBe(true);
    expect(isDivides(5, 20)).toBe(true);
    expect(isDivides(7, 20)).toBe(false);
  });

  test('divisors', async () => {
    expect(divisors(1)).toStrictEqual(new Set([1]));
    expect(divisors(2)).toStrictEqual(new Set([1, 2]));
    expect(divisors(15)).toStrictEqual(new Set([1, 3, 5, 15]));
    expect(divisors(2015)).toStrictEqual(new Set([1, 5, 13, 31, 65, 155, 403, 2015]));
  });

  test('factorial', async () => {
    expect(factorial(0)).toBe(1);
    expect(factorial(1)).toBe(1);
    expect(factorial(5)).toBe(120);
    expect(factorial(10)).toBe(3628800);
  });

  test('factorion', async () => {
    expect(factorion(1)).toBe(true);
    expect(factorion(2)).toBe(true);
    expect(factorion(145)).toBe(true);
    expect(factorion(146)).toBe(false);
  });

  test('modular exponentiation', async () => {
    expect(mexpt(3, 1, 2)).toBe(1);
    expect(mexpt(3, 0, 9)).toBe(1);
    expect(mexpt(5, 3, 13)).toBe(8);
    expect(mexpt(4, 13, 497)).toBe(445);
  });
});
