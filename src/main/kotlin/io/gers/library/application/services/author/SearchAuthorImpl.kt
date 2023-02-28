package io.gers.library.application.services.author

import io.gers.library.domain.author.Author
import io.gers.library.domain.author.SearchAuthor
import io.gers.library.infrastructure.data.AuthorRepository
import io.gers.library.infrastructure.exception.ObjectNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class SearchAuthorImpl(
    val authorRepository: AuthorRepository
) : SearchAuthor {

    override fun searchById(id: Long): Author {
        return authorRepository.findById(id)
            .orElseThrow { ObjectNotFoundException("Author not found") }
    }

    override fun searchAllAuthors(pageable: Pageable): Page<Author> {
        return authorRepository.findAll(pageable)
    }

}