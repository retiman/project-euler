using System;
using System.Diagnostics;
using System.Linq;


var ns = from n in Enumerable.Range(1, 999)
         where n % 3 == 0 || n % 5 == 0
         select n;
var result = ns.Sum();

Console.WriteLine(result);
Trace.Assert(result == 233168);
