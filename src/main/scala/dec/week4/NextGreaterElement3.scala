package dec.week4

/**
  * https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3578/
  */
object NextGreaterElement3 {
  def findPos(arr: Array[Int], from: Int, to: Int, value: Int): Int = {
    // desc sorted arr
    if (to - from == 1) {
      to
    }
    else if (value >= arr((to + from) / 2)) {
      // left
      findPos(arr, from, (to + from) / 2, value)
    } else {
      // right
      findPos(arr, (to + from) / 2, to, value)
    }
  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def nextGreaterElement(input: Int): Int = {
    val arr = input.toString.map(_.asDigit).toArray
    val l = arr.length

    // find pre-sorted tail (N-th array from tail to mix)
    var n = 1
    var proceed = true

    while (proceed) {
      if (n == l || arr(l - n) > arr(l - n - 1)) {
        proceed = false
      }
      n += 1
    }

    // shortcut when input is already max available combination
    if (n > l) return -1

    // find position where to move most significant digit (N from tail)
    // which is not a part of pre-sorted tail
    val offset = l - n
    val pos = findPos(arr, offset, l, arr(offset)) - offset

    // re-order digits which are greater than N+1-th (0, 1, ..., l-N+1, [elements], pos, ...)
    for (i <- 1 to (pos - 1) / 2) {
      swap(arr, offset + i, offset + pos - i)
    }

    // swap N with the head of sub-array from the previous step
    swap(arr, l - n, l - n + 1)

    // move [pos..end] before [N..pos] (re-ordered)
    for (i <- offset + pos until l) {
      val temp = arr.last
      // shift right
      for (j <- l - 1 to i - pos + 1 by -1) {
        arr(j) = arr(j - 1)
      }
      arr(i - pos + 1) = temp
    }

    val result = arr.mkString.toLong

    if (result == input || result > Int.MaxValue) -1 else result.toInt
  }
}
