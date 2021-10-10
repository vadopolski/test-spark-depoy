object SimpleApp {

  def main(args: Array[String]): Unit = {

    val cmdLine =
      """--foo quality_of_service_test
        | --xyz true""".stripMargin


    val testArgs = cmdLine.replace("\r\n", "").split("\\s")


    val config = Config.parseArgs(testArgs)

    println(config)

  }

}
