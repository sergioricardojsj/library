package io.gers.library.application.controllers.book

import io.gers.library.application.controllers.book.dto.BookRequest
import io.gers.library.application.controllers.book.dto.BookResponse
import io.gers.library.domain.book.CreateBook
import jakarta.validation.Valid
import jakarta.validation.executable.ValidateOnExecution
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@ValidateOnExecution
@RestController
@RequestMapping("/books")
class CreateBookController(
    private val createBook: CreateBook
) {

    @PostMapping
    fun create(@Valid @RequestBody request: BookRequest): ResponseEntity<BookResponse> {
        val book = createBook(request.toBook(), request.authorId)
        return ResponseEntity.ok(BookResponse(bookId = book.id, title = book.title))
    }

}