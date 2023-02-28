package io.gers.library.infrastructure.exception.handler

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class ValidationExceptionHandler {

    private val logger = LoggerFactory.getLogger(ValidationExceptionHandler::class.java)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(exception: MethodArgumentNotValidException): ResponseEntity<BeanError> {
        val errors = exception.fieldErrors.map { FieldError(it.field, it.defaultMessage!!) }
        val error = BeanError("there are errors in some fields", LocalDateTime.now().toString(), errors)

        return ResponseEntity.badRequest().body(error).also {
            logger.info("FIELD_ERROR > ${error.message}")
        }
    }

}