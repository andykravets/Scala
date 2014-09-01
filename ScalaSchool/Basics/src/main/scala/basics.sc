1 + 1

val two = 1 + 1

var name = "Mark"

name = "Andrey"

def addOne(m: Int): Int = m + 1

val three = addOne(2)

def threeFunc() = 1 + 2

threeFunc()

threeFunc

(x: Int) => x + 1

val addOneAnon = (x: Int) => x + 1

addOneAnon(1)

def timesTwo(i: Int): Int = {
  println("hello world")
  i * 2
}

def adder(m: Int, n: Int) = m + n

val add2 = adder(2, _: Int)

add2(3)

def multiply(m: Int)(n: Int) = m * n

multiply(2)(3)

val timesTwoVal = multiply(2) _

timesTwoVal(3)

def capitalizeAll(args: String*) = {
  args.map { arg => arg.capitalize}
}

class Calculator(brand: String) {

  val color: String =
    if (brand == "TI") {
      "blue"
    } else if (brand == "HP") {
      "black"
    } else {
      "white"
    }

  def add(m: Int, n: Int): Int = m + n
}

val calc = new Calculator("HP")

calc.add(1, 2)

calc.color

class ScientificCalculator(brand: String) extends Calculator(brand) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

class EvenMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {
  def log(m: Int): Double = log(m, math.exp(1))
}

trait Car {
  val brand: String
}

class BMW extends Car {
  val brand = "BMW"
}

trait Cache[K, V] {
  def get(key: K): V
  def put(key: K, value: V)
  def delete(key: K)
  def remove[K](key: K)
}



