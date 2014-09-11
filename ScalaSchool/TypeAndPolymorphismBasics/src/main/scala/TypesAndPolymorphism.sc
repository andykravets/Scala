import javafx.animation.Animation

import com.sun.xml.internal.bind.v2.TODO

val list = 2 :: 1 :: "bar" :: "foo" :: Nil

list.head

def drop1[A](l: List[A]) = l.tail

drop1(List(1, 2, 3))

def toList[A](a: A) = List(a)

/*
def foo[A, B](f: A=>List[A], b:B) = f(b)

def foo[A](f: A=>List[A], i:Int) = f(i)
*/

def id[T](x: T) = x

val x = id(322)

val y = id("hey")

val z = id(Array(1, 2, 3, 4))

class Covariant[+A]

val cv: Covariant[AnyRef] = new Covariant[String]

class Contravariant[-A]

val crv: Contravariant[String] = new Contravariant[AnyRef]

class Animal {
  val sound = "rustle"
}

class Bird extends Animal {
  override val sound = "call"
}

class Chicken extends Bird {
  override val sound = "cluck"
}

val getTweet: (Bird => String) = (a: Animal) => a.sound

getTweet(new Chicken)

val hatch: (() => Bird) = (() => new Chicken)

hatch()

def biophony[T <: Animal](things: Seq[T]) = things.map(_.sound)

biophony(Seq(new Bird, new Chicken))

/*
Not work
class Node[+T](x: T) {
  def sub(v: T): Node[T] = new Node(v)
}
*/

class Node[Bird](x: Bird) {
  def sub(v: Bird): Node[Bird] = new Node(v)
}

class Node1[Animal](x: Animal) {
  def sub(v: Animal): Node[Animal] = new Node(v)
}

class Node2[+T](x: T) {
  def sub[U >: T](v: U): Node2[U] = new Node2(v)
}

new Node2(new Bird).sub(new Bird)

((new Node2(new Bird)).sub(new Bird)).sub(new Animal)

//def count[A](l:List[A]) = l.size

def count(l:List[_]) = l.size

def drop1(l: List[_]) = l.tail

def hashcodes(l: Seq[_<:AnyRef]) = l.map(_.hashCode())
