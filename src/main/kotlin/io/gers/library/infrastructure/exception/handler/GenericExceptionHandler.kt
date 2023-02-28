package io.gers.library.infrastructure.exception.handler

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class GenericExceptionHandler {

    //@ExceptionHandler(RuntimeException::class)
    fun handle(exception: Exception): ResponseEntity<Error> {
        val error = Error("An error has occurred", LocalDateTime.now().toString())
        return ResponseEntity.internalServerError().body(error)
    }

}