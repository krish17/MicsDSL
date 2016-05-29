package mics.dsl.generator

import java.nio.file.Path

import mics.dsl.service.Action

import scala.util.Try

case class ActionGenerator(directory: Path, artifact: Action) extends CodeGenerator[Action] {
  override def generate: Try[String] = ???
}
