package dec.week4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SwapNodesInPairsTest extends AnyFlatSpec with Matchers {
  "swapPairs" should "swap every two adjacent nodes and return its head" in {
    val head = ListNode(List())
    SwapNodesInPairs.swapPairs(ListNode(List())) shouldEqual ListNode(List())
    SwapNodesInPairs.swapPairs(ListNode(List(1))) shouldEqual ListNode(List(1))
    SwapNodesInPairs.swapPairs(ListNode(List(1, 2))) shouldEqual ListNode(List(2, 1))
    SwapNodesInPairs.swapPairs(ListNode(List(1, 2, 3))) shouldEqual ListNode(List(2, 1, 3))
    SwapNodesInPairs.swapPairs(ListNode(List(1, 2, 3, 4))) shouldEqual ListNode(List(2, 1, 4, 3))
    SwapNodesInPairs.swapPairs(ListNode(List(1, 2, 3, 4, 5))) shouldEqual ListNode(List(2, 1, 4, 3, 5))
    SwapNodesInPairs.swapPairs(ListNode(List(1, 2, 3, 4, 5, 6))) shouldEqual ListNode(List(2, 1, 4, 3, 6, 5))
  }
}
