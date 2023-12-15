package christmas.domain

import christmas.domain.Menu.*

enum class Category(private val menus: List<Menu>) {
    APPETIZER(listOf(MUSHROOM_SOUP, TAPAS, SIZER_SALAD)),
    MAIN_DISH(listOf(T_BORN_STEAK, BARBEQUE_LIP, SEAFOOD_PASTA, XMAS_PASTA)),
    DESSERT(listOf(CHOCO_CAKE, ICE_CREAM)),
    DRINK(listOf(ZERO_COKE, RED_WINE, CHAMPAGNE));

    fun contains(menu: Menu) = menus.contains(menu)
}