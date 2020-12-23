package dec.week4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NextGreaterElement3Test extends AnyFlatSpec with Matchers {
  "nextGreaterElement" should "find the smallest integer > N" in {
    NextGreaterElement3.nextGreaterElement(1) shouldEqual -1
    NextGreaterElement3.nextGreaterElement(12) shouldEqual 21
    NextGreaterElement3.nextGreaterElement(21) shouldEqual -1
    NextGreaterElement3.nextGreaterElement(100) shouldEqual -1
    NextGreaterElement3.nextGreaterElement(101) shouldEqual 110
    NextGreaterElement3.nextGreaterElement(132) shouldEqual 213
    NextGreaterElement3.nextGreaterElement(222) shouldEqual -1
    NextGreaterElement3.nextGreaterElement(321) shouldEqual -1
    NextGreaterElement3.nextGreaterElement(1234) shouldEqual 1243
    NextGreaterElement3.nextGreaterElement(1279865444) shouldEqual 1284445679
    NextGreaterElement3.nextGreaterElement(1219865444) shouldEqual 1241445689
    NextGreaterElement3.nextGreaterElement(2147483647) shouldEqual -1   // Int.MaxValue overflow
  }
}
