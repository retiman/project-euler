using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;


static IEnumerable<long> Fibonacci()
{
    var current = 0;
    var next = 1;
    while (true)
    {
        yield return current;

        var t = next;
        next = current + next;
        current = t;
    }
}

var result = Fibonacci().TakeWhile(n => n < 4_000_000)
        .Where(n => n % 2 == 0)
        .Sum();

Console.WriteLine(result);
Trace.Assert(result == 4613732);
