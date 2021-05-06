package year2021.jan.week1

/**
  * Definition for singly-linked list.
  *
  */
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object RemoveDuplicatesFromSortedList2 {
  def eq(x: ListNode, y: ListNode): Boolean = {
    if (x != null && y != null) {
      if (x.x == y.x) true else false
    } else false
  }

  def deleteDuplicates(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head

    var prev: ListNode = null
    var tail: ListNode = null
    var newHead: ListNode = null
    var node = head

    while (node != null) {
      if (!eq(node, prev) && !eq(node, node.next)) {
        if (tail == null) newHead = node else tail.next = node
        tail = node
      }
      prev = node
      node = node.next
    }

    if (tail != null) tail.next = null

    newHead
  }
}
