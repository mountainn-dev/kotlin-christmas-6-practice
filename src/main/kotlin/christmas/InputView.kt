package christmas

import camp.nextstep.edu.missionutils.Console
import christmas.domain.VisitDay

class InputView {

    fun readVisitDay() = VisitDay(read().toInt())

    private fun read() = Console.readLine()
}