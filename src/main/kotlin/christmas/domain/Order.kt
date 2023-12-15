package christmas.domain

import christmas.domain.Category.*

class Order(private val menu: Menu, private val count: Int) {

    fun isAppetizer() = APPETIZER.contains(menu)

    fun isMainDish() = MAIN_DISH.contains(menu)

    fun isDessert() = DESSERT.contains(menu)

    fun isDrink() = DRINK.contains(menu)
}