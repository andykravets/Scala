package week4

import java.util.NoSuchElementException

/**
 * Created by akravets on 5/17/14.
 */
class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}
