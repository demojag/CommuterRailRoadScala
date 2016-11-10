import com.thoughtworks.commuter._
import org.scalatest.{FunSuite}

class RailRoadServiceTest extends FunSuite{

  val graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"

  val stubGraph : Graph = List[GraphUnit](
    GraphUnit(Node("A"), Node("B"), Edge(5)),
    GraphUnit(Node("B"), Node("C"), Edge(4)),
    GraphUnit(Node("C"), Node("D"), Edge(8)),
    GraphUnit(Node("D"), Node("C"), Edge(8)),
    GraphUnit(Node("D"), Node("E"), Edge(6)),
    GraphUnit(Node("A"), Node("D"), Edge(5)),
    GraphUnit(Node("C"), Node("E"), Edge(2)),
    GraphUnit(Node("E"), Node("B"), Edge(3)),
    GraphUnit(Node("A"), Node("E"), Edge(7))
    )

  test("Graph is generated"){

    val created = GraphFactory.create(graph)

    assert(created.length == stubGraph.length)

    for(i <- 0 to created.length -1) {
      assert(created(i) == stubGraph(i))
    }
  }

  test("List of node is generated for a path"){
    val path = "A-B-C"

    val expectedNodes = List[Node](Node("A"),Node("B"),Node("C"))

    val actualNodes = NodeFactory.createFromPath(path)

    assert(actualNodes.length == 3)
    for(i <- 0 to actualNodes.length -1) {
      assert(actualNodes(i) == expectedNodes(i))
    }

  }

  test("The distance of the route A-B-C"){


    val expectedDistance = 9

    val actualDistance = CommuterService.calculateDistance(stubGraph,List[Node](Node("A"),Node("B"),Node("C")) )

    assert(expectedDistance == actualDistance)
  }
}
