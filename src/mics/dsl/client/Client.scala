package mics.dsl.client

import mics.dsl.service.Service._
import mics.dsl.service.Module._
import mics.dsl.service.Action._
import mics.dsl.service.Input._
import mics.dsl.service.Output._

object Client extends App {

  val myService = service("Library") defines "Library service application" at "org.library.dsl" having modules (

    module("User") defines "User management" having actions (

        action("register") to "Register a new user" takes (
            input("userName") as "UserName" carries "Member's user name",
            input("password") as "Password" carries "user password",
            input("address") as "Address" carries "user address"
          ) and returns ("User account" as "User"),

        action("modify") to "Modify user account details" takes (
            input("userName") as "UserName" carries "Member's user name",
            input("address") as "Address" carries "Member's new address"
          ) and returns ("Updated user" as "User")
      ),

    module("Catalog") defines "Books and Magazine catalog management" having actions (

        action("addItem") to "Add a new catalog item" takes (
            input("item") as "CatalogItem" carries "Catalog item"
          ) and returns ("Catalog item id" as "CatalogItemDetails"),

        action("removeItem") to "Remove a catalog item" takes (
            input("itemId") as "CatalogItemId" carries "Catalog item id"
          ) and returns ("Removed catalog item id" as "CatalogItemId")
      )
  )

  myService.generate("C:/play/activator/projects/library")
}
