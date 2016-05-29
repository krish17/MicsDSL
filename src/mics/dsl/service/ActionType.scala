package mics.dsl.service

sealed trait ActionType
case object Get extends ActionType
case object Post extends ActionType
case object Put extends ActionType
case object Delete extends ActionType