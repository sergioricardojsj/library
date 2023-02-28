package io.gers.library.application.controllers.author.dto

import io.gers.library.domain.author.Author
import jakarta.validation.constraints.NotEmpty

data class AuthorRequest(
    @NotEmpty val name: String
) {

    fun toAuthor(): Author {
        return Author(
            id = 0,
            name = name
        )
    }

}
