package io.gers.library.infrastructure.exception.handler

import io.gers.library.infrastructure.exception.ObjectNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class ObjectNotFoundExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException::class)
    fun handle(exception: ObjectNotFoundException): ResponseEntity<Error> {
        val error = Error(exception.message, LocalDateTime.now().toString())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error)
    }

}