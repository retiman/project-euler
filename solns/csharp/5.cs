using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;


static int gcd(int a, int b)
{
    return b == 0 ? a : gcd(b, a % b);
}

static int lcm(int a, int b)
{
   return a * (b / gcd(a, b));
}

var result = Enumerable.Range(1, 21)
    .Aggregate(20, (a, b) => lcm(a, b));

Console.WriteLine(result);
Trace.Assert(result == 232792560);
