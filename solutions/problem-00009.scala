import scala.Math._

val n = 1000
// because a < b < c and a + b + c = 1000, maximizing a gives a value of
// (n-3)/3
(3 to (n - 3)/2).foreach(a => {
  // b must be at least 1 greater than a; maximizing b gives a value of
  // (n-a)/2
  (a + 1 to (n - a)/2).foreach(b => {
    val c1 = pow(a, 2) + pow(b, 2)
    val c2 = pow(n - a - b, 2)
    if (c1 == c2) {
      println(a * b * (n - a - b))
      System.exit(0)
    }
  })
})
