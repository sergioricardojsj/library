package io.gers.library.application.controllers.author.dto

import com.fasterxml.jackson.annotation.JsonProperty

class PageAuthorResponse(
    @JsonProperty("total_pages")
    val totalPages: Int,
    val size: Int,
    val authors: List<AuthorResponse>
)