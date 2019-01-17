import java.text.SimpleDateFormat

val date0: String = "2018-10-25'T'12:12:12.111'Z'"
val date1: String = ""
val sdf = new SimpleDateFormat("yyyy-MM-dd")
Some(sdf.parse(date0))
//Some(sdf.parse(date1))
