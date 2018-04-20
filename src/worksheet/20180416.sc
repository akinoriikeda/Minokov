val m = Map("abc"->1)

m.put("def", 2)

//

val mm = scala.collection.mutable.Map("abc"->1)

mm.put("def", 2)
mm

mm.put("def", 3)
mm

//

val mmm = scala.collection.mutable.Map('a->11, 'c->33)

mmm.getOrElseUpdate('b, 9)
mmm

mmm.getOrElseUpdate('b, 789)
mmm

mmm.getOrElse('b, 2222)
mmm

mmm.update('b, 2222)
mmm

mmm.update('d, 88)
mm



