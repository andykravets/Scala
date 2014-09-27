package week4

/**
 * Created by akravets on 5/17/14.
 */
trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]
}

object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons[T](x1, new Cons[T](x2, new Nil[T]))

  def apply[T](x1: T): List[T] = new Cons[T](x1, new Nil[T])

  def apply[T]() = new Nil[T]
}
