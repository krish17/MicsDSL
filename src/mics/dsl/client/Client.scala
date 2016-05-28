package mics.dsl.client

import mics.dsl.service.Service._
import mics.dsl.service.Module._
import mics.dsl.service.Action._
import mics.dsl.service.Input._
import mics.dsl.service.Output._

object Client extends App {

  val myService = service("MyTestService") defines "My testing service" at "com.sample.dsl" having modules (

    module("FirstTestModule") defines "First test module" having actions (

        action("doFirstThing") to "Do the first thing" takes (
            input("inputOne") as "Integer" carries "person's age"
          ) and returns ("Some output" as "String"),

        action("doSecondThing") to "Do the second thing" takes (
            input("inputOne") as "Double" carries "person's salary",
            input("inputTwo") as "Double" carries "tax rate"
          ) and returns ("Some output" as "Double")
      ),

    module("SecondTestModule") defines "First test module" having actions (
        action("doFirstThing") to "Do the first thing",
        action("doSecondThing") to "Do the second thing"
      )
  )

  myService.generate("C:/sldkfj/lsdfj")
}
