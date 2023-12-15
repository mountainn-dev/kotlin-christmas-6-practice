package christmas

import camp.nextstep.edu.missionutils.Console
import christmas.domain.Order
import christmas.domain.VisitDay

class InputView {
    private val inputValidator = InputValidator()

    fun readVisitDay() = VisitDay(validatedAsDay(read()))

    private fun validatedAsDay(input: String): Int {
        inputValidator.isNotBlank(input)
        inputValidator.hasNotBlank(input)

        return input.toInt()
    }

    fun readOrders() = validatedAsOrders(read())

    private fun validatedAsOrders(input: String): List<Order> {
        val orders = mutableListOf<Order>()

        input.split(",").map { orders.add(Order(menuFrom(input), countFrom(input))) }

        return orders
    }

    private fun menuFrom(input: String) = input.split("-")[0]

    private fun countFrom(input: String) = input.split("-")[1]

    private fun read() = Console.readLine()
}