package christmas

import christmas.controller.OrderController
import christmas.controller.PromotionController
import christmas.controller.VisitDayController

class EventPlanner {
    private val visitDayController = VisitDayController()
    private val orderController = OrderController()
    private val promotionController = PromotionController()

    fun run() {
        selectVisitDay()
        order()
        applyPromotion()
    }

    private fun selectVisitDay() {
        visitDayController.select()
    }

    private fun order() {
        orderController.order()
    }

    private fun applyPromotion() {
        promotionController.apply(visitDayController.get(), orderController.get())
    }
}