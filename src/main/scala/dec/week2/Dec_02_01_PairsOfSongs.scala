package dec.week2

/**
  * author https://github.com/EugeneYushin
  * https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3559/
  */
object Dec_02_01_PairsOfSongs {
  def numOfCombinationsBy2(n: Int): Int = (n - 1) * n / 2

  def numPairsDivisibleBy60(time: Array[Int]): Int = {
    val modTimeSorted = time.map(i => i % 60).sorted
    val remainders = modTimeSorted.groupMapReduce(identity)(_ => 1)(_ + _)

    val sumOfDurationsExcept30 = modTimeSorted.takeWhile(_ < 30)
      .map(secs => remainders.getOrElse(60 - secs, 0))
      .sum

    // number of songs that have 0 reminder, ie 60/120/180/...
    val sum0 = remainders.getOrElse(0, 0)
    // number of 30 secs songs
    val sum30 = remainders.getOrElse(30, 0)

    sumOfDurationsExcept30 + numOfCombinationsBy2(sum0) + numOfCombinationsBy2(sum30)
  }

  def numPairsDivisibleBy60_2(time: Array[Int]): Int = {
    import scala.math.Integral.Implicits._

    val m = Array.fill(60)(0)
    var result = 0
    for(t <- time) {
      val (_, rem) = t /% 60
      if(rem == 0) {
        result += m(0)
      } else {
        result += m(60 - rem)
      }
      m(rem) = m(rem) + 1
    }

    result
  }
}
