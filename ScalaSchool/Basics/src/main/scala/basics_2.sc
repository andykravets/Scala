/*
class Foo

object FooMaker {
  def apply() = new Foo
}
*/

class Bar {
  def apply() = 0
}

val bar = new Bar

bar()

object Timer {
  var count = 0

  def currentCount(): Long = {
    count += 1
    count
  }
}

Timer.currentCount()

class NewBar(foo: String) {
  val param = foo
}

object NewBar {
  def apply(foo: String) = new NewBar(foo)
}

val newBar = NewBar("Param Name")

newBar.param

object addOne extends Function1[Int, Int] {
  override def apply(v1: Int): Int = v1 + 1
}

addOne(1)

class AddOne extends Function1[Int, Int] {
  override def apply(v1: Int): Int = v1 + 1
}

val plusOne = new AddOne()

plusOne(1)

class AddAnotherOne extends (Int => Int) {
  override def apply(v1: Int): Int = v1 + 1
}

val plusAnotherOne = new AddAnotherOne

plusAnotherOne(2)

object colorHolder {
  val BLUE = "Blue"
  val RED = "Red"
}

println("The color is " + colorHolder.BLUE)

val times = 1

times match {
  case 1 => "one"
  case 2 => "two"
  case _ => "some other number"
}

times match {
  case i if i == 1 => "one"
  case i if i == 2 => "two"
  case _ => "some other number"
}

def bigger(o: Any): Any = {
  o match {
    case i: Int if i < 0 => i - 1
    case i: Int => i + 1
    case d: Double if d < 0.0 => d - 0.1
    case d: Double => d + 0.1
    case text: String => text + "s"
  }
}

case class Calculator(brand: String, model: String)

val hp20b = Calculator("hp", "20B")
val hp30b = Calculator("hp", "30B")

def calcType(calc: Calculator) = calc match {
  case Calculator("hp", "20B") => "financial"
  case Calculator("hp", "48G") => "scientific"
  case Calculator("hp", "30B") => "business"
  case Calculator(ourBrand, ourmodel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourmodel)
  case Calculator(_, _) => "Calculator of unknown type"
  case _ => "Calculator of unknown type"
  case c@Calculator(_,_)=> "Calculator: %s of unknown tpe".format(c)
}


