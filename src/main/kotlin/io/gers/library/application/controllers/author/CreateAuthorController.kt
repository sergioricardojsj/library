package io.gers.library.application.controllers.author

import io.gers.library.application.controllers.author.dto.AuthorRequest
import io.gers.library.application.controllers.author.dto.AuthorResponse
import io.gers.library.domain.author.CreateAuthor
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authors")
class CreateAuthorController(
    private val createAuthor: CreateAuthor
) {

    @PostMapping
    fun save(@RequestBody @Valid request: AuthorRequest): ResponseEntity<AuthorResponse> {
        var author = request.toAuthor()
        author = createAuthor(author)

        return ResponseEntity.ok(AuthorResponse(id = author.id, name = author.name))
    }

}