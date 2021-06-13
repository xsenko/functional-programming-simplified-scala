import scala.util.Random

object Main extends App {

  println("Starting")
  // implicit type
  val addOne = (i: Int) => i + 1
  val x = addOne(10)
  println(x)

  // expclit type
  val addOneExplicit : Int => Int = (i) => i + 1
  val y = addOneExplicit(20)
  println(y)

  // implicit type
  val addTwoNumber = (a: Int, b:Int) => a + b
  val xx = addTwoNumber(10, 20)
  println(xx)

  // explicit type
  val addTwoNumberExplicit : ((Int, Int) => Int) = (a, b) => a + b
  val yy = addTwoNumberExplicit(20, 30)
  println(yy)

  // explicit type
  val isEven: Int => Boolean = x => x % 2 == 0
  val evenTest = isEven(6)
  println(evenTest)

  // difference between val and def in anonymous functions
  def isEvenDef(i: Int) = i % 2 == 0

  val res1 = isEvenDef(10)
  println("res1 is: " + res1)

  // quick note about list
  // :: operand add beginning
  // :+ operand adds to the end
  val myList = List(2)
  val myList2 = 4 :: myList
  println(myList2)

  val myListA = List(2)
  val myListB = myListA :+ 4
  println(myListB)

  // you can add val functions to a list
  val functionList = List(isEven, addTwoNumberExplicit)
  println(functionList)


  // but you can't do it for def methods
  //val methodList = List(isEvenDef)
  // in scala3 you can also add methods to a list, but currently I'm using scala 2.x

  // but you can both use val and def as a argument
  val someNumebers = List(2,3,4,5,6,7)
  val evenNumbers = someNumebers.filter(isEven)
  println("even numbers with val function: " + evenNumbers)

  val evenNumbers2 = someNumebers.filter(isEvenDef)
  println("even numbers with def: " + evenNumbers2)



  // creating function with Function trait
  val sumTwoNumber = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  val summ = sumTwoNumber(5,7)
  println(summ)

  // remembering the match case syntax
  val rand : Int = Random.nextInt(10)
  val randResult = rand match {
    case 0 => "ZERO"
    case 1 => "ONE"
    case 2 => "TWO"
    case _ => "OTHER"
  }
  println(randResult)


  // you can use val function without match keyword
  val f: (Any) => String = {
    case i: Int => "INT"
    case d: Double => "DOUBLE"
    case _ => "OTHER"
  }

  val result2 = f(10)
  println(result2)

  val anotherList = List(1,2,3,4)
  val anotherResult = anotherList.filter({
    case i:Int => i % 2 == 0
  })
  println(anotherResult)

  // creating anonymous function manually
  val add_One = new Add1
  val add_One_result = add_One(5)
  println(add_One_result)

  // coercing a parameterized method into a function
  def lengthOfThings[T] = (a:T) => a.toString.length

  val ff = lengthOfThings[Int]
  val result_ff = ff(694)
  println(result_ff)

  val sumLengthsAsVal = new SumLengths[String, String]
  val sumLengthsAsValResult = sumLengthsAsVal("homer", "simpsons")
  println(sumLengthsAsValResult)

}
