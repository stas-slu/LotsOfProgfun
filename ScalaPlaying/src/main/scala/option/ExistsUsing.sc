
private def isActive(config: Config): Boolean = {
  getSomeAppInstance(config).exists(appInstance => callSomething(appInstance.appInstanceInfo))
}

private def getSomeAppInstance(config: Config): Option[AppInstance] = {
  Option(AppInstance("foo"))
}

private def callSomething(id: String): Boolean = {
  try {
    //Something
    true
  } catch {
    case e: Exception =>
      //New Relic
      false
  }
}


case class Config(configInfo: String, manyInfo: Seq[SubConfig])
case class SubConfig(subConfigInfo: String)

case class AppInstance(appInstanceInfo: String)