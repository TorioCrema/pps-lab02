package it.unibo.pps.u02

object Tasks {
  val positiveVal: Int => String = _ match
    case n if n >= 0 => "positive"
    case _ => "negative"

  def positiveDef(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  val neg: (String => Boolean) => String => Boolean = x => !x(_)

  def negDef(predicate: String => Boolean): String => Boolean = !predicate(_)

  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z

  val p1: Int => (Int => Int => Boolean) = x => y => y match
    case n if x <= n => n == _
    case _ => _ => false

  def p3(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  def p4(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  def power(base: Double, exponent: Int): Double = (base, exponent) match
    case (b, 0) => 1
    case (b, e) => b * power(b, e - 1)

  def powerTail(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def power_(base: Double, exponent: Int, acc: Double): Double = (base, exponent, acc) match
      case (b, 0, acc) => acc
      case (b, e, acc) => power_(b, e - 1, base * acc)
    power_(base, exponent, 1)

  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def reverse_(remainder: Int, reversed: Int): Int = (remainder, reversed) match
      case (0, r) => r
      case (remainder, reversed) => reverse_(remainder / 10, reversed * 10 + remainder % 10)

    reverse_(n, 0)

  @main def main(): Unit = {
    println(positiveVal(10))
    println(positiveDef(-1))
    val empty: String => Boolean = _ == "" // predicate on strings
    val notEmpty = neg(empty) // which type of notEmpty?
    notEmpty("foo") // true
    notEmpty("") // false
    notEmpty("foo") && !notEmpty("") // true.. a comprehensive test
    println(compose(_ - 1, _ * 2)(5))
    println(power(2, 3))
    println(powerTail(2, 3))
    println(reverseNumber(12345))
  }
}
