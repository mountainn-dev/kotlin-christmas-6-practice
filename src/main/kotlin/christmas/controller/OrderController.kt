package christmas.controller

import christmas.InputView
import christmas.domain.Order

class OrderController {
    private val inputView = InputView()
    private lateinit var orders: List<Order>

    fun order() {
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
        setOrders()
    }

    private fun setOrders() {
        this.orders = readOrders()
    }

    private fun readOrders() = inputView.readOrders()

}