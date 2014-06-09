/*
def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

def nth[T](position: Int, list: List[T]): T = {
  if (list.isEmpty) throw new IndexOutOfBoundsException()
  else if (position == 0) list.head
  else nth(position - 1, list.tail)
}

val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
*/
def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y::ys => if(x <= y) x :: xs else y :: insert(x, ys)
}

def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y, isort(ys))
}




