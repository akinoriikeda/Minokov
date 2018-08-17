import com.amazonaws.regions.Regions

//val d1 = sys.env.get("AWS_REGION")
//val d2 = Regions.AP_NORTHEAST_1
//val d3 = Regions.fromName("us-east-1")
//val d4 = Regions.fromName("ap-northeast-1")
//
//val dummy1 = sys.env.get("AWS_REGION")
//            .fold(Regions.US_EAST_1)(Regions.fromName)
//val dummy2 = sys.env.get("AWS_REGION")
//             .fold(Regions.AP_NORTHEAST_1)(Regions.fromName)

val a: Option[String] = Some("us-east-1")
val b: Option[String] = None
val c = a.fold(Regions.AP_NORTHEAST_1)(Regions.fromName)
val d = b.fold(Regions.AP_NORTHEAST_1)(Regions.fromName)

//==============================================

// https://waman.hatenablog.com/entry/2017/03/19/022907

val intSeq = Seq(1, 3, 5, 7, 9, 11, 13, 15, 17, 19)
val strSeq = Seq("a", "b", "c", "d", "e")

//def fold[A1 >: A](z: A1)(op: (A1, A1) ⇒ A1): A1

val result00 = intSeq.fold(0)((m, n) => m + n)
assert( result00 == 100 )

val result01 = intSeq.fold(0)(_+_)
assert( result01 == 100 )

val result02 = strSeq.fold("")(_+_)
assert( result02 == "abcde" )

val result03 = intSeq.fold(0)((sum2, n) => sum2 + n*n)
assert( result03 == 1330 )

//def foldLeft[B](z: B)(op: (B, A) ⇒ B): B

val result10 = intSeq.foldLeft(0)((sum2, n) => sum2 + n*n )
assert( result10 == 1330)

def builder = Seq.newBuilder[String]

val result11 = strSeq.foldLeft(builder)((b, s) => b += s).result
assert( result11 == Seq("a", "b", "c", "d", "e"))

val result12 = strSeq.foldLeft(builder)(_+=_).result
assert( result12 == Seq("a", "b", "c", "d", "e"))

//def /:[B](z: B)(op: (B, A) ⇒ B): B // foldleft と同様

assert( strSeq./:(builder)(_+=_).result  == Seq("a", "b", "c", "d", "e") )

assert( (builder /: strSeq)(_+=_).result  == Seq("a", "b", "c", "d", "e") )

//def foldRight[B](z: B)(op: (A, B) ⇒ B): B

val result20 = intSeq.foldRight(0)((n, sum2) => n*n + sum2)
assert( result20 == 1330 )

val emp0 = Seq[String]()
val result21 = strSeq.foldRight(emp0)((s, acc) => s +: acc)
assert( result21 == Seq("a", "b", "c", "d", "e") )

assert( strSeq.foldRight(emp0)(_+:_) == Seq("a", "b", "c", "d", "e") )

//def :\[B](z: B)(op: (A, B) ⇒ B): B // foldright と同様

assert( strSeq.:\(emp0)(_+:_) == Seq("a", "b", "c", "d", "e") )

assert( (strSeq :\ emp0)(_+:_) == Seq("a", "b", "c", "d", "e") )

//def aggregate[B](z: ⇒ B)(seqop: (B, A) ⇒ B, combop: (B, B) ⇒ B): B

val result30 = intSeq.aggregate(0)((s, n) => s + n*n, _+_)
assert( result30 == 1330)

val emp1 = Vector[Int]()
val result1 = intSeq.aggregate(emp1)((s, n) => s :+ n*n, _++: _)
assert( result1 == Seq(1, 9, 25, 49, 81, 121, 169, 225, 289, 361) )

//def reduce[A1 >: A](op: (A1, A1) ⇒ A1): A1

assert( intSeq.reduce(_+_) == 100 )

try{
  Seq[String]().reduce(_+_) // 空の Seq に対して呼び出すと例外を投げる
  assert(false)
}catch{
  case ex: UnsupportedOperationException => assert(true)
}

//def reduceOption[A1 >: A](op: (A1, A1) ⇒ A1): Option[A1]

intSeq.reduceOption(_+_) match {
  case Some(sum) => println(s"[reduceOption] $sum")
  case None      => println("[reduceOption] error!")
}
Seq[String]().reduceOption(_+_) match {
  case Some(sum) => println(s"[reduceOption] $sum")
  case None      => println("[reduceOption] error!")
}

//def reduceLeft[B >: A](op: (B, A) ⇒ B): B

//def reduceLeftOption[B >: A](op: (B, A) ⇒ B): Option[B]

//def reduceRight[B >: A](op: (A, B) ⇒ B): B

val seqSeq = Seq(Seq(0), Seq(0, 1), Seq(0, 1, 2), Seq(0, 1, 2, 3))
assert( seqSeq.reduceRight(_++:_) == Seq(0, 0, 1, 0, 1, 2, 0, 1, 2, 3) )
assert( seqSeq.flatten == Seq(0, 0, 1, 0, 1, 2, 0, 1, 2, 3) ) // reduceRight と同じ結果

//def reduceRightOption[B >: A](op: (A, B) ⇒ B): Option[B]

//--

val f: (String, String) => String = (x, y) => x + ", " + y  // ", " を挟んで文字列を結合

// fold 系メソッド
assert( strSeq.fold("")(f) == ", a, b, c, d, e")
assert( strSeq.foldLeft("")(f) == ", a, b, c, d, e")  // fold と同じ
assert( strSeq.foldRight("")(f) == "a, b, c, d, e, " )

// reduce 系メソッド
assert( strSeq.reduce(f) == "a, b, c, d, e" )
assert( strSeq.reduceLeft(f) == "a, b, c, d, e" )  // reduce と同じ
assert( strSeq.reduceRight(f) == "a, b, c, d, e" )  // reduce と同じ結果

//def scan[B >: A, That](z: B)(op: (B, B) ⇒ B)(implicit cbf: CanBuildFrom[Seq[A], B, That]): That

val resultSeq = intSeq.scan(0)(_+_)
assert( resultSeq.length == 11)  // 返される Seq オブジェクトの長さは11
assert( resultSeq == Seq(0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100) )
// == Seq(0, 0+1, 0+1+3, 0+1+3+5, 0+1+3+5+7, ... )

assert( strSeq.scan("")(_+_) == Seq("", "a", "ab", "abc", "abcd", "abcde") )

//def scanLeft[B, That](z: B)(op: (B, A) ⇒ B)(implicit bf: CanBuildFrom[Seq[A], B, That]): That

assert( strSeq.scanLeft("")(_+_) == Seq("", "a", "ab", "abc", "abcd", "abcde") )

val emp2 = Vector[String]()
assert( strSeq.scanLeft(emp2)(_:+_) ==
  Seq(
    Seq(),
    Seq("a"),
    Seq("a", "b"),
    Seq("a", "b", "c"),
    Seq("a", "b", "c","d"),
    Seq("a", "b", "c", "d", "e"))
)

//def scanRight[B, That](z: B)(op: (A, B) ⇒ B)(implicit bf: CanBuildFrom[Seq[A], B, That]): That

assert( strSeq.scanRight("")(_+_) == Seq("abcde", "bcde", "cde", "de", "e", ""))

val emp3 = Seq[String]()
assert( strSeq.scanRight(emp3)(_+:_) ==
  Seq(
    Seq("a", "b", "c", "d", "e"),
    Seq("b", "c", "d", "e"),
    Seq("c", "d", "e"),
    Seq("d", "e"),
    Seq("e"),
    Seq()
  )
)
