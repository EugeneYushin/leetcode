package year2021.jan.week1

object KthMissingPositiveNumber {
  def findKthPositive(arr: Array[Int], k: Int): Int = {
    var proceed = true
    var prev = 0
    var i = 0
    var n = k

    while (proceed && i < arr.length) {
      val curr = arr(i)
      val diff = curr - prev
      if (n - diff + 1 <= 0) {
        proceed = false
      } else {
        n = n - diff + 1
        prev = curr
        i = i + 1
      }
    }

    if (i == 0) 0 + n
    else if (i == arr.length) arr.last + n
    else arr(i - 1) + n
  }
}
