package christmas.domain

enum class Event(private val eventName: String, private val value: Int) {
    D_DAY_EVENT("크리스마스 디데이 할인", 1000),
    WEEKDAY_EVENT("평일 할인", 2023),
    WEEKEND_EVENT("주말 할인", 2023),
    SPECIAL_EVENT("특별 할인", 1000),
    FREEBIE_EVENT("증정 이벤트", 25000);
    fun value() = this.value
}