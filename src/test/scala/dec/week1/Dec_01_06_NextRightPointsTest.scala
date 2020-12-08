package dec.week1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable

class Dec_01_06_NextRightPointsTest extends AnyFlatSpec with Matchers {
  def createNode(i: Int, arr: Array[Integer]): Node = {
    if (i <= arr.length) {
      if (arr(i - 1) == null) {
        null
      } else {
        val node = new Node(arr(i - 1))
        node.left = createNode(2*i, arr)
        node.right = createNode(2*i + 1, arr)
        node
      }
    } else null
  }

  def linearize(root: Node): List[Option[Int]] = {
    val q = mutable.Queue[Node]()
    val l = mutable.ListBuffer[Option[Int]]()
    q.enqueue(root)
    while (q.nonEmpty) {
      val node = q.dequeue()
      if (node != null) {
        l += Some(node.value)
        q.enqueue(node.left)
        q.enqueue(node.right)
      } else {
        l += None
      }
    }
    l.toList
  }

  def stringify(root: Node): String = {
    val q = mutable.Queue[Node]()
    val b = new mutable.StringBuilder()

    q.enqueue(root)
    while (q.nonEmpty) {
      var node = q.dequeue()
      if (node != null) {
        var nextLevel = Option(node.left).orElse(Option(node.right)).orNull

        while (node.next != null) {
          b.append(node.value)
          node = node.next
          if (nextLevel == null) {
            nextLevel = Option(node.left).orElse(Option(node.right)).orNull
          }
        }
        b.append(node.value)
        b.append("#")
        q.enqueue(nextLevel)
      }
    }

    b.toString()
  }

  "connect" should "connect next right vertexes" in {
    val input = Array[Integer](2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7)
    val root = createNode(1, input)

    val actual = Dec_01_06_NextRightPoints.connect(root)

    stringify(actual) shouldEqual "2#13#0791#21088#7#"
  }
}
