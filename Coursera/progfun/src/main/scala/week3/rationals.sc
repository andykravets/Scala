val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.sub(y).sub(z)
y.add(y)
x.less(y)
x.max(y)

class Rational(x: Int, y: Int) {
  require(y > 0, "denominator must be positive")

  def this(x: Int) = this(x, 1)

  val numer = x
  val denom = y

  def less(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this.less(that)) that else this

  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def neg = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)


  override def toString: String = {
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a
      else gcd(b, a % b)
    val g = gcd(numer, denom)
    numer / g + "/" + denom / g
  }
}




