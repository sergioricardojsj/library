package io.gers.library.domain.book

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SearchBook {

    operator fun invoke(id: Long): Book

    fun findAllBooks(pageable: Pageable): Page<Book>

}