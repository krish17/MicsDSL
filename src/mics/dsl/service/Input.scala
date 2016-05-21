package mics.dsl.service

trait Input
case class NamedInput(inputName: String) extends Input {
  def typed(inputType: String): TypedInput =
    TypedInput(inputName, inputType)
}
case class TypedInput(inputName: String, inputType: String) extends Input {
  def carries(inputDescription: String): DescribedInput =
    DescribedInput(inputName, inputType, inputDescription)
}
case class DescribedInput(inputName: String, inputType: String, inputDescription: String) extends Input

object Input {
  def input(inputName: String): NamedInput = NamedInput(inputName)
}
