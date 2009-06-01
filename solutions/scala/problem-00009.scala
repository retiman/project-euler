/*
minhuang@mocha:scala]$ time scala problem-00009.scala 
31875000

real  0m1.348s
user  0m0.296s
sys 0m0.056s
*/
for (a <- 1 to 332;
     b <- a to ((1000 - a) / 2) - 1;
     c <- Some(1000 - a - b)
     if (a*a + b*b == c*c))
  println(a*b*c)
