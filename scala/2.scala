import scala.language.implicitConversions
import scala.language.reflectiveCalls
import scala.Stream.cons


implicit def streamExtras[T](s: Stream[T]) = new {
  def zipWith(f: (T, T) => T, t: Stream[T]) = s.zip(t).map(a => f(a._1, a._2))
}

lazy val fibs: Stream[Int] = cons(
    0,
    cons(1, fibs.zipWith(_ + _, fibs.tail)))

val result = fibs.takeWhile(_ < 4000000)
    .filter(_ % 2 == 0)
    .reduceLeft(_ + _)

println(result)
assert(result == 4613732)
