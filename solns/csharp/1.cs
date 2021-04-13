using System;
using System.Linq;


var result = Enumerable.Range(1, 999)
    .Where(i => i%3 == 0 || i%5 == 0)
    .Aggregate(0, (acc, i) => acc + i);
Console.WriteLine(result);
