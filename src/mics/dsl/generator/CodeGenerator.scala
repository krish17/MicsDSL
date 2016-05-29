package mics.dsl.generator

import java.nio.file.{Paths, Path}

import mics.dsl.service.Service

import scala.util.Try

trait CodeGenerator[T] {
  def directory: Path
  def artifact: T
  def generate: Try[String]
}

object CodeGenerator {

  implicit class ServiceCodeGenerator(service: Service) {
    def generateCode(directory: String): Try[Boolean] = {
      val path = Paths.get(directory)
      val codeGenerator = ServiceGenerator(path, service)
      codeGenerator.generate.map(_ => true)
    }
  }
}