package io.gers.library.application.services.author

import io.gers.library.domain.author.Author
import io.gers.library.domain.author.CreateAuthor
import io.gers.library.infrastructure.data.AuthorRepository
import org.springframework.stereotype.Service

@Service
class CreateAuthorImpl(
    private val authorRepository: AuthorRepository,
) : CreateAuthor {

    override fun invoke(author: Author): Author {
        return authorRepository.save(author)
    }

}