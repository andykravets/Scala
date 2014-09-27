package week4

/**
 * Created by akravets on 6/6/14.
 */
abstract class Nat {
  def isZero: Boolean = false

  def predecessor: Nat

  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat = if (that.isZero) this else this.successor + that.predecessor

  def -(that: Nat): Nat = if (that.isZero) this else this.predecessor - that.predecessor
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def -(that: Nat): Nat = if(that.isZero) this else throw new IllegalArgumentException

  override def predecessor: Nat = throw new IllegalArgumentException
}

class Succ(pred: Nat) extends Nat {
  override def predecessor: Nat = pred
}
