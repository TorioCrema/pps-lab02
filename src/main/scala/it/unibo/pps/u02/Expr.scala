package it.unibo.pps.u02

enum Expr:
  case Literal(value: Int)
  case Add(left: Expr, right: Expr)
  case Multiply(left: Expr, right: Expr)

object Expr {
  def evaluate(expr: Expr): Int = expr match
    case Literal(value) => value
    case Add(left, right) => evaluate(left) + evaluate(right)
    case Multiply(left, right) => evaluate(left) * evaluate(right)

  def show(expr: Expr): String = expr match
    case Literal(value) => value.toString
    case Add(left, right) => "(" + show(left) + " + " + show(right) + ")"
    case Multiply(left, right) => "(" + show(left) + " * " + show(right) + ")"


}
