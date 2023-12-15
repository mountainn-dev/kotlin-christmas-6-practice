package christmas.domain

class VisitDay(private val day: Int) {

    init {
        require(day in 1..31)
    }
}