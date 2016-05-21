package mics.dsl.client

import mics.dsl.service.Service._
import mics.dsl.service.Module._
import mics.dsl.service.Action._
import mics.dsl.service.Input._
import mics.dsl.service.Output._

object Client extends App {

  val myService = service("MyTestService") defines "My testing service" having modules (

    module("FirstTestModule") defines "First test module" having actions (

        action("doFirstThing") to "Do the first thing" takes (
            input("inputOne") typed "Integer" carries "person's age"
          ) and returns ("Some output" typed "String"),

        action("doSecondThing") to "Do the second thing" takes (
            input("inputOne") typed "Double" carries "person's salary",
            input("inputTwo") typed "Double" carries "tax rate"
          ) and returns ("Some output" typed "Double")
      ),

    module("SecondTestModule") defines "First test module" having actions (
        action("doFirstThing") to "Do the first thing",
        action("doSecondThing") to "Do the second thing"
      )
  )

  myService.generate
}
