implicit def strToInt(x: String) = x.toInt

"123"

val y: Int = "123"

math.max("123", 111)

class ContainerC[A <% Int] {
  def addIt(x: A) = 123 + x
}

new ContainerC[String].addIt("123")

new ContainerC[Int].addIt(123)

//new ContainerC[Float].addIt(123.2F)
//could not find implicit value for evidence parameter of type (Float) => Int
/*
A =:= B 	A должен быть равен B
A <:< B 	A должен быть подтипом B - deprecated =>
A <%< B 	A должен выглядеть как B
*/

class ContainerInt[A](value: A) {
  def addIt(implicit evidence: A =:= Int) = 123 + value
}

new ContainerInt(123).addIt

/*
new ContainerInt("123").addInt
could not find implicit value for parameter evidence: =:=[java.lang.String,Int]
*/

class ContainerLikeInt[A](value: A) {
  def addIt(implicit evidence: A => Int) = 123 + value
}

new ContainerLikeInt("123").addIt

def foo[A](implicit x: Ordered[A]) {}

def foo1[A: Ordered] {}

//implicitly[Ordered[Int]]

trait Container[M[_]] {
  def put[A](x: A): M[A]

  def get[A](m: M[A]): A
}

val container = new Container[List] {
  def put[A](x: A) = List(x)

  def get[A](m: List[A]) = m.head
}

container.put("hey")

container.put(123)

implicit val listContainer = new Container[List] {
  override def put[A](x: A): List[A] = List(x)

  override def get[A](m: List[A]): A = m.head
}

implicit val optionContainer = new Container[Some] {
  override def put[A](x: A): Some[A] = Some(x)

  override def get[A](m: Some[A]): A = m.get
}

def tupleize[M[_] : Container, A, B](fst: M[A], snd: M[B]) = {
  val c = implicitly[Container[M]]
  c.put(c.get(fst), c.get(snd))
}

tupleize(Some(1), Some(2))

tupleize(List(1), List(2))

trait ContainerF[A <: ContainerF[A]] extends Ordered[A]

class MyContainer extends ContainerF[MyContainer] {
  def compare(that: MyContainer) = 0
}

List(new MyContainer, new MyContainer, new MyContainer).min

class YourContainer extends ContainerF[YourContainer] {
  override def compare(that: YourContainer): Int = 0
}

List(new MyContainer, new MyContainer, new MyContainer, new YourContainer)

def foo(x: {def get: Int}) = 123 + x.get

foo(new {
  def get = 10
})

trait Foo {
  type A;
  val x: A;

  def getX: A = x
}

new Foo {
  override type A = Int
  override val x: A = 123
}.getX

new Foo {
  override type A = String
  override val x: A = "hey"
}.getX

trait Foo1[M[_]] {
  type t[A] = M[A]
}

val x: Foo1[List]#t[Int] = List(1)

class MakeFoo[A](implicit manifest: Manifest[A]){def make:A = manifest.erasure.newInstance.asInstanceOf[A]}

new MakeFoo[String]().make


