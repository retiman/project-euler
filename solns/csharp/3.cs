using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;


static (long a, long b) FermatFactors(long n)
{
    if (n % 2 == 0)
    {
        return (2, n / 2);
    }

    long a = Convert.ToInt64(Math.Ceiling(Math.Sqrt(n)));
    long b = a * a - n;
    double s = Math.Sqrt(b);
    while (s != Math.Round(s))
    {
        a++;
        b = a * a - n;
        s = Math.Sqrt(b);
    }

    long t = Convert.ToInt64(s);
    return (a - t, a + t);
}

static IEnumerable<long> PrimeFactors(long n)
{
    var factors = new List<long>();
    (long a, long b) = FermatFactors(n);
    if (a == 1)
    {
        factors.Add(b);
        return factors;
    }
    if (b == 1)
    {
        factors.Add(a);
        return factors;
    }
    factors.AddRange(PrimeFactors(a));
    factors.AddRange(PrimeFactors(b));
    return factors;
}

var n = 600_851_475_143L;
var result = PrimeFactors(n).Max();


Console.WriteLine(result);
Trace.Assert(result == 6857L);
