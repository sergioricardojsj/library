package io.gers.library.application.controllers.book.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PageBookResponse(
    @JsonProperty("total_pages")
    val totalPages: Int,
    val size: Int,
    val books: List<BookResponse>
)
