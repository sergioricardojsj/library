package io.gers.library.application.services.book

import io.gers.library.domain.book.Book
import io.gers.library.domain.book.SearchBook
import io.gers.library.infrastructure.data.BookRepository
import io.gers.library.infrastructure.exception.ObjectNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SearchBookImpl(
    private val bookRepository: BookRepository
) : SearchBook {

    override fun invoke(id: Long): Book {
        return bookRepository.findById(id)
            .orElseThrow { ObjectNotFoundException("Book not found!") }
    }

    override fun findAllBooks(pageable: Pageable): Page<Book> {
        return bookRepository.findAll(pageable)
    }

}