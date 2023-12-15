package christmas.controller

import christmas.InputView
import christmas.domain.Order
import christmas.state.ControllerState.*
import java.lang.IllegalArgumentException

class OrderController {
    private val inputView = InputView()
    private lateinit var orders: List<Order>
    private var controllerState = NORMAL

    fun order() {
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
        setValidOrders()
    }

    private fun setValidOrders() {
        do {
            setOrders()
        } while (isControllerOnError())
    }

    private fun setOrders() {
        try {
            this.orders = readOrders()
            controllerState = NORMAL
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            controllerState = ERROR
        }
    }

    private fun readOrders() = inputView.readOrders()

    private fun isControllerOnError() = controllerState == ERROR
}