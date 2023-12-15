package christmas

class InputValidator {

    fun isNotBlank(input: String) {
        require(input.isNotBlank())
    }

    fun hasNotBlank(input: String) {
        require(!input.contains(" "))
    }

    fun hasWordsDivider(input: String) {
        require(input.contains(","))
    }
}