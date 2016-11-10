package com.thoughtworks.commuter



object CommuterService {

  def calculateDistance(graph : Graph, path: List[Node]): Int ={

    var total = 0
   val lenght = path.length
    for(i <- 0 to lenght -1){
      if(lenght != (i +1)){
         total += findGraphUnit(graph, path(i), path(i+1)).get.distance.distance
      }
    }

    total
  }

  def findGraphUnit(graph : Graph, source : Node, destination: Node): Option[GraphUnit] ={
    graph.find(g => g.source == source && g.destination == destination)
  }
}
