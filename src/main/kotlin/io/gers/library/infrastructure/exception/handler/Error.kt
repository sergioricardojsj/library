package io.gers.library.infrastructure.exception.handler

open class Error(
    open val message: String,
    open val timestamp: String
)

open class BeanError(
    override val message: String,
    override val timestamp: String,
    val fieldErrors: List<FieldError>
) : Error(message, timestamp)

data class FieldError(
    val defaultMessage: String,
    val field: String
)