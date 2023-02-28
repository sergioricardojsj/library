package io.gers.library.domain.author

interface CreateAuthor {

    operator fun invoke(author: Author): Author

}