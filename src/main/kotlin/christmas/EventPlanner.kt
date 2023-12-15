package christmas

import christmas.controller.VisitDayController

class EventPlanner {
    private val visitDayController = VisitDayController()

    fun run() {
        selectVisitDay()
    }

    private fun selectVisitDay() {
        visitDayController.select()
    }
}