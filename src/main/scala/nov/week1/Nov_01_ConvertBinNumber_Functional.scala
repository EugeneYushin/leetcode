package nov.week1

// https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3516/

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */

object Nov_01_ConvertBinNumber_Functional {
  def getDecimalValue(head: ListNode): Int = {
    Iterator.unfold(head) {
      case null => None
      case node => Some(node.x, node.next)
    }.foldLeft(0)((res, x) => (res << 1) | x)
  }
}