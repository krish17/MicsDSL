package mics.dsl.generator

import java.nio.file.Path
import mics.dsl.service._
import scala.util.Try
import scala.sys.process._

case class ServiceGenerator(directory: Path, artifact: Service) extends CodeGenerator[Service] {
  override def generate: Try[String] = artifact match {
    case NamedService(serviceName) =>
      createProject(serviceName)
    case DescribedService(serviceName, serviceDescription) =>
      createProject(serviceName)
    case PackagedService(serviceName, serviceDescription, packageName) =>
      createProject(serviceName)
    case ServiceWithModules(serviceName, serviceDescription, packageName, modules) =>
      createProject(serviceName)
  }

  private def createProject(projectName: String): Try[String] = Try {
    val activatorCmd = s"C:\\play\\activator\\dist-1.3.10\\bin\\activator.bat new $directory/$projectName play-scala"
    activatorCmd.!!
  }
}
