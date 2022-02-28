object RetCalc {
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

}
