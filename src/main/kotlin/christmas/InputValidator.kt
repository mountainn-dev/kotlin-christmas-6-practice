package christmas

class InputValidator {

    fun isNotBlank(input: String) {
        require(input.isNotBlank())
    }

    fun hasNotBlank(input: String) {
        require(!input.contains(" "))
    }

    fun hasOrderDivider(input: String) {
        require(input.contains("-"))
    }

    fun isDigit(input: String) {
        require(!input.map { Character.isDigit(it) }.contains(false))
    }
}