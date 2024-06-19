package data.util

class NullServerResponseException : Throwable() {
    override val message: String
        get() = "Could not get response"
}