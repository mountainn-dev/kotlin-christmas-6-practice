package christmas

import camp.nextstep.edu.missionutils.Console
import christmas.domain.Menu
import christmas.domain.Order
import christmas.domain.VisitDay
import java.lang.IllegalArgumentException

class InputView {
    private val inputValidator = InputValidator()

    fun readVisitDay() = VisitDay(validatedAsDay(read()))

    private fun validatedAsDay(input: String): Int {
        inputValidator.isNotBlank(input)
        inputValidator.hasNotBlank(input)

        return input.toInt()
    }

    fun readOrders() = validatedAsOrders(read())

    private fun validatedAsOrders(input: String): List<Order> {   // TODO: 리팩
        val orders = mutableListOf<Order>()

        inputValidator.isNotBlank(input)
        inputValidator.hasNotBlank(input)

        if (input.contains(",")) {
            input.split(",").map { orders.add(Order(menuFrom(it), countFrom(it))) }
        } else {
            orders.add(Order(menuFrom(input), countFrom(input)))
        }

        validateAsOrders(orders)
        return orders
    }

    private fun validateAsOrders(orders: List<Order>) {
        require(orders.sumOf { it.count() } <= 20)
        require(!orders.all { it.isDrink() })
        require(orders.count { it.isAppetizer() } < 2)
        require(orders.count { it.isMainDish() } < 2)
        require(orders.count { it.isDessert() } < 2)
        require(orders.count { it.isDrink() } < 2)
    }

    private fun menuFrom(input: String): Menu {
        inputValidator.hasOrderDivider(input)
        val menuName = input.split("-")[0]

        inputValidator.isNotBlank(menuName)
        inputValidator.hasNotBlank(menuName)
        return Menu.values().find { it.isSame(menuName) } ?: throw IllegalArgumentException()
    }

    private fun countFrom(input: String): Int {
        val count = input.split("-")[1]
        inputValidator.isNotBlank(count)
        inputValidator.hasNotBlank(count)
        inputValidator.isDigit(count)

        return count.toInt()
    }

    private fun read() = Console.readLine()
}