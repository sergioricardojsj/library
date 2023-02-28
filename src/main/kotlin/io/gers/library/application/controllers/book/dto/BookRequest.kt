package io.gers.library.application.controllers.book.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.gers.library.domain.book.Book
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.io.Serializable

data class BookRequest(
    @field:NotEmpty(message = "title must not be empty")
    val title: String,

    @field:Min(value = 1, message = "page size must be at least 1")
    @field:NotNull(message = "pages must not be null")
    val pages: Int,

    @field:Min(value = 1, message = "chapter size must be at least 1")
    @field:NotNull(message = "chapters must not be null")
    val chapters: Int,

    @JsonProperty("author_id")
    @field:NotNull(message = "author id must not be null")
    val authorId: Long
) : Serializable {

    fun toBook(): Book {
        return Book(
            id = 0,
            title = title,
            pages = pages,
            chapters = chapters
        )
    }

}