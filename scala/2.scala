// JAVA_OPTS="-Xmx1024M" time scala -deprecation 2.scala
// 4613732
// 0.63user 0.06system 0:02.25elapsed 30%CPU (0avgtext+0avgdata 0maxresident)k
// 48inputs+64outputs (1major+16024minor)pagefaults 0swaps

import scala.Stream._

implicit def streamExtras[T](s: Stream[T]) = new {
  def zipWith(f: (T, T) => T, t: Stream[T]) = s.zip(t).map(a => f(a._1, a._2))
}

lazy val fibs: Stream[Int] = cons(0, cons(1, fibs.zipWith(_ + _, fibs.tail))
)

println(fibs.takeWhile(_ < 4000000).filter(_ % 2 == 0).reduceLeft(_ + _))
