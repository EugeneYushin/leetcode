package dec.week4

import scala.util.Try

/**
  * Definition for a binary tree node.
  */
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

case object StopIterationException extends Exception

/**
  * https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3577/
  */
object BalancedBinaryTree {
  def height(node: TreeNode): Int = {
    if (node == null) 0
    else {
      val l_height = height(node.left)
      val r_height = height(node.right)
      if (math.abs(l_height - r_height) > 1) throw StopIterationException
      math.max(l_height, r_height) + 1
    }
  }

  def isBalanced(root: TreeNode): Boolean = {
    Try(height(root)).isSuccess
  }
}
