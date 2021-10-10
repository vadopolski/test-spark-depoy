import java.io.File
import scopt.OParser

case class Config(
    foo: String = "-1",
    out: File = new File("."),
    xyz: Boolean = false,
    libName: String = "",
    maxCount: Int = -1,
    verbose: Boolean = false,
    debug: Boolean = false,
    mode: String = "",
    files: Seq[File] = Seq(),
    keepalive: Boolean = false,
    jars: Seq[File] = Seq(),
    kwargs: Map[String, String] = Map()
)

object Config {
  val builder = OParser.builder[Config]

  val parser1 = {
    import builder._
    OParser.sequence(
      programName("scopt"),
      head("scopt", "4.x"),
      // option -f, --foo
      opt[String]('f', "foo")
        .action((x, c) => c.copy(foo = x))
        .text("foo is an integer property"),
      opt[Boolean]('x', "xyz")
        .action((x, c) => c.copy(xyz = x))
        .text("foo is an integer property")
      // more options here...
    )
  }

  def parseArgs(args: Array[String]): Config =
    OParser
      .parse(parser1, args, Config())
      .getOrElse(sys.error("Could not parse arguments"))
}
