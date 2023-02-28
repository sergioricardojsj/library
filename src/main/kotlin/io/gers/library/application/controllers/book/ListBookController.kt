package io.gers.library.application.controllers.book

import io.gers.library.application.controllers.author.dto.AuthorResponse
import io.gers.library.application.controllers.book.dto.BookResponse
import io.gers.library.application.controllers.book.dto.PageBookResponse
import io.gers.library.domain.book.SearchBook
import jakarta.servlet.http.HttpServletResponse
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/books")
class ListBookController(
    private val searchBook: SearchBook
) {

    @GetMapping
    fun findAll(
        @RequestParam(value = "page", defaultValue = "1") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        builder: UriComponentsBuilder,
        response: HttpServletResponse
    ): ResponseEntity<PageBookResponse> {
        val page = searchBook.findAllBooks(Pageable.ofSize(size))
        val books = page.content.map { BookResponse(it.id, it.title) }
        return ResponseEntity.ok(PageBookResponse(totalPages = page.totalPages, size = page.size, books = books))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<BookResponse> {
        val book = searchBook(id)
        return ResponseEntity.ok(BookResponse(book.id, book.title))
    }


}