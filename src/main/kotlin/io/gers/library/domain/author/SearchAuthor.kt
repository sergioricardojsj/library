package io.gers.library.domain.author

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
interface SearchAuthor {

    fun searchById(id: Long): Author

    fun searchAllAuthors(pageable: Pageable): Page<Author>

}