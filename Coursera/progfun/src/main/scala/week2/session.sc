def sum(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)
}

def product(f: Int=>Int)(a: Int, b: Int): Int = {
  if (a > b) 1 else f(a) * product(f)(a + 1, b)
}
def fact(n: Int): Int = product(x=>x)(1, n)

def mapReduce(f: Int=>Int, combine:(Int, Int)=>Int, zero: Int)(a:Int, b:Int): Int=
  if (a>b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

sum(x => x)(1, 100)
product(x=>x*x)(3,4)
fact(5)

mapReduce(x=>x, (x,y)=>x+y, 0)(1, 100)