package nov.week1

import Nov_01_ConvertBinNumber_Functional.getDecimalValue
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Nov_01_ConvertBinNumber_FunctionalTest extends AnyFlatSpec with Matchers {
  "getDecimalValue" should "convert binary to decimal" in {
    val head = new ListNode(1, new ListNode(0, new ListNode(1, null)))
    getDecimalValue(head) shouldEqual 5
  }

}
