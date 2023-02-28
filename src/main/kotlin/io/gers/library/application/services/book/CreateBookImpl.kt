package io.gers.library.application.services.book

import io.gers.library.domain.author.SearchAuthor
import io.gers.library.domain.book.Book
import io.gers.library.domain.book.CreateBook
import io.gers.library.infrastructure.data.BookRepository
import org.springframework.stereotype.Service

@Service
class CreateBookImpl(
    val bookRepository: BookRepository,
    val searchAuthor: SearchAuthor
) : CreateBook {

    override fun invoke(book: Book, authorId: Long): Book {
        val author = searchAuthor.searchById(authorId)
        book.authors = listOf(author)
        return bookRepository.save(book)
    }

}