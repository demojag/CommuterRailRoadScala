import com.thoughtworks.commuter.{Edge, Node, GraphUnit, GraphFactory}
import org.scalatest.{FunSuite}

class RailRoadServiceTest extends FunSuite{

  val graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"

  test("Graph is generated"){

    val expected = List[GraphUnit](
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
    val created = GraphFactory.create(graph)

    assert(created.length == 9)

    for(i <- 0 to created.length -1) {
      assert(created(i) == expected(i))
    }
  }

  test("The distance of the route A-B-C"){
    

    assert(true)
  }
}
