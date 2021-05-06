package year2021.jan.week1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class KthMissingPositiveNumberTest extends AnyFlatSpec with Matchers {
  "findKthPositive" should "find Kth missing positive number" in {
    KthMissingPositiveNumber.findKthPositive(Array(2, 3, 4, 7, 11), 5) shouldEqual 9
    KthMissingPositiveNumber.findKthPositive(Array(2, 3, 4, 7, 10), 5) shouldEqual 9
    KthMissingPositiveNumber.findKthPositive(Array(2, 3, 4, 7, 9), 5) shouldEqual 10
    KthMissingPositiveNumber.findKthPositive(Array(5), 3) shouldEqual 3
    KthMissingPositiveNumber.findKthPositive(Array(1000), 1000) shouldEqual 1001
  }
}
