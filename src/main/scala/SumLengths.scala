class SumLengths[A, B] extends Function2[A, B, Int] {
  def apply(a: A, b: B): Int = a.toString.length + b.toString.length
}
