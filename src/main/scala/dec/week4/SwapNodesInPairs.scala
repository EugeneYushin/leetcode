package dec.week4

/**
  * Definition for singly-linked list.
  */
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

  override def equals(obj: Any): Boolean = {
    obj match {
      case that: ListNode =>
        that.x == this.x && that.next == this.next
      case _ => false
    }
  }
}

object ListNode {
  def apply(list: List[Int]): ListNode = {
    list.foldRight(null.asInstanceOf[ListNode]) { (value: Int, next: ListNode) =>
      new ListNode(value, next)
    }
  }
}

/**
  * https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3579/
  */
object SwapNodesInPairs {
  def swap(left: ListNode, right: ListNode): Unit = {
    left.next = right.next
    right.next = left
  }

  def swapPairs(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head

    val result = head.next

    var node = head
    var prev = head
    var i = 0

    while (node != null) {
      if (i % 2 == 0) {
        if (node.next != null) {
          prev.next = node.next
        }
        prev = node
        node = node.next
      } else {
        swap(prev, node)
        node = prev.next
      }

      i += 1
    }

    result
  }
}
