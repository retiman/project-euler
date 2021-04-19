using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;


static string Reverse(string s)
{
    var cs = s.ToCharArray();
    Array.Reverse(cs);
    return new string(cs);
}

static bool IsPalindrome(long n)
{
    var s = Convert.ToString(n);
    return Reverse(s) == s;
}

var result = 0;
for (var i = 999; i > 0; i--)
{
    for (var j = i; j > 0; j--)
    {
        var x = i * j;
        if (IsPalindrome(x) && x > result)
        {
            result = x;
        }
    }
}

Console.WriteLine(result);
Trace.Assert(result == 906609);
