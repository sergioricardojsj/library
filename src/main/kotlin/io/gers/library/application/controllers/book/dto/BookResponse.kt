package io.gers.library.application.controllers.book.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

class BookResponse(
    @JsonProperty("book_id")
    val bookId: Long,
    val title: String
) : Serializable