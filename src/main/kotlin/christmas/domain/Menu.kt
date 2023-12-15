package christmas.domain

enum class Menu(private val menuName: String, private val price: Int) {
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    SIZER_SALAD("시저샐러드", 8000),
    T_BORN_STEAK("티본스테이크", 55000),
    BARBEQUE_LIP("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    XMAS_PASTA("크리스마스파스타", 25000),
    CHOCO_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000),
    ZERO_COKE("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);

    fun isSame(name: String) = this.menuName == name

    fun price() = this.price
}