package nov.week1

// https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3516/

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Nov_01_ConvertBinNumber_Recursion {
  @scala.annotation.tailrec
  def getValue(i: Int, node: ListNode): Int = {
    val value = (i << 1) | node.x
    Option(node.next) match {
      case Some(next) => getValue(value, next)
      case None => value
    }
  }

  def getDecimalValue(head: ListNode): Int = {
    getValue(0, head)
  }
}