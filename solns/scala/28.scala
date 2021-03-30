def turn(heading: Symbol) = heading match {
  case 'right => 'down
  case 'down  => 'left
  case 'left  => 'up
  case 'up    => 'right
}

def next(x: Int, y: Int, heading: Symbol) = heading match {
  case 'right => (x + 1, y)
  case 'down  => (x, y - 1)
  case 'left  => (x - 1, y)
  case 'up    => (x, y + 1)
}

def populate(bound: Int) = {
  val m = Array.ofDim[Int](bound, bound)
  def bounded(p: Tuple2[Int, Int]) = {
    val (x, y) = p
    x >= 0 && x < m.length && y >= 0 && y < m.length
  }
  def recur(p: Tuple2[Int, Int], heading: Symbol, n: Int): Unit = {
    if (bounded(p)) {
      val (x, y) = p
      val (u, v) = next(x, y, turn(heading))
      m(x)(y) = n
      m(u)(v) match {
        case 0 => recur((u, v), turn(heading), n + 1)
        case _ => recur(next(x, y, heading), heading, n + 1)
      }
    }
  }
  recur((m.length / 2, m.length / 2) /* p */, 'up /* heading */, 1 /* n */)
  m
}

val b = 1001
val m = populate(b)
// Sum the diagonals but subtract 1 because it's counted twice
val result = (0 until b)
    .map(k => m(k)(k) + m(k)(m.length - k - 1))
    .reduceLeft(_ + _) - 1

println(result)
assert(result == 669171001)
