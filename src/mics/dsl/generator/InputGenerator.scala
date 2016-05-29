package mics.dsl.generator

import java.nio.file.Path

import mics.dsl.service.Input

import scala.util.{Success, Try}

case class InputGenerator(directory: Path, artifact: Input) extends CodeGenerator[Input] {
  override def generate: Try[String] = Success("TBD")
}
