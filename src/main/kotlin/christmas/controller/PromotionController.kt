package christmas.controller

import christmas.domain.Event.*
import christmas.domain.Order
import christmas.domain.Promotion
import christmas.domain.VisitDay

class PromotionController {
    private val promotions = mutableListOf<Promotion>()


    fun apply(visitDay: VisitDay, orders: List<Order>) {
        if (orders.sumOf { it.total() } > 10000) applyPromotion(visitDay, orders)
    }


}