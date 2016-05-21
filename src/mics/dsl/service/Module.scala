package mics.dsl.service

trait Module
case class NamedModule(moduleName: String) extends Module {
  def defines(moduleDescription: String): DescribedModule =
    DescribedModule(moduleName, moduleDescription)
}
case class DescribedModule(moduleName: String, moduleDescription: String) extends Module {

  def having(f: (String, String) => ModuleWithActions): ModuleWithActions =
    f(moduleName, moduleDescription)

  def withActions(actions: Action*): ModuleWithActions =
    ModuleWithActions(moduleName, moduleDescription, actions)
}
case class ModuleWithActions(moduleName: String, moduleDescription: String, actions: Seq[Action]) extends Module

object Module {
  def module(moduleName: String): NamedModule =
    NamedModule(moduleName)

  def actions(actionList: Action*)(moduleName: String, moduleDescription: String): ModuleWithActions =
    ModuleWithActions(moduleName, moduleDescription, actionList)
}