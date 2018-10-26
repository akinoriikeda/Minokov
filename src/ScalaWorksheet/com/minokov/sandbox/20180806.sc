// https://gist.github.com/gakuzzzz/10104162

val f1: Function1[Int, String] = new Function1[Int, String] {
  def apply(arg: Int): String = arg.toString
}
f1.apply(10)

// Function0 ～ Function22 の型は => を使って記述する事ができます。
val f2: (Int) => String = new Function1[Int, String] {
  def apply(arg: Int): String = arg.toString
}
f2.apply(10)

// Function0 ～ Function22 のインスタンスは、 => を使って記述することができます。
val f3: (Int) => String = (arg: Int) => arg.toString
f3.apply(10)

// 引数の型が自明の時は、型アノテーションを省略する事ができます。
val f4: (Int) => String = (arg) => arg.toString
f4.apply(10)

// 引数が一つの場合(つまりFunction1の時)、引数グループの括弧を省略できます。
val f5: Int => String = arg => arg.toString
f5.apply(10)

// 全ての引数が、1回のみ使われる場合は、引数の宣言を省略し、_ で表現することができます。
val f6: Int => String = _.toString
f6.apply(10)

// apply という名前のメソッドは省略することができます。
val f7: Int => String = _.toString
f7(10)
