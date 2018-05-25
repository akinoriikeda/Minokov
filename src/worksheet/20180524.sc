case class GID(value: String)

val aclids = Set("AUTHENTICATED_TEST_GROUP_1", "2", "3")

val gids = Seq(
  GID("AUTHENTICATED_TEST_GROUP_1"),
  GID("AUTHENTICATED_TEST_GROUP_2"),
  GID("3"))

val c = gids.map {g =>
  g.value
}

aclids.intersect(c.toSet).map { n =>
  GID(n)
}.toSeq

(aclids.map(GID(_)).intersect(gids.toSet)).toSeq
