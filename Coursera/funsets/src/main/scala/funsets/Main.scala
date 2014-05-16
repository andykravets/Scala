package funsets

object Main extends App {

  import FunSets._

  //println(contains(singletonSet(1), 1))

  val ss1 = singletonSet(1)
  val ss2 = singletonSet(3)
  val ss3 = singletonSet(4)
  val ss4 = singletonSet(5)
  val ss5 = singletonSet(7)
  val ss6 = singletonSet(1000)
  val set = union(union(union(ss1, ss2), union(ss3, ss4)), union(ss5, ss6))

  printSet(map(set, _+5))

  println(exists(set, x=>x==2))
  println(exists(set, x=>x==4))


}
