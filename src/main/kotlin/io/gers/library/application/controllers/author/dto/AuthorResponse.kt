package io.gers.library.application.controllers.author.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthorResponse(
    @JsonProperty("author_id")
    val id: Long,
    val name: String
)