package dec.week4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable

class BalancedBinaryTreeTest extends AnyFlatSpec with Matchers {
  def createNode(i: Int, arr: Array[Integer]): TreeNode = {
    if (i <= arr.length) {
      if (arr(i - 1) == null) {
        null
      } else {
        val node = new TreeNode(arr(i - 1))
        node.left = createNode(2 * i, arr)
        node.right = createNode(2 * i + 1, arr)
        node
      }
    } else null
  }

  def stringify(node: TreeNode): String = {
    val l = new mutable.ListBuffer[TreeNode]()
    val q = mutable.Queue[TreeNode]()
    val s = new mutable.StringBuilder()

    q.enqueue(node)

    while (q.nonEmpty) {
      val node = q.dequeue()
      l.append(node)
      if (node != null) {
        q.enqueue(node.left)
        q.enqueue(node.right)
      }
    }

    // remove extra nulls from tail
    l.dropRightInPlace(l.reverseIterator.takeWhile(_ == null).count(_ => true))

    for (i <- 0 to (math.log(l.length) / math.log(2)).toInt) {
      val numOfChars = math.pow(2, i).toInt
      s.append(l.take(numOfChars).map(n => Option(n).map(_.value).getOrElse("null")).mkString(","))
      s.append("#")
      l.dropInPlace(numOfChars)
    }

    s.toString()
  }

  "isBalanced" should "determine if tree is height-balanced" in {
    BalancedBinaryTree.isBalanced(createNode(1, Array[Integer](3, 9, 20, null, null, 15, 7))) shouldBe true
    BalancedBinaryTree.isBalanced(createNode(1, Array[Integer](1, 2, 2, 3, 3, null, null, 4, 4))) shouldBe false

    // /\-shape tree with no center part
    BalancedBinaryTree.isBalanced(createNode(1, Array[Integer](1, 2, 2, 3, null, null, 3, 4, null, null, 4))) shouldBe false
  }
}
