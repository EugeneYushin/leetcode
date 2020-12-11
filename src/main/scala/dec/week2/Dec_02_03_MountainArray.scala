package dec.week2

/**
  * https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3561/
  */
object Dec_02_03_MountainArray {
//  def validMountainArray2(arr: Array[Int]): Boolean = {
//    if (arr.length < 3) {
//      false
//    }
//    else {
//      var isValidMountainArray = true
//      var prev = arr.head
//      var i = 1
//      var leftSlope = true
//
//      while (isValidMountainArray && i < arr.length) {
//        val curr = arr(i)
//        if (prev == curr) {
//          isValidMountainArray = false
//        } else {
//          if (leftSlope)
//            if (prev < curr) {
//              prev = curr
//            } else if (i == 1) {
//              isValidMountainArray = false
//            } else {
//              prev = curr
//              leftSlope = false
//            }
//          else {
//            if (prev > curr) {
//              prev = curr
//            } else {
//              isValidMountainArray = false
//            }
//          }
//          i += 1
//        }
//      }
//      isValidMountainArray && !leftSlope
//    }
//  }

  def validMountainArray(arr: Array[Int]): Boolean = {
    if (arr.length < 3) {
      false
    } else {
      var prev = arr.head
      val rightSlope = arr.tail.dropWhile { i =>
        val res = i > prev
        if (res) prev = i
        res
      }

      if (rightSlope.isEmpty || prev == arr.head) false
      else rightSlope.dropWhile { i =>
        val res = i < prev
        if (res) prev = i
        res
      }.isEmpty
    }
  }
}
