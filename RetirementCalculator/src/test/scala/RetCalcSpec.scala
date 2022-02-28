import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.{Matchers, WordSpec}

class RetCalcSpec extends WordSpec with Matchers {

  implicit val doubleTolerance: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.0001)

  "RetCalc.futureCapital" should {
    "calculate the amount of savings I will have in n months" in {
      val actual = RetCalc.futureCapital(
        interestRate = 0.04 / 12,
        nbOfMonths = 25 * 12,
        netIncome = 3000,
        currentExpenses = 2000,
        initialCapital = 10000)
      val expected = 541267.1990
      actual should ===(expected)
    }
    "calculate how much savings will be left after having taken a pension for n months" in {
      val actual = RetCalc.futureCapital(
        interestRate = 0.04 / 12,
        nbOfMonths = 40 * 12,
        netIncome = 0,
        currentExpenses = 2000,
        initialCapital = 541267.1990
      )
      val expected = 309867.5316
      actual should ===(expected)
    }
    "calculate the capital after retirement and capital after death" in {
      val (capitalAtRetirement, capitalAfterDeath) = RetCalc.simulatePlan(
        interestRate = 0.04 / 12,
        nbOfMonthsSaving = 25 * 12,
        nbOfMonthsInRetirement = 40 * 12,
        netIncome = 3000,
        currentExpenses = 2000,
        initialCapital = 10000
      )
      capitalAtRetirement should ===(541267.1990)
      capitalAfterDeath should ===(309867.5316)
    }
    "calculate how long I need to save before I can retire" in {
      val actual = RetCalc.nbOfMonthsSaving(
        interestRate = 0.04 / 12,
        nbOfMonthsInRetirement = 40 * 12,
        netIncome = 3000,
        currentExpenses = 2000,
        initialCapital = 10000
      )

      val expected = 23 * 12 + 1
      actual should ===(expected)
    }
    "not crash when the resulting nbOfMonthsSaving is very high" in {
      val actual = RetCalc.nbOfMonthsSaving(
        interestRate = 0.01 / 12,
        nbOfMonthsInRetirement = 40 * 12,
        netIncome = 3000,
        currentExpenses = 2999,
        initialCapital = 0
      )
      val expected = 8280
      actual should ===(expected)
    }
    "not loop forever if I enter bad parameters" in {
      val actual = RetCalc.nbOfMonthsSaving(
        interestRate = 0.04 / 12,
        nbOfMonthsInRetirement = 40 * 12,
        netIncome = 1000,
        currentExpenses = 2000,
        initialCapital = 10000
      )

      actual should ===(Int.MaxValue)
    }
  }
}
