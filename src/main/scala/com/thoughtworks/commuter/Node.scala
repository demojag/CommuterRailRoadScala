package com.thoughtworks.commuter

case class Node(city : String)
case class Edge(distance : Int)
case class GraphUnit(source : Node, destination: Node, distance: Edge)

object GraphFactory{

  def create(input : String): Graph ={

    val splittedUnits = input.split(",").map(_.trim()).toList

    for {
      unit <- splittedUnits
      source = Node(unit.charAt(0).toString)
      destination = Node(unit.charAt(1).toString)
      edge = Edge(unit.charAt(2).asDigit)
    }yield GraphUnit(source,destination,edge)
  }
}

object NodeFactory{

  def createFromPath(path : String): List[Node] ={

    val splittedUnits = path.split("-").map(_.trim()).toList

    for {
      unit <- splittedUnits
      node = Node(unit.charAt(0).toString)
    }yield node
  }
}
