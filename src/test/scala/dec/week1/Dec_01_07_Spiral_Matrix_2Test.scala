package dec.week1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Dec_01_07_Spiral_Matrix_2Test extends AnyFlatSpec with Matchers {
  "generateMatrix" should "return spirtal matrix for odd n" in {
    Dec_01_07_Spiral_Matrix_2.generateMatrix(3) shouldEqual Array(
      Array(1, 2, 3),
      Array(8, 9, 4),
      Array(7, 6, 5)
    )
  }

  it should "return spirtal matrix for even n" in {
    Dec_01_07_Spiral_Matrix_2.generateMatrix(4) shouldEqual Array(
      Array(1, 2, 3, 4),
      Array(12, 13, 14, 5),
      Array(11, 16, 15, 6),
      Array(10, 9, 8, 7)
    )
  }

}
