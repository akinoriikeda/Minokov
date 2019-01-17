// http://rirakkumya.hatenablog.com/entry/2013/03/31/191056

trait Cat1 {
  type A
  type B
  def f:A => B
}

trait Cat2 {
  type A
  type B
  type C
  def f:A => B
  def g:B => C
  def f_g:A => C = f andThen g
}

case class Address(zip:String)

object Addr {
  type 住所 = Address
  type 郵便番号 = String
  def zip:住所 => 郵便番号 = _.zip
  def lift(f: 住所 => 郵便番号): Option[住所] => Option[郵便番号] = _ map f
}

Addr.zip(Address("100-0000"))

Some(Address("100-0000")).map(Addr.zip)

Addr.lift(Addr.zip)(Some(Address("100-1000")))

List(Address("100-0000"),Address("200-0000")) map Addr.zip
