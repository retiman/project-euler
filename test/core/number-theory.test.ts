import _ from 'lodash';
import {
  countDigits,
  divisors,
  factorial,
  isPrime,
  mexpt,
  mtetration,
  ord,
  primeFactors,
  sigma,
  tau,
  totient
} from '../../src/core/number-theory';

describe('number theory', () => {
  test('count digits', async () => {
    expect(countDigits(-10)).toBe(2);
    expect(countDigits(-1)).toBe(1);
    expect(countDigits(0)).toBe(1);
    expect(countDigits(1)).toBe(1);
    expect(countDigits(72)).toBe(2);
    expect(countDigits(234)).toBe(3);
  });

  test('divisors', async () => {
    expect(divisors(1)).toStrictEqual([1]);
    expect(divisors(2)).toStrictEqual([1, 2]);
    expect(divisors(15)).toStrictEqual([1, 3, 5, 15]);
    expect(divisors(2015)).toStrictEqual([1, 5, 13, 31, 65, 155, 403, 2015]);
  });

  test('factorial', async () => {
    expect(_.toString(factorial(0))).toBe('1');
    expect(_.toString(factorial(1))).toBe('1');
    expect(_.toString(factorial(5))).toBe('120');
    expect(_.toString(factorial(10))).toBe('3628800');
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
    expect(primeFactors(1)).toStrictEqual([]);
    expect(primeFactors(2)).toStrictEqual([2]);
    expect(primeFactors(27)).toStrictEqual([3]);
    expect(primeFactors(103243)).toStrictEqual([7, 43]);
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
