package mics.dsl.service

trait Action
case class NamedAction(actionName: String) extends Action {
  def to(actionDescription: String): DescribedAction =
    DescribedAction(actionName, actionDescription)
}
case class DescribedAction(actionName: String, actionDescription: String) extends Action {
  def takes(inputs: Input*): ActionWithInputs =
    ActionWithInputs(actionName, actionDescription, inputs)
}
case class ActionWithInputs(actionName: String, actionDescription: String, inputs: Seq[Input]) extends Action {
  def and(f: (String, String, Seq[Input]) => ActionWithOutput): ActionWithOutput =
    f(actionName, actionDescription, inputs)
}
case class ActionWithOutput(actionName: String, actionDescription: String, input: Seq[Input], output: Output) extends Action

object Action {
  def action(endPointName: String): NamedAction = new NamedAction(endPointName)
  def returns(output: Output)(actionName: String, actionDescription: String, inputs: Seq[Input]): ActionWithOutput =
    ActionWithOutput(actionName, actionDescription, inputs, output)
}