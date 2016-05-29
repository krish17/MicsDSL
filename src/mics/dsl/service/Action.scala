package mics.dsl.service

sealed trait Action

case class NamedAction(actionName: String, actionType: ActionType = Get) extends Action {
  def to(actionDescription: String): DescribedAction =
    DescribedAction(actionName, actionType, actionDescription)
}
case class DescribedAction(actionName: String, actionType: ActionType, actionDescription: String) extends Action {
  def takes(inputs: Input*): ActionWithInputs =
    ActionWithInputs(actionName, actionType, actionDescription, inputs)
}
case class ActionWithInputs(actionName: String, actionType: ActionType, actionDescription: String, inputs: Seq[Input]) extends Action {
  def and(f: (String, ActionType, String, Seq[Input]) => ActionWithOutput): ActionWithOutput =
    f(actionName, actionType, actionDescription, inputs)
}
case class ActionWithOutput(actionName: String, actionType: ActionType, actionDescription: String, input: Seq[Input], output: Output) extends Action

object Action {
  def get(endPointName: String): NamedAction = new NamedAction(endPointName, Get)
  def add(endPointName: String): NamedAction = new NamedAction(endPointName, Post)
  def update(endPointName: String): NamedAction = new NamedAction(endPointName, Put)
  def delete(endPointName: String): NamedAction = new NamedAction(endPointName, Delete)
  def action(endPointName: String): NamedAction = new NamedAction(endPointName)
  def returns(output: Output)(actionName: String, actionType: ActionType, actionDescription: String, inputs: Seq[Input]): ActionWithOutput =
    ActionWithOutput(actionName, actionType, actionDescription, inputs, output)
}