package mics.dsl.generator

import java.nio.file.Path

import mics.dsl.service.Output

import scala.util.{Success, Try}

case class OutputGenerator(directory: Path, artifact: Output) extends CodeGenerator[Output] {
  override def generate: Try[String] = Success("TBD")
}
