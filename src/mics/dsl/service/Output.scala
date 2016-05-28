package mics.dsl.service

trait Output
case class TypedOutput(outputDescription: String, outputType: String) extends Output

object Output {
  implicit class StringToOutput(outputDescription: String) {
    def as(outputType: String): TypedOutput = TypedOutput(outputDescription, outputType)
  }
}