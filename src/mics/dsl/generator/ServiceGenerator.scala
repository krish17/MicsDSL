package mics.dsl.generator

import java.nio.file.Path
import mics.dsl.service.Service
import scala.util.Try

case class ServiceGenerator(directory: Path, artifact: Service) extends CodeGenerator[Service] {
  override def generate: Try[String] = ???
}
