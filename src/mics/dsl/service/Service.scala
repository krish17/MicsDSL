package mics.dsl.service

sealed trait Service {
  def generate: String = {
    "TBD"
  }
}

case class NamedService(serviceName: String) extends Service {
  def defines(serviceDescription: String): DescribedService =
    DescribedService(serviceName, serviceDescription)
}

case class DescribedService(serviceName: String, serviceDescription: String) extends Service {

  def having(f: (String, String) => ServiceWithModules): ServiceWithModules =
    f(serviceName, serviceDescription)

  def withModules(modules: Module*): ServiceWithModules =
    ServiceWithModules(serviceName, serviceDescription, modules)
}

case class ServiceWithModules(serviceName: String, serviceDescription: String, modules: Seq[Module]) extends Service

object Service {
  def service(serviceName: String): NamedService = NamedService(serviceName)

  def modules(moduleList: Module*)(serviceName: String, serviceDescription: String): ServiceWithModules =
    ServiceWithModules(serviceName, serviceDescription, moduleList)
}