import com.github.plokhotnyuk.jsoniter_scala.core.{JsonValueCodec, readFromArray}
import com.github.plokhotnyuk.jsoniter_scala.macros.JsonCodecMaker

object JsonParse extends App {
  case class Device(id: Int, model: String)
  case class User(name: String, devices: Seq[Device])

  implicit val codec: JsonValueCodec[User] = JsonCodecMaker.make[User]

  private val bytes = """{"name":"John","devices":[{"id":1,"model":"HTC One X"}]}""".getBytes("UTF-8")

  val user: User = readFromArray(bytes)(codec)

  println(user)
}
