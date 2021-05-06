package dec.week2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Dec_02_01_PairsOfSongsTest extends AnyFlatSpec with Matchers {
  "numPairsDivisibleBy60" should "return number of pairs multiple of 60" in {
    Dec_02_01_PairsOfSongs.numPairsDivisibleBy60(Array(30, 20, 150, 100, 40)) shouldEqual 3
    Dec_02_01_PairsOfSongs.numPairsDivisibleBy60(Array(60, 60, 60)) shouldEqual 3
    Dec_02_01_PairsOfSongs.numPairsDivisibleBy60(Array(60)) shouldEqual 0
  }

}
