package christmas.controller

import christmas.InputView
import christmas.domain.VisitDay
import christmas.state.ControllerState.*
import java.lang.IllegalArgumentException

class VisitDayController {
    private val inputView = InputView()
    private lateinit var visitDay: VisitDay
    private var controllerState = NORMAL

    fun select() {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        setValidVisitDay()
    }

    private fun setValidVisitDay() {
        do {
            setVisitDay()
        } while (isControllerOnError())
    }

    private fun setVisitDay() {
        try {
            this.visitDay = readVisitDay()
            controllerState = NORMAL
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 방문 날짜는 1 이상 31 이하의 숫자만 입력 가능합니다.")
            controllerState = ERROR
        }
    }

    private fun readVisitDay() = inputView.readVisitDay()

    private fun isControllerOnError() = controllerState == ERROR
}