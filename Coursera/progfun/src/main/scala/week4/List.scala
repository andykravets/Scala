package week4

/**
 * Created by akravets on 5/17/14.
 */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
