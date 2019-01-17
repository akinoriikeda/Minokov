import com.amazonaws.services.dynamodbv2.xspec.B
val aaa = {
  println("A")
  println("B")
}
aaa
val c: C = new C

trait A {
  def a: String = {
    "a"
  }
}

trait B {
  def b: String = {
    "b"
  }
}

class C extends A with B {
  def c: (String, String) = {
    (a, b)
  }
}

println(c.c)
