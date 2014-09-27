package week4

/**
 * Created by akravets on 5/17/14.
 */
class Cons[T](val head: T, val tail: List[T]) extends List[T]{

  def isEmpty = false

}
