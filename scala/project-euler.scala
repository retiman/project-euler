import scala.Collection
import scala.collection.mutable.ListBuffer
import scala.util.Random
import scala.Math._

val rand = new Random

implicit def tuple2Wrapper[A, B](t: Pair[A, B]) = new {
  def a = t._1
  def b = t._2
}

def permute[T](c: Collection[T]) = {
  var s = c.toArray
  val rand = new Random(System.currentTimeMillis)
  (1 until s.length).foreach(i => {
    val j = rand.nextInt(s.length)
    val t = s(i)
    s(i) = s(j)
    s(j) = t
  })
  s.asInstanceOf[Collection[T]]
}

def permutations[T](c: Collection[T]): Collection[Collection[T]] = {
  val list = c.toList
  if (list.length == 1)
    return List(c).asInstanceOf[Collection[Collection[T]]]
  val perms = new ListBuffer[List[T]]()
  (0 until list.length).foreach(i => {
    val s = list.slice(0, i) :::
            list.slice(i + 1, list.length)
    val partials = permutations(s)
    partials.map(c => c.toList)
        .map(partial => list(i) :: partial)
        .foreach(perm => perms += perm)
  })
  perms.toList.map(l => l.asInstanceOf[Collection[T]])
}

def gcd(a: Long, b: Long): Long = (a, b) match {
  case (0, _) => b
  case (_, 0) => a
  case (_, _) => gcd(b, a % b)
}

def lcm(a: Long, b: Long) = a * (b / gcd(a, b))

def mpow(base: Int, exp: Int)(mod: Int) = {
  def recur(a: Int, b: Int, e: Int): Int = if (e <= 0) a else {
    val t = if ((e & 1) == 1) (a * b) % mod else a
    recur(t, (b * b) % mod, e >> 1)
  }
  recur(1, base, exp)
}

def fermatFactors(n: Long): Set[Long] = {
  if (n % 2 == 0) return Set(2, n / 2)
  var a = ceil(sqrt(n))
  var b = a * a - n
  var s = sqrt(b)
  while (s != round(s)) {
    a += 1
    b = a * a -n
    s = sqrt(b)
  }
  Set(a - s, a + s).map(_.toLong)
}

def rhoFactors(n: Long) = {
  def f(x: Long) = x * x + 1
  def recur(x: Long, y: Long, d: Long): Long = if (d != 1) d else {
    (f(x) % n, f(f(y) % n) % n) match {
      case (a, b) if a < 0 || b < 0 => n
      case (a, b) => recur(a, b, gcd(abs(a-b), n))
    }
  }
  val factor = recur(2, 2, 1)
  Set(factor, n / factor)
}

def primeFactors(n: Long)(f: Long => Set[Long]): Set[Long] = f(n) match {
  case factors if factors contains 1 => factors - 1
  case factors => factors.map(factor => primeFactors(factor)(f))
                         .reduceLeft(_ ++ _)
}

def divisors(n: Int) = {
  val d = (2 to sqrt(n)).filter(n % _ == 0)
  Set() ++ d ++ d.map(n / _) ++ Set(1)
}

def order(a: Int, m: Int) = {
  def recur(b: Int, numbers: List[Int]): Int = numbers match {
    case x :: Nil => x
    case x :: xs if b == 1 => x
    case _ => recur((a * b) % m, numbers.tail)
  }
  recur(a % m, (1 to m - 1).toList)
}

def tau(n: Int) = if (n == 1) 1 else 2 * (1 to sqrt(n)).filter(n % _ == 0).length

def sigma(n: Int) = divisors(n).reduceLeft(_ + _)

def totient(n: Long)(f: Long => Set[Long]): Long = f(n) match {
  case factors if factors contains 1 => (factors - 1).elements.next - 1
  case factors => factors.reduceLeft( (a, b) => totient(a)(f) * totient(b)(f) )
}

def isPrimitiveRoot(a: Int, m: Int) = {
  val list = (1 to m - 1).map(mpow(a, _)(m))
  list.last == 1 && list.filter(_ == 1).length == 1
}
