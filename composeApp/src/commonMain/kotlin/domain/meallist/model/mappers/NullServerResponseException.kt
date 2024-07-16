package domain.meallist.model.mappers

class NullServerResponseException : Throwable() {
    override val message: String
        get() = "Could not get response"
}