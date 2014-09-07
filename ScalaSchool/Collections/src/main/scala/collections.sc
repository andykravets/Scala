val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

Set(1, 2, 3)

val hostPort = ("localhost", 80)

hostPort._1

hostPort._2

hostPort match {
  case ("localhost", port) => "First"
  case (host, port) => "Second"
}

1 -> 2

Map(1 -> 2)

Map("foo" -> "bar")

Map(1 -> "one", 2 -> "two")

Map(1 -> Map("foo" -> "bar"))

def timesTwo(a: Any) {}

Map("timesTwo" -> {
  timesTwo(_)
})

val mapNumbers = Map(1 -> "one", 2 -> "two")

mapNumbers.get(1)

val getVal = mapNumbers.get(3)

val result1 = if (getVal.isDefined) {
  getVal.get * 2
} else {
  0
}

//val result2 = getVal.getOrElse(0) * 2

val result3 = getVal match {
  case Some(n) => n * 2
  case None => 0
}

numbers.map((i: Int) => i * 2)

def timesThree(i: Int): Int = i * 3

numbers.map(timesThree _)

numbers.foreach((i: Int) => println(i * 3))
numbers.filter((i: Int) => i % 2 == 0)
def isEven(i: Int): Boolean = i % 2 == 0
numbers.filter(isEven _)
List(1, 2, 3).zip(List("a", "b", "c"))
List(1, 2).zip(List("a", "b", "c"))
List(1, 2, 3).zip(List("a", "b"))
List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).partition(_ % 2 == 0)
numbers.find(_ > 2)
numbers.drop(1)
numbers.dropWhile(_ % 2 != 0)
numbers.foldLeft(0)((m: Int, n: Int) => m + n)
numbers.foldLeft(0)((m: Int, n: Int) => {
  println("m: " + m + " n:" + n);
  m + n
})
numbers.foldRight(0)((m: Int, n: Int) => {
  println("m: " + m + " n:" + n);
  m + n
})
List(List(1, 2), List(3, 4)).flatten
val nestedNumbers = List(List(1, 2), List(3, 4))
nestedNumbers.flatMap(_.map(_ * 2))
List(List(1, 2), List(3, 4)).flatten.map(_ * 2)
nestedNumbers.map((x: List[Int]) => x.map(_ * 2)).flatten

def ourMap(number: List[Int], fn: Int => Int): List[Int] = {
  numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) =>
    fn(x) :: xs
  }
}

ourMap(numbers, timesThree(_))

val extensions = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)

extensions.filter((namePhone: (String, Int)) => namePhone._2 < 200)

extensions.filter({ case (name, extension) => extension < 200})



