package christmas.controller

import christmas.InputView
import christmas.domain.VisitDay

class VisitDayController {
    private val inputView = InputView()
    private lateinit var visitDay: VisitDay

    fun select() {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        setVisitDay()
    }

    private fun setVisitDay() {
        this.visitDay = readVisitDay()
    }

    private fun readVisitDay() = inputView.readVisitDay()
}