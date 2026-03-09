package it.unibo.pps.u02

object Task2 {
  val positiveVal: Int => String = _ match
    case n if n >= 0 => "positive"
    case _ => "negative"

  def positiveDef(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  val neg: (String => Boolean) => String => Boolean = x => !x(_)

  def negDef(predicate: String => Boolean): String => Boolean = !predicate(_)

  @main def main(): Unit = {
    println(positiveVal(10))
    println(positiveDef(-1))
    val empty: String => Boolean = _ == "" // predicate on strings
    val notEmpty = neg(empty) // which type of notEmpty?
    notEmpty("foo") // true
    notEmpty("") // false
    notEmpty("foo") && !notEmpty("") // true.. a comprehensive test
  }
}
