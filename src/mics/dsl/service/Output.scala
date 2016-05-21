package mics.dsl.service

trait Output
case class DescribedOutput(outputDescription: String) extends Output
case class TypedOutput(outputDescription: String, outputType: String) extends Output

object Output {
  implicit class StringToOutput(outputDescription: String) {
    def typed(outputType: String): TypedOutput = TypedOutput(outputDescription, outputType)
  }
}