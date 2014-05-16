package recfun

import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == r || c == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def loop(count: Int, chs: List[Char]): Boolean = {
      if (count < 0) false
      else if (chs.isEmpty && count != 0) false
      else if (chs.isEmpty) true
      else if (chs.head == '(') loop(count + 1, chs.tail)
      else if (chs.head == ')') loop(count - 1, chs.tail)
      else loop(count, chs.tail)
    }
    loop(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty || money < 0) 0
    else if (money == 0) 1
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
