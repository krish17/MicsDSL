package mics.dsl.service

import mics.dsl.generator.CodeGenerator

sealed trait Service extends CodeGenerator

case class NamedService(serviceName: String) extends Service {
  def defines(serviceDescription: String): DescribedService =
    DescribedService(serviceName, serviceDescription)
}

case class DescribedService(serviceName: String, serviceDescription: String) extends Service {
  def at(packageName: String): PackagedService =
    PackagedService(serviceName, serviceDescription, packageName)
}

case class PackagedService(serviceName: String, serviceDescription: String, packageName: String) extends Service {
  def having(f: (String, String, String) => ServiceWithModules): ServiceWithModules =
    f(serviceName, serviceDescription, packageName)

  def withModules(modules: Module*): ServiceWithModules =
    ServiceWithModules(serviceName, serviceDescription, packageName, modules)
}

case class ServiceWithModules(serviceName: String, serviceDescription: String, packageName: String, modules: Seq[Module]) extends Service

object Service {
  def service(serviceName: String): NamedService = NamedService(serviceName)

  def modules(moduleList: Module*)(serviceName: String, serviceDescription: String, packageName: String): ServiceWithModules =
    ServiceWithModules(serviceName, serviceDescription, packageName, moduleList)
}