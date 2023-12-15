package christmas.domain

import christmas.domain.Category.*

class Order(private val menu: Menu, private val count: Int) {

    init {
        require(count >= 1)
    }

    fun isAppetizer() = APPETIZER.contains(menu)

    fun isMainDish() = MAIN_DISH.contains(menu)

    fun isDessert() = DESSERT.contains(menu)

    fun isDrink() = DRINK.contains(menu)

    fun count() = this.count

    fun total() = menu.price() * this.count
}