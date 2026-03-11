package task5

import it.unibo.pps.u02.Expr
import org.junit.*
import org.junit.Assert.*

class ExprTest {

  val value1: Expr = Expr.Literal(2)
  val value2: Expr = Expr.Literal(3)

  def testEvaluate(exprConstructor: (Int, Int) => Expr, literal1: Int, literal2: Int, operator: (Int, Int) => Int): Unit =
    val expr: Expr = exprConstructor(literal1, literal2)
    assertEquals(operator(literal1, literal2), Expr.evaluate(expr))

  @Test def testEvaluateOnMultiply(): Unit =
    testEvaluate((x, y) => Expr.Multiply(Expr.Literal(x), Expr.Literal(y)), 3, 2, _ * _)

  @Test def testEvaluateOnAdd(): Unit =
    testEvaluate((x, y) => Expr.Add(Expr.Literal(x), Expr.Literal(y)), 3, 2, _ + _)

  def testShow(expr: Expr, expectedOutput: String): Unit =
    assertEquals(expectedOutput, Expr.show(expr))

  @Test def testShowOnMultiply(): Unit =
    testShow(Expr.Multiply(value1, value2), "(" + Expr.show(value1) + " * " + Expr.show(value2) + ")")

  @Test def testShowOnAdd(): Unit =
    testShow(Expr.Add(value1, value2), "(" + Expr.show(value1) + " + " + Expr.show(value2) + ")")
}
