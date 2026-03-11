package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*

class OptionalIntTest:
  @Test def emptyOptionalShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(1, OptionalInt.orElse(empty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  /** Task 5: do test for map **/

  @Test def mapOfEmptyShouldReturnEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(OptionalInt.Empty(), OptionalInt.mapInt(empty)(_ + 1))

  @Test def mapOfJustShouldReturnMapped(): Unit =
    val just = OptionalInt.Just(2)
    assertEquals(OptionalInt.Just(3), OptionalInt.mapInt(just)(_ + 1))

  @Test def filterOfEmptyShouldReturnEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(OptionalInt.Empty(), OptionalInt.filter(empty)(_ >= 0))

  @Test def filterOfJustShouldReturnIfFilterPasses(): Unit =
    val just = OptionalInt.Just(3)
    assertEquals(OptionalInt.Just(3), OptionalInt.filter(just)(_ >= 0))
    assertEquals(OptionalInt.Empty(), OptionalInt.filter(just)(_ < 0))