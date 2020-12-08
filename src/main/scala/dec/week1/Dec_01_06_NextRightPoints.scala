package dec.week1

/**
 * Definition for a Node.
 */
class Node(var _value: Int) {
  var value: Int = _value
  var left: Node = null
  var right: Node = null
  var next: Node = null
}

/**
 * author https://github.com/EugeneYushin
 * https://leetcode.com/explore/featured/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3556/
 */
object Dec_01_06_NextRightPoints {
  def nextRight(node: Node): Node = {
    if (node == null) null
    else Option(node.left).orElse(Option(node.right)).getOrElse(nextRight(node.next))
  }

  def connect(root: Node): Node = {
    if (root == null) return root
    if (root.left != null) {
      root.left.next = Option(root.right).getOrElse(nextRight(root.next))
    }
    if (root.right != null) {
      root.right.next = nextRight(root.next)
    }

    // order matters here, need to fulfill right branch first for valid referencing from left
    connect(root.right)
    connect(root.left)
    root
  }
}
