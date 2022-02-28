import scala.annotation.tailrec

object RetCalc {

  /** Return the retirement capital given parameters
   * The capital is calculated based on formula:
   *     capital of month n = capital of month (n - 1) * (1 + interest rate) + monthly savings
   *     (monthly savings = monthly income - monthly expenses)
   * @param interestRate interest rate of each month
   * @param nbOfMonths number of months to work
   * @param netIncome total income in one month
   * @param currentExpenses total expense in a month
   * @param initialCapital the initial amount of money
   * @return the final amount of money (capital) user will have when he retires.
   */
  def futureCapital(interestRate: Double,
                    nbOfMonths: Int,
                    netIncome:Int,
                    currentExpenses: Int,
                    initialCapital: Double): Double = {

    val monthlySavings = netIncome - currentExpenses

    (0 until nbOfMonths).foldLeft(initialCapital)(
      (accumulated, _) => accumulated * (1 + interestRate) + monthlySavings
    )
  }

  /** Return a Tuple2 that contains two capitals: one at retirement and one remaining after death
   *
   *
   * @param interestRate interest rate of each month
   * @param nbOfMonthsSaving number of months to work
   * @param nbOfMonthsInRetirement number of months user will live after retirement
   * @param netIncome total income in one month
   * @param currentExpenses total expense in a month
   * @param initialCapital the initial amount of money
   * @return Tuple2(capitalAtRetirement, capitalAfterDeath)
   */
  def simulatePlan(interestRate: Double,
                   nbOfMonthsSaving: Int,
                   nbOfMonthsInRetirement: Int,
                   netIncome: Int,
                   currentExpenses: Int,
                   initialCapital: Int): (Double, Double) =  {
    val capitalAtRetirement = futureCapital(interestRate = interestRate,
      nbOfMonths = nbOfMonthsSaving,
      netIncome = netIncome,
      currentExpenses = currentExpenses,
      initialCapital = initialCapital
    )

    val capitalAfterDeath = futureCapital(interestRate = interestRate,
      nbOfMonths = nbOfMonthsInRetirement,
      netIncome = 0,
      currentExpenses = currentExpenses,
      initialCapital = capitalAtRetirement
    )

    (capitalAtRetirement, capitalAfterDeath)
  }

  /** Return the number of months to work before retirement
   *
   * @param interestRate interest rate of each month
   * @param nbOfMonthsInRetirement number of months user will live after retirement
   * @param netIncome total income in one month
   * @param currentExpenses total expense in a month
   * @param initialCapital the initial amount of money
   * @return
   */
  def nbOfMonthsSaving(interestRate: Double,
                       nbOfMonthsInRetirement: Int,
                       netIncome: Int,
                       currentExpenses: Int,
                       initialCapital: Int): Int = {

    @tailrec
    def loop(months: Int): Int = {
      val (_, capitalAfterDeath) = RetCalc.simulatePlan(
        interestRate = interestRate,
        nbOfMonthsSaving = months,
        nbOfMonthsInRetirement = nbOfMonthsInRetirement,
        netIncome = netIncome,
        currentExpenses = currentExpenses,
        initialCapital = initialCapital
      )

      if (capitalAfterDeath > 0.0) {
        months
      } else {
        loop(months + 1)
      }
    }

    if (netIncome < currentExpenses) {
      Int.MaxValue
    } else {
      loop(0)
    }
  }
}
