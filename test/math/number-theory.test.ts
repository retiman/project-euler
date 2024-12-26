import {
  countDigits,
  divisors,
  factorial,
  factorion,
  gcd,
  isCoprime,
  isDivides,
  isPrime,
  mexpt,
  mtetration,
  ord,
  primeFactors,
  sigma,
  tau,
  totient
} from '../../src/math/number-theory';

describe('number theory', () => {
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

  test('is coprime', async () => {
    expect(isCoprime(1, 1)).toBe(true);
    expect(isCoprime(2, 1)).toBe(true);
    expect(isCoprime(5, 7)).toBe(true);
    expect(isCoprime(15, 3)).toBe(false);
    expect(isCoprime(4, 2)).toBe(false);
  });

  test('is prime', async () => {
    expect(isPrime(0)).toBe(false);
    expect(isPrime(1)).toBe(false);
    expect(isPrime(2)).toBe(true);
    expect(isPrime(4)).toBe(false);
    expect(isPrime(71)).toBe(true);
  });

  test('modular exponentiation', async () => {
    expect(mexpt(3, 1, 2)).toBe(1);
    expect(mexpt(3, 0, 9)).toBe(1);
    expect(mexpt(5, 3, 13)).toBe(8);
    expect(mexpt(4, 13, 497)).toBe(445);
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

  test('prime factors', async () => {
    expect(primeFactors(1)).toStrictEqual(new Set());
    expect(primeFactors(2)).toStrictEqual(new Set([2]));
    expect(primeFactors(27)).toStrictEqual(new Set([3]));
    expect(primeFactors(103243)).toStrictEqual(new Set([7, 43]));
  });

  test('sigma', async () => {
    expect(sigma(1)).toBe(1);
    expect(sigma(2)).toBe(3);
    expect(sigma(15)).toBe(24);
    expect(sigma(2015)).toBe(2688);
  });

  test('tau', async () => {
    expect(tau(1)).toBe(1);
    expect(tau(2)).toBe(2);
    expect(tau(15)).toBe(4);
    expect(tau(2015)).toBe(8);
  });

  test('totient', async () => {
    expect(totient(1)).toBe(0);
    expect(totient(7)).toBe(6);
    expect(totient(15)).toBe(8);
    expect(totient(2015)).toBe(1440);
  });
});
