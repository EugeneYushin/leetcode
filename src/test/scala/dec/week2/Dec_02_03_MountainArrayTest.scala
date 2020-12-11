package dec.week2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Dec_02_03_MountainArrayTest extends AnyFlatSpec with Matchers {
  "validMountainArray" should "check if array is valid mountain array" in {
    Dec_02_03_MountainArray.validMountainArray(Array(0, 2, 3, 4, 5, 2, 1, 0)) shouldEqual true
    Dec_02_03_MountainArray.validMountainArray(Array(0, 2, 3, 4, 5, 4)) shouldEqual true

    Dec_02_03_MountainArray.validMountainArray(Array(0)) shouldEqual false
    Dec_02_03_MountainArray.validMountainArray(Array(0, 2)) shouldEqual false
    Dec_02_03_MountainArray.validMountainArray(Array(1, 2, 3)) shouldEqual false
    Dec_02_03_MountainArray.validMountainArray(Array(3, 2, 1)) shouldEqual false
    Dec_02_03_MountainArray.validMountainArray(Array(0, 2, 3, 3, 5, 2, 1, 0)) shouldEqual false
    Dec_02_03_MountainArray.validMountainArray(Array(3, 7, 20, 14, 15, 14, 10, 8, 2, 1)) shouldEqual false
  }

}
