package dec.week1

/**
  * author https://github.com/EugeneYushin
  * https://leetcode.com/problems/spiral-matrix-ii/
  * https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3557/
  */
object Dec_01_07_Spiral_Matrix_2 {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    val matrix = Array.ofDim[Int](n, n)
    val numOfLevels = n / 2 + 1
    var value = 1

    for (level <- 0 to numOfLevels) {
      // left to right
      for (i <- level until n - level) {
        matrix(level)(i) = value
        value += 1
      }

      // top to bottom
      for (i <- level + 1 until n - level) {
        matrix(i)(n - level - 1) = value
        value += 1
      }

      // right to left
      for (i <- n - level - 2 to level by -1) {
        matrix(n - level - 1)(i) = value
        value += 1
      }

      // bottom to top
      for (i <- n - level - 2 until level by -1) {
        matrix(i)(level) = value
        value += 1
      }
    }

    matrix
  }
}
