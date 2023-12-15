package christmas

import camp.nextstep.edu.missionutils.Console
import christmas.domain.VisitDay

class InputView {
    private val inputValidator = InputValidator()

    fun readVisitDay() = VisitDay(validatedAsDay(read()))

    private fun validatedAsDay(input: String): Int {
        inputValidator.isNotBlank(input)
        inputValidator.hasNotBlank(input)

        return input.toInt()
    }

    private fun read() = Console.readLine()
}