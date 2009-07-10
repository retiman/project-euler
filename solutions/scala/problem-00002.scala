/*
[minhuang@mocha:scala]$ time scala problem-00002.scala 
4613732

real    0m2.045s
user    0m0.376s
sys     0m0.060s
*/
import scala.Stream._

/*
// Ouch! This does not work as of scala 2.7.5final as the following code gives a
// compiler exception:
// lazy val x = 0 :: from(1)
implicit def streamExtras[Int](s: Stream[Int]) = new {
  def ::(n: Int) = cons(n, s)
}
*/
implicit def streamExtras[T](s: Stream[T]) = new {
  def zipWith(f: (T, T) => T, t: Stream[T]) = s.zip(t).map(a => f(a._1, a._2))
}

lazy val fibs: Stream[Int] = cons(0, cons(1, fibs.zipWith(_+_, fibs.tail)))
val result = fibs.takeWhile(_ < 4000000).filter(_ % 2 == 0).reduceLeft(_ + _)
println(result)
