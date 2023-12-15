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

    private fun applyPromotion(visitDay: VisitDay, orders: List<Order>) {
        if (visitDay.isWeekDay()) weekDayPromotion(orders)
        if (visitDay.isWeekEnd()) weekEndPromotion(orders)
        if (visitDay.isSpecial()) specialPromotion()
        if (!visitDay.isAfterXmas()) dDayPromotion(visitDay)
        if (orders.sumOf { it.total() } >= 120000) freebiePromotion()
    }

    private fun weekDayPromotion(orders: List<Order>) {
        var count = 0

        orders.map { if (it.isDessert()) count += it.count() }

        promotions.add(Promotion(WEEKDAY_EVENT, WEEKDAY_EVENT.value() * count))
    }

    private fun weekEndPromotion(orders: List<Order>) {
        var count = 0

        orders.map { if (it.isMainDish()) count += it.count() }

        promotions.add(Promotion(WEEKEND_EVENT, WEEKEND_EVENT.value() * count))
    }

    private fun specialPromotion() {
        promotions.add(Promotion(SPECIAL_EVENT, SPECIAL_EVENT.value()))
    }

    private fun dDayPromotion(visitDay: VisitDay) {
        val dDay = visitDay.dayUntilXmas()

        promotions.add(Promotion(D_DAY_EVENT, D_DAY_EVENT.value() + ((24 - dDay) * 100)))
    }

    private fun freebiePromotion() {
        promotions.add(Promotion(FREEBIE_EVENT, FREEBIE_EVENT.value()))
    }
}