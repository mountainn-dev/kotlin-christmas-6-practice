package christmas

import christmas.controller.OrderController
import christmas.controller.VisitDayController

class EventPlanner {
    private val visitDayController = VisitDayController()
    private val orderController = OrderController()

    fun run() {
        selectVisitDay()
        order()
    }

    private fun selectVisitDay() {
        visitDayController.select()
    }

    private fun order() {
        orderController.order()
    }
}