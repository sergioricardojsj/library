package io.gers.library.domain.book

interface CreateBook {

    operator fun invoke(book: Book, authorId: Long): Book

}