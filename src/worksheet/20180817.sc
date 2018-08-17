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
